package com.atelier.CatWebApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.atelier.CatWebApp.model.Cat;

import org.javatuples.Pair;

public class CatController {
    private FileController fileController;
    private HashMap<String,Cat> Cats;
    
    public CatController() {
    	this.fileController = new FileController();
    	try {
			this.Cats = fileController.loadCats("https://latelier.co/data/cats.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public ArrayList<Pair<String,String>> getCats(){
        return choose();
    }
    
    public  ArrayList<Pair<String,String>> choose() {
    	ArrayList<Pair<String,String>> catsToCompare = new ArrayList<>();
    	int i=0;
    	int nbCat1 = (int) (Math.random()*Cats.size());
    	int nbCat2;
    	do {
    		nbCat2 = (int) (Math.random()*Cats.size());
    	}while (nbCat1==nbCat2);
    	
    	for (Entry<String, Cat> cat : Cats.entrySet()) {
    		if(nbCat1 == i || nbCat2 == i) {
    			catsToCompare.add(new Pair(cat.getKey(),cat.getValue().getSrcImage()));
    		}
    		i++;
    	}
    	return catsToCompare;
    }
    public void voteCat(String id) {
    	Cats.get(id).Vote();
    }
}
