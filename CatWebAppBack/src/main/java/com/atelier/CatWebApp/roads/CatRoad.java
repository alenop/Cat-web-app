package com.atelier.CatWebApp.roads;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atelier.CatWebApp.controller.MainController;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cat")
public class CatRoad {
	private MainController mainController = new MainController();

	@GetMapping("/Get")
	public ResponseEntity<ArrayList<Pair<String, String>>> giveCats() {
		ArrayList<Pair<String, String>> CatsToCompare = mainController.getCats();
		if (CatsToCompare.size() == 2) {
			return new ResponseEntity<>(CatsToCompare, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(CatsToCompare, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/GetAll")
	public ResponseEntity<ArrayList<Pair<Integer, String>>> getAllCatsSorted() {
		ArrayList<Pair<Integer, String>> AllCats = mainController.getAllCats();
		if (AllCats != null) {
			return new ResponseEntity<>(AllCats, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AllCats, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping("/VoteCat/{ID}")
	public void voteCat(@PathVariable String ID) {
		mainController.voteCat(ID);
	}
}
