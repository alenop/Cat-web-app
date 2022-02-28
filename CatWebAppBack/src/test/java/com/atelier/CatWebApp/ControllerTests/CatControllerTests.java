package com.atelier.CatWebApp.ControllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import com.atelier.CatWebApp.controller.CatController;

public class CatControllerTests {
	
	@Test
	public void shouldHaveOnlyTwoElements() {
		CatController catController = new CatController();
		
		ArrayList<Pair<String, String>> cats = catController.choose();
		
		assertEquals(2 , cats.size());
	}
}
