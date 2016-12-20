package com.example.a45722053p.marvelproject;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 45722053p on 20/12/16.
 */

public class CharactersContentProvider extends CupboardContentProvider {
    // The content provider authority is used for building Uri's for the provider
    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Character.class);
    }

    public CharactersContentProvider() {
        super(AUTHORITY, 1);
    }
}