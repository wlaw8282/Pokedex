package com.bignerdranch.android.pokedex;

import android.app.FragmentManager;
import android.content.Context;
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

import java.util.List;
import java.util.UUID;

public class PokemonFragment extends Fragment {
    private static final String POKEMON_ID = "pokemon_id";
    private Pokemon mPokemon;
    private TextView mPokemonName;
    private TextView mPokemonType;
    private ImageView mPokemonPic;
    private ImageView mPokemonEvo1;
    private ImageView mPokemonEvo2;
    private ImageView mPokemonEvo3;
    private List<Pokemon> mPokemonList;
    private CheckBox mPokemonCapturedBox;
    private Context mContext;
    static int instanceCounter = 0;
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
        super.onCreateView(inflater,container,savedInstanceState);
        mPokemonList = Pokedex.get(mContext).getPokemons();
        mPokemonName = (TextView)v.findViewById(R.id.pokemon_name);
        mPokemonType = (TextView)v.findViewById(R.id.pokemon_type);
        mPokemonPic = (ImageView) v.findViewById(R.id.pokemon_pic);
        mPokemonEvo1 = (ImageView) v.findViewById(R.id.pokemon_evo1);
        mPokemonEvo2 = (ImageView) v.findViewById(R.id.pokemon_evo2);
        mPokemonEvo3 = (ImageView) v.findViewById(R.id.pokemon_evo3);
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
        for(int i = 0; i < mPokemonList.size(); i++) {
            for (int j = instanceCounter; j < 3; j++) {
                if  (j == 0) {
                    mPokemonEvo1.setImageResource(mPokemonList.get(j).getPic());
                    mPokemonEvo2.setImageResource(mPokemonList.get(j+1).getPic());
                    mPokemonEvo3.setImageResource(mPokemonList.get(j+2).getPic());
                } else if (j == 1) {
                    mPokemonEvo1.setImageResource(mPokemonList.get(j-1).getPic());
                    mPokemonEvo2.setImageResource(mPokemonList.get(j).getPic());
                    mPokemonEvo3.setImageResource(mPokemonList.get(j+1).getPic());
                } else if (j == 2) {
                    mPokemonEvo1.setImageResource(mPokemonList.get(j-2).getPic());
                    mPokemonEvo2.setImageResource(mPokemonList.get(j-1).getPic());
                    mPokemonEvo3.setImageResource(mPokemonList.get(j).getPic());
                }
            }
            instanceCounter++;
            if(instanceCounter == 3) {
                instanceCounter = 0;
            }
        }


        return v;
    }

}
