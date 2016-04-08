package com.bignerdranch.android.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class PokeListFragment extends Fragment {
    private RecyclerView mPokemonRecyclerView;
    private PokeAdapter mPokeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        mPokemonRecyclerView = (RecyclerView) view.findViewById(R.id.pokemon_recycler_view);
        mPokemonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    private void updateUI() {
        Pokedex pokedex = Pokedex.get(getActivity());
        List<Pokemon> pokemon = pokedex.getPokemons();
        if(mPokeAdapter == null) {
            mPokeAdapter = new PokeAdapter (pokemon);
            mPokemonRecyclerView.setAdapter(mPokeAdapter);
        }else{
            mPokeAdapter.notifyDataSetChanged();
        }
    }

    private class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mPokemonName;
        private Pokemon mPokemon;
        private CheckBox mCaptured;

        public PokeHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mPokemonName = (TextView) itemView.findViewById(R.id.pokemon_list_name);
            mCaptured = (CheckBox) itemView.findViewById(R.id.pokemon_captured_box);
        }

        public void bindPoke (Pokemon pokemon) {
            mPokemon = pokemon;
            mPokemonName.setText(mPokemon.getName());
            mCaptured.setChecked(mPokemon.isCaptured());
        }
        @Override
        public void onClick(View v) {
            Intent intent = PokemonPagerActivity.newIntent(getActivity(), mPokemon.getId());
            startActivity(intent);
        }
    }
    private class PokeAdapter extends RecyclerView.Adapter<PokeHolder> {
        private List<Pokemon> mPokemonIndex;
        public PokeAdapter(List<Pokemon> pokemon) {
            mPokemonIndex = pokemon;
        }
        @Override
        public PokeHolder onCreateViewHolder (ViewGroup parent, int ViewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_pokemon, parent, false);
            return new PokeHolder(view);
        }
        @Override
        public void onBindViewHolder (PokeHolder holder, int position) {
            Pokemon pokemon = mPokemonIndex.get(position);
            holder.mPokemonName.setText(pokemon.getName());
            holder.bindPoke(pokemon);
        }
        @Override
        public int getItemCount() {
            return mPokemonIndex.size();
        }
    }
}
