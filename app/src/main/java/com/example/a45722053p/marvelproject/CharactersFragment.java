package com.example.a45722053p.marvelproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {


    private ArrayList<String> items;
    private CharactersCursorAdapter adapter;

    public CharactersFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View charactersFragment =  inflater.inflate(R.layout.fragment_characters, container, false);


        GridView gridCharacters = (GridView)charactersFragment.findViewById(R.id.gridCharacters);

        String [] data = {
          "ASDVAJDFJGSKHKJASHGJKH",
                "SFSDFSFSDFSDF",
                "ASFSDFSDFSDF"


        };



        items = new ArrayList<>(Arrays.asList(data));

        adapter = new CharactersCursorAdapter(
                getContext(),
                R.layout.characterrow,
                R.id.nameCharacter,
                items
        );

        gridCharacters.setAdapter(adapter);





        return charactersFragment;

    }

//    private void refresh() {
//
//        ArrayList<Character> result;
//
//        result = LlamadasApi.getCharacters();
//
//        Log.d("DEBUG", result != null ? result.toString() : null);
//
//    }


}
