package com.example.a45722053p.marvelproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a45722053p.marvelproject.example.Result;

import java.util.ArrayList;

/**
 * Created by 45722053p on 20/12/16.
 */

public class CharacterAdapter extends ArrayAdapter<Result> {

        TextView name,descripcion;

        ImageView Image;

        public CharacterAdapter(Context context, int resource, ArrayList<Result> objects) {
                super(context, resource, objects);

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                // Obtenim l'objecte en la possició corresponent
                Result character = getItem(position);
                Log.w("XXXX", character.toString());

                // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
                // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
                if (convertView == null) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        convertView = inflater.inflate(R.layout.characterrow, parent, false);
                }

                // Unim el codi en les Views del Layout

                 name = (TextView) convertView.findViewById(R.id.nameCharacter);
                 descripcion = (TextView) convertView.findViewById(R.id.descriptionCharacter);
                 Image = (ImageView) convertView.findViewById(R.id.imageCharacter);

                // Fiquem les dades dels objectes (provinents del JSON) en el layout
                name.setText(character.getName());
                descripcion.setText(character.getDescription());
                Glide.with(getContext()).load(character.getThumbnail()).into(Image);

                // Retornem la View replena per a mostrarla
                return convertView;
        }


}
