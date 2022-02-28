package com.atelier.CatWebApp.ControllerTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import com.atelier.CatWebApp.controller.FileController;
import com.atelier.CatWebApp.model.Cat;

import org.junit.jupiter.api.Test;

public class FileControllerTests {
    
    @Test
    public void shouldGetCats(){
        FileController fc = new FileController();
        HashMap<String,Cat> Cats=null;
        try {
            Cats = fc.loadCats("https://latelier.co/data/cats.json");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(Cats!=null);
    }
}
