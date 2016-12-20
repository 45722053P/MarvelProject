package com.example.a45722053p.marvelproject;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 45722053p on 29/11/16.
 */

public class LlamadasApi {


    private static final String BASE_URL = "https://gateway.marvel.com/v1/public";
    private static final String API_KEY = "9bae9e9f47d82bd36e8d9f0aabea2d0d";
    private static final String HASH = "689fdd3eb68f4e6e5f2147fdda70538a";
    private static final int TIMESTAMP = 1;

    static ArrayList<Character> getCharacters() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("characters")
                .build();
        String url = builtUri.toString();

        return llamada(url);
    }

    @Nullable
    private static ArrayList<Character> llamada(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return procesaJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static ArrayList<Character> procesaJson(String jsonResponse) {
        ArrayList<Character> personajes = new ArrayList<>();

        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonPersonajes = data.getJSONArray("cards");

            for (int i = 0; i < jsonPersonajes.length(); i++) {
                JSONObject jsonPersonaje = jsonPersonajes.getJSONObject(i);

                Character personaje = new Character();
                personaje.setId(jsonPersonaje.getInt("id"));
                personaje.setName(jsonPersonaje.getString("name"));
                personaje.setDescription(jsonPersonaje.getString("description"));
                personaje.setComics(jsonPersonaje.getString("comics"));
                personaje.setSeries(jsonPersonaje.getString("series"));
                personaje.setStories(jsonPersonaje.getString("stories"));
                personaje.setImageUrl(jsonPersonaje.getString("thumbnail"));


                personajes.add(personaje);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personajes;
    }


}