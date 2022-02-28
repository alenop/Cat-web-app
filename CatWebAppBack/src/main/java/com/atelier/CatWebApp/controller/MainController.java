package com.atelier.CatWebApp.controller;

import java.util.ArrayList;

import org.javatuples.Pair;

public class MainController {
    private CatController catController;

    public  ArrayList<Pair<String,String>> getCats(){
        return catController.getCats();
    }
    public void voteCat(String ID) {
    	catController.voteCat(ID);
    }
}