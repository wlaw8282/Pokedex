package com.bignerdranch.android.pokedex;

import android.media.Image;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by willi on 4/1/2016.
 */
public class PokemonFragment extends Fragment {
    private static final String POKEMON_ID = "pokemon_id";
    private Pokemon mPokemon;
    private TextView mPokemonName;
    private TextView mPokemonType;
    private ImageView mPokemonPic;
    private CheckBox mPokemonCapturedBox;
    public static PokemonFragment newInstance (UUID pokeId) {
        Bundle args = new Bundle();
        args.putSerializable(POKEMON_ID, pokeId);
        PokemonFragment fragment = new PokemonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate (Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        mPokemon = new Pokemon();
        UUID pokeId = (UUID) getArguments().getSerializable(POKEMON_ID);
        mPokemon = Pokedex.get(getActivity()).getPokemon(pokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_pokemon, container, false);
        mPokemonName = (TextView)v.findViewById(R.id.pokemon_name);
        mPokemonType = (TextView)v.findViewById(R.id.pokemon_type);
        mPokemonPic = (ImageView) v.findViewById(R.id.pokemon_pic);
        mPokemonName.setText(mPokemon.getName());
        mPokemonType.setText(mPokemon.getType());
        mPokemonPic.setImageResource(mPokemon.getPic());
        mPokemonCapturedBox = (CheckBox)v.findViewById(R.id.pokemon_captured);
        mPokemonCapturedBox.setChecked(mPokemon.isCaptured());
        mPokemonCapturedBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCaptured) {
                mPokemon.setCaptured(isCaptured);
            }
        });

        return v;
        //testing out this thing
        //changes changes
    }

}
