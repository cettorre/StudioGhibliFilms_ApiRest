package com.example.formacio.studioghiblifilms.controller;

import com.example.formacio.studioghiblifilms.model.Film;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static List<Film> films = new ArrayList<>();

    public static List<Film> getFilms() {
        return films;
    }
}
