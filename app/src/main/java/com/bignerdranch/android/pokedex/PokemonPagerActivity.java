package com.bignerdranch.android.pokedex;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import java.util.List;
import java.util.UUID;
/**
 * Created by willi on 4/1/2016.
 */
public class PokemonPagerActivity extends FragmentActivity{
    private static final String POKEMON_ID = "com.bignerdranch.android.pokedex.pokemon_id";
    private ViewPager mViewPager;
    private List<Pokemon> mPokemonList;
    public static Intent newIntent (Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, PokemonPagerActivity.class);
        intent.putExtra(POKEMON_ID, crimeId);
        return intent;
    }
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_pager);
        UUID pokeId = (UUID) getIntent().getSerializableExtra(POKEMON_ID);
        Boolean isCaptured = (Boolean) getIntent().getBooleanExtra(POKEMON_ID, false);
        mViewPager = (ViewPager) findViewById(R.id.activity_pokemon_pager_xml);
        mPokemonList = Pokedex.get(this).getPokemons();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Pokemon pokemon = mPokemonList.get(position);
                return PokemonFragment.newInstance(pokemon.getId());
            }

            @Override
            public int getCount() {
                return mPokemonList.size();
            }
        });
        for(int i = 0; i < mPokemonList.size(); i++) {
            if(mPokemonList.get(i).getId().equals(pokeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }


    }
}
