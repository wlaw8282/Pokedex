package com.bignerdranch.android.pokedex;

import android.support.v4.app.Fragment;

/**
 * Created by willi on 4/1/2016.
 */
public class PokeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PokeListFragment();
    }
}
