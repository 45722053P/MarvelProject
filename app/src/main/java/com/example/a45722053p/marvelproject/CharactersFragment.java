package com.example.a45722053p.marvelproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {


    private ArrayList<Character> items;
    private ArrayAdapter<Character> adapter;

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

        items = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.characterrow,
                R.id.nameCharacter,
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

        Log.d("DEBUGCHARACTEAGMENTS", "HOLAAA");

    }


    private class refreshBackground extends AsyncTask<Void,Void,ArrayList<Character>> {

        @Override
       protected ArrayList<Character> doInBackground(Void... params) {

            LlamadasApi api = new LlamadasApi();
            ArrayList<Character> result = api.getCharacters();

            Log.d("DEBUG",result.toString());

            return result;
        }
//
//        @Override
//        protected void onPostExecute(ArrayList<Character> characters) {
//
//            adapter.clear();
//            for(Character perso : characters){
//                adapter.add(perso);
//            }
//        }
    }

}
