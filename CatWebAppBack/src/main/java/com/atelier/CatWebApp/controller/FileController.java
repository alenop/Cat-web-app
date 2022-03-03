package com.atelier.CatWebApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.CatWebApp.model.Cat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FileController {

	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private OkHttpClient client = new OkHttpClient();

	public HashMap<String, Cat> loadCats(String urlToCats) throws IOException {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Request request = new Request.Builder().url(urlToCats).build();
		try (Response response = client.newCall(request).execute()) {
			if (response.code() == 200) {
				LinkedHashMap<String, ArrayList<LinkedHashMap<String, String>>> data2 = objectMapper
						.readValue(response.body().byteStream(), LinkedHashMap.class);
				HashMap<String, Cat> cats = new HashMap<>();
				// System.out.println(data.getCats());
				if (data2.get("images").size() > 0) {
					for (LinkedHashMap<String, String> catsImages : data2.get("images")) {
						cats.put(catsImages.get("id"), new Cat(catsImages.get("url"),catsImages.get("id")));
					}
					return cats;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public OkHttpClient getClient() {
		return client;
	}

	public void setClient(OkHttpClient client) {
		this.client = client;
	}

}
