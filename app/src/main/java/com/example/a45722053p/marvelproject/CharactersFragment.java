package com.example.a45722053p.marvelproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {


    private ArrayList<Character> items;
    private CharacterAdapter adapter;

    public CharactersFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        refresh();

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_characters, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View charactersFragment =  inflater.inflate(R.layout.fragment_characters, container, false);


        GridView gridViewCharacters = (GridView)charactersFragment.findViewById(R.id.gridCharacters);

//        String [] data = {
//          "ASDVAJDFJGSKHKJASHGJKH",
//                "SFSDFSFSDFSDF",
//                "ASFSDFSDFSDF"
//
//
//        };


        items = new ArrayList<>();

        adapter = new CharacterAdapter(
                getContext(),
                R.layout.characterrow,
                items
        );

        gridViewCharacters.setAdapter(adapter);


        return charactersFragment;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refreshbutton) {

        refresh();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void refresh(){

        refreshBackground refreshBackground = new refreshBackground();

        refreshBackground.execute();

    }


    private class refreshBackground extends AsyncTask<Void,Void,Void> {

        @Override
       protected Void doInBackground(Void... params) {

            LlamadasApi api = new LlamadasApi();
            ArrayList<Character> result = api.getCharacters();
            Log.d("DEBUGCHARACTEAGMENTS",result.toString());

            return null;
        }
    }

}
