package com.example.formacio.studioghiblifilms.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.formacio.studioghiblifilms.R;
import com.example.formacio.studioghiblifilms.controller.Controller;
import com.example.formacio.studioghiblifilms.model.Film;
import com.example.formacio.studioghiblifilms.services.MyIntentService;
import com.example.formacio.studioghiblifilms.utils.NetworkHelper;


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL =
            "https://ghibliapi.herokuapp.com/films";

    private boolean networkOk;
    List mFilmList;
    RecyclerView mRecyclerView;
    FilmAdapter filmAdapter;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Film[] films= (Film[]) intent.getParcelableArrayExtra(MyIntentService.MY_SERVICE_PAYLOAD);
            for (Film film :films) {

                Controller.getFilms().add(film);
                Log.e("film",film.toString());
            }
            mFilmList= Arrays.asList(films);
            Log.e("films",films.toString());
            displayDataItems(null);

        }
    };

    private void displayDataItems(String category) {
//        mItemList = mDataSource.getAllItems(category);
        if (Controller.getFilms() != null) {
            filmAdapter = new FilmAdapter(this, Controller.getFilms());
            mRecyclerView.setAdapter(filmAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyIntentService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);

        dispatchIntentToService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    public void dispatchIntentToService() {

        if (networkOk) {
            Intent intent = new Intent(this, MyIntentService.class);
            intent.setData(Uri.parse(JSON_URL));
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }


}
