package com.radenmas.educationtrip.function;

import android.widget.ImageView;

import com.radenmas.educationtrip.R;

public class HeartPoint {
    int heartpoint;
    ImageView heart;

    public HeartPoint() {
    }

    public HeartPoint(int heartpoint, ImageView heart) {
        this.heartpoint = heartpoint;
        this.heart = heart;
        if (heartpoint == 2){
            heart.setImageResource(R.drawable.heart2);
        } else if (heartpoint == 1){
            heart.setImageResource(R.drawable.heart1);
        } else if (heartpoint == 0){
            heart.setImageResource(R.drawable.heart0);
        }
    }

    public int getHeartpoint() {
        return heartpoint;
    }
    public ImageView getHeart() {
        return heart;
    }

}
