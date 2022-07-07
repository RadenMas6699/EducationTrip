package com.radenmas.educationtrip.function;

import android.widget.ImageView;

import com.radenmas.educationtrip.R;

public class Star {
    int starpart;
    ImageView star_part;

    public Star() {
    }

    public Star(int starpart, ImageView star_part) {
        this.starpart = starpart;
        this.star_part = star_part;
        if (starpart == 1){
            star_part.setImageResource(R.drawable.star1);
        } else if (starpart == 2){
            star_part.setImageResource(R.drawable.star2);
        } else if (starpart == 3){
            star_part.setImageResource(R.drawable.star3);
        }
    }

    public int getStarpart() {
        return starpart;
    }

    public ImageView getStar_part() {
        return star_part;
    }
}
