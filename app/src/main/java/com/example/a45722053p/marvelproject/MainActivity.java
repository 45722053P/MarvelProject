package com.example.a45722053p.marvelproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

       // refresh();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this,SettingsActivity.class);
             startActivity(intent);

            return true;
        }else if (id== R.id.refreshbutton){

            //refresh();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.historia) {


            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);

            //Debera abrir el activity de la historia (MainActivity)


        } else if (id == R.id.personajes) {

            //Aquí deberia abrir el activity de los personajes (CharactersActivity)

            Intent intent = new Intent(this,CharactersActivity.class);

            startActivity(intent);




        } else if (id == R.id.comics) {

            //Abriremos la activity de los comics (ComicsActivity)

            Intent intent = new Intent(this,ComicsActivity.class);

            startActivity(intent);



        } else if (id == R.id.creadores) {

            //La activity de Peliculas (MoviesActivity)

            Intent intent = new Intent(this,CreatorsActivity.class);

            startActivity(intent);


        } else if (id == R.id.pageOficial) {

            //Abriremos la activity de la pagina oficial (PageActivity)



        } else if (id == R.id.redesSociales) {


            //Y por ultimo aqui abriremos la activity de las redes sociales oficiales (RSActivity)


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    private void refresh(){
//
//        refreshBackground refreshBackground = new refreshBackground();
//
//        refreshBackground.execute();
//
//    }
//
//
//    private class refreshBackground extends AsyncTask<Void,Void,Void>{
//
//        @Override
//        protected Void doInBackground(Void... params) {
//
//            LlamadasApi api = new LlamadasApi();
//            ArrayList<Character> result = api.getCharacters();
//            Log.d("DEBUG",result.toString());
//
//            return null;
//        }
//    }



}
