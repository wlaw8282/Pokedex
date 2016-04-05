package com.bignerdranch.android.pokedex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pokedex {
    private static Pokedex sPokedex;
    private List<Pokemon> mPokemonIndex;
    public static Pokedex get (Context context){
        if (sPokedex == null) {
            sPokedex = new Pokedex(context);
        }
        return sPokedex;
    }
    private Pokedex (Context context) {
        String[] mPokemonList;
        mPokemonList = new String[20];
        mPokemonList[0] = "Bulbasaur";
        mPokemonList[1] = "Ivysaur";
        mPokemonList[2] = "Venusaur";
        mPokemonList[3] = "Charmander";
        mPokemonList[4] = "Charmeleon";
        mPokemonList[5] = "Charizard";
        mPokemonList[6] = "Squirtle";
        mPokemonList[7] = "Wartortle";
        mPokemonList[8] = "Blastoise";
        mPokemonList[9] = "Caterpie";
        mPokemonList[10] = "Metapod";
        mPokemonList[11] = "Butterfree";
        mPokemonList[12] = "Weedle";
        mPokemonList[13] = "Kakuna";
        mPokemonList[14] = "Beedrill";
        mPokemonList[15] = "Pidgey";
        mPokemonList[16] = "Pidgeotto";
        mPokemonList[17] = "Pidgeot";
        mPokemonList[18] = "Rattata";
        mPokemonList[19] = "Raticate";
        String[] mPokemonType;
        mPokemonType = new String[20];
        mPokemonType[0] = "Grass";
        mPokemonType[1] = "Grass";
        mPokemonType[2] = "Grass";
        mPokemonType[3] = "Fire";
        mPokemonType[4] = "Fire";
        mPokemonType[5] = "Fire";
        mPokemonType[6] = "Water";
        mPokemonType[7] = "Water";
        mPokemonType[8] = "Water";
        mPokemonType[9] = "Bug";
        mPokemonType[10] = "Bug";
        mPokemonType[11] = "Bug";
        mPokemonType[12] = "Bug";
        mPokemonType[13] = "Bug";
        mPokemonType[14] = "Bug";
        mPokemonType[15] = "Flying";
        mPokemonType[16] = "Flying";
        mPokemonType[17] = "Flying";
        mPokemonType[18] = "Normal";
        mPokemonType[19] = "Normal";
        mPokemonIndex = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(mPokemonList[i]);
            pokemon.setType(mPokemonType[i]);
            mPokemonIndex.add(pokemon);
        }
    }
    public List<Pokemon> getPokemons() {
        return mPokemonIndex;
    }
    public Pokemon getPokemon(UUID id) {
        for (Pokemon pokemon : mPokemonIndex) {
            if (pokemon.getId().equals(id)) {
                return pokemon;
            }
        }
        return null;
    }
}


