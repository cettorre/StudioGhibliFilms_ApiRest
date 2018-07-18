package com.example.formacio.studioghiblifilms.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Film implements Parcelable {

    private boolean isFavourite;
    private String id;
    private String title;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String rt_score;
    private List<String> people = null;
    private List<String> species = null;
    private List<String> locations = null;
    private List<String> vehicles = null;
    private String url;

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRt_score() {
        return rt_score;
    }

    public void setRt_score(String rt_score) {
        this.rt_score = rt_score;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }





    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", release_date='" + release_date + '\'' +
                ", rt_score='" + rt_score + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isFavourite ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.director);
        dest.writeString(this.producer);
        dest.writeString(this.release_date);
        dest.writeString(this.rt_score);
        dest.writeStringList(this.people);
        dest.writeStringList(this.species);
        dest.writeStringList(this.locations);
        dest.writeStringList(this.vehicles);
        dest.writeString(this.url);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.isFavourite = in.readByte() != 0;
        this.id = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.director = in.readString();
        this.producer = in.readString();
        this.release_date = in.readString();
        this.rt_score = in.readString();
        this.people = in.createStringArrayList();
        this.species = in.createStringArrayList();
        this.locations = in.createStringArrayList();
        this.vehicles = in.createStringArrayList();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}