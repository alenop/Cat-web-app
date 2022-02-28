package com.atelier.CatWebApp.ControllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import com.atelier.CatWebApp.controller.CatController;
import com.atelier.CatWebApp.model.Cat;

public class CatControllerTests {
	
	@Test
	public void shouldHaveOnlyTwoElements() {
		CatController catController = new CatController();
		
		ArrayList<Pair<String, String>> cats = catController.choose();
		
		assertEquals(2 , cats.size());
	}
	
	@Test 
	public void shouldVoteForCat() {
		CatController catController = new CatController();
		ArrayList<Pair<String, String>> cats = catController.choose();
		String ID = cats.get(0).getValue0();
		Cat cat = catController.getCat(ID);
		int nbVote = cat.getVote();
		
		catController.voteCat(ID);
		
		assertEquals( nbVote+1,cat.getVote());
	}
	
	@Test 
	public void shouldArrange() {
		CatController catController = new CatController();
		ArrayList<Pair<String, String>> cats = catController.choose();
		String ID = cats.get(0).getValue0();
		String ID1 = cats.get(1).getValue0();
		
		catController.voteCat(ID);
		catController.voteCat(ID);
		catController.voteCat(ID1);
		catController.voteCat(ID1);
		catController.voteCat(ID1);
		
		ArrayList<Pair<Integer,String>> catsVote = new ArrayList<>();
		catsVote.add(new Pair(catController.getCat(ID).getVote(),"looser"));
		catsVote.add(new Pair(catController.getCat(ID1).getVote(),"winner"));
		catController.arrange(catsVote);
		
		assertEquals(3,catsVote.get(0).getValue0());
	}
}
