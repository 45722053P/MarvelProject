package com.example.a45722053p.marvelproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {

    public CharactersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View CharactersFragment =  inflater.inflate(R.layout.fragment_characters, container, false);


    return CharactersFragment;

    }
}
