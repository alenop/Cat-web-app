package com.atelier.CatWebApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.javatuples.Pair;

import com.atelier.CatWebApp.model.Cat;

public class CatController {
	private FileController fileController;
	private HashMap<String, Cat> Cats;
	private int nbAllVote;

	public int getNbAllVote() {
		return nbAllVote;
	}
	public CatController() {
		this.fileController = new FileController();
		try {
			this.Cats = fileController.loadCats("https://latelier.co/data/cats.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Pair<String, String>> getCats() {
		return choose();
	}

	public Cat getCat(String ID) {
		return Cats.get(ID);
	}
	public ArrayList<Pair<String,String>> choose(){
		if (nbAllVote<50) {
			return chooseRandomCats();
		}else {
			return chooseRandomCatsWithEqualsVotes();
		}
	}
	public ArrayList<Pair<String, String>> chooseRandomCatsWithEqualsVotes() {
		ArrayList<Pair<String, String>> catsToCompare = new ArrayList<>();
		int i = 0;
		Random generator = new Random();
		Object[] values = Cats.values().toArray();

		Cat	Cat1 = (Cat) values[generator.nextInt(values.length)];	
		//int nbCat1 = (int) (Math.random() * Cats.size());
		int nbVoteOfCat1 = Cat1.getVote();
		Cat Cat2;
		do {
			Cat2 = (Cat) values[generator.nextInt(values.length)];
			
		} while (Cat1.equals(Cat2) || nbVoteOfCat1 != Cat2.getVote() );
		
		
		catsToCompare.add(new Pair<String,String>(Cat1.getID(), Cat1.getSrcImage()));
		catsToCompare.add(new Pair<String,String>(Cat2.getID(), Cat2.getSrcImage()));
		
		return catsToCompare;
		//need two pair with each pair giving
		//the ID then The link of the image
	}
	public ArrayList<Pair<String, String>> chooseRandomCats() {
		ArrayList<Pair<String, String>> catsToCompare = new ArrayList<>();
		int i = 0;
		int nbCat1 = (int) (Math.random() * Cats.size());
		int nbCat2;
		do {
			nbCat2 = (int) (Math.random() * Cats.size());
		} while (nbCat1 == nbCat2);

		for (Entry<String, Cat> cat : Cats.entrySet()) {
			if (nbCat1 == i || nbCat2 == i) {
				catsToCompare.add(new Pair<String, String>(cat.getKey(),//ID
						cat.getValue().getSrcImage()));//Link Image
			}
			i++;
		}
		return catsToCompare;
		//need two pair with each pair giving
		//the ID then The link of the image
	}

	public void voteCat(String ID) {
		Cats.get(ID).Vote();
		nbAllVote++;
	}

	public ArrayList<Pair<Integer, String>> getAllCats() {
		ArrayList<Pair<Integer, String>> cats = new ArrayList<>();
		if (Cats == null) {
			return null;
		}
		for (Entry<String, Cat> cat : Cats.entrySet()) {
			cats.add(new Pair<Integer, String>(cat.getValue().getVote(), cat.getValue().getSrcImage()));
		}
		arrange(cats);
		return cats;
	}

	public void arrange(ArrayList<Pair<Integer, String>> cats) {
		cats.sort(new SortByVote());
	}

	class SortByVote implements Comparator<Pair<Integer, String>> {

		// Method
		// Sorting in descending order of vote number
		public int compare(Pair<Integer, String> a, Pair<Integer, String> b) {

			return b.getValue0() - a.getValue0();
		}
	}
}
