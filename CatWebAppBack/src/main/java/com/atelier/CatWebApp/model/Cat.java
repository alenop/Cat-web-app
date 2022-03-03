package com.atelier.CatWebApp.model;

public class Cat {
	private int nbVote;
	private String image;
	private String ID;

	public Cat(String image,String ID) {
		this.image = image;
		this.nbVote = 0;
		this.ID=ID;
	}
	public String getID() {
		return ID;
	}
	public String getSrcImage() {
		return image;
	}

	public int getVote() {
		return nbVote;
	}

	public void Vote() {
		this.nbVote++;
	}
}
