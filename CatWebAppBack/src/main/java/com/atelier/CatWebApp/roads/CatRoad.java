package com.atelier.CatWebApp.roads;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atelier.CatWebApp.controller.MainController;

import java.util.ArrayList;

import org.javatuples.Pair;

@RestController()
@RequestMapping("/cat")
public class CatRoad {
    private MainController mainController;

    @GetMapping("/Get")
    public ResponseEntity<ArrayList<Pair<String,String>>> giveCats(){
    	ArrayList<Pair<String,String>> CatsToCompare = mainController.getCats();
        if(CatsToCompare.size()==2) {
        	return new ResponseEntity<>(CatsToCompare,HttpStatus.ACCEPTED);
        }
        else {
        	return new ResponseEntity<>(CatsToCompare,HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping("/VoteCat/{ID}")
    public void voteCat(@PathVariable String ID) {
    	mainController.voteCat(ID);
    }
}
