package com.bignerdranch.android.pokedex;

import android.support.v4.app.Fragment;

public class PokeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PokeListFragment();
    }
}
