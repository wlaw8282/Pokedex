package com.bignerdranch.android.pokedex;

import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by willi on 4/1/2016.
 */
public class Pokemon {
    private String mName;
    private String mType;
    private UUID mId;
    private int mPic;
    private boolean mCaptured;

    public int getPic() {
        return mPic;
    }

    public void setPic(int pic) {
        mPic = pic;
    }

    public boolean isCaptured() {
        return mCaptured;
    }

    public void setCaptured(boolean captured) {
        mCaptured = captured;
    }

    public Pokemon() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
