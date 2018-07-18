package com.example.formacio.studioghiblifilms.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.formacio.studioghiblifilms.R;
import com.example.formacio.studioghiblifilms.model.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    public static final String FILM_KEY = "film_key";
    private List<Film> mItems;
    private Context mContext;
    private SharedPreferences.OnSharedPreferenceChangeListener prefsListener;

    public FilmAdapter(Context context, List<Film> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View filmView = inflater.inflate(R.layout.list_film, parent, false);

        ViewHolder viewHolder = new ViewHolder(filmView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Film film = mItems.get(position);
        holder.tvName.setText(film.getTitle());
        holder.tvYear.setText(String.valueOf(film.getReleaseDate()));
    //    holder.imageView.setImageResource(R.drawable.unlike);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(FILM_KEY, film);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvYear;
        public ImageView imageView;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.filmNameText);
            tvYear = (TextView) itemView.findViewById(R.id.filmYeaText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mView = itemView;
        }
    }
}