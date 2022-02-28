package com.atelier.CatWebApp.model;

public class Cat {
    private int nbVote;
    private String image;


    public Cat(String image){
        this.image=image;
        this.nbVote=0;
    }
    public String getSrcImage(){
        return image;
    }
    public int getVote(){
        return nbVote;
    }
    public void Vote(){
        this.nbVote++;
    }
}
