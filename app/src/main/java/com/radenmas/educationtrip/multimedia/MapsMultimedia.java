package com.radenmas.educationtrip.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.radenmas.educationtrip.function.HeartPoint;
import com.radenmas.educationtrip.MenuPlay;
import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.function.Star;

public class MapsMultimedia extends AppCompatActivity {

    private ImageView btn_back, heart,
        part1multimedia, part2multimedia, part3multimedia, part4multimedia, part5multimedia,
        star_part1multimedia, star_part2multimedia, star_part3multimedia, star_part4multimedia, star_part5multimedia;
    private TextView starText;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_multimedia);

        init();
        show_lock();
        onClick();
        scoremultimedia();
//        heart();
    }

    private void init() {
        fAuth = FirebaseAuth.getInstance();
        part1multimedia = findViewById(R.id.part1multimedia);
        part2multimedia = findViewById(R.id.part2multimedia);
        part3multimedia = findViewById(R.id.part3multimedia);
        part4multimedia = findViewById(R.id.part4multimedia);
        part5multimedia = findViewById(R.id.part5multimedia);
        star_part1multimedia = findViewById(R.id.star_part1multimedia);
        star_part2multimedia = findViewById(R.id.star_part2multimedia);
        star_part3multimedia = findViewById(R.id.star_part3multimedia);
        star_part4multimedia = findViewById(R.id.star_part4multimedia);
        star_part5multimedia = findViewById(R.id.star_part5multimedia);
        starText = findViewById(R.id.starText);
        btn_back = findViewById(R.id.btn_back);
//        heart = findViewById(R.id.heart);
    }

    private void onClick() {
        part1multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, Part1Multimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part2multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, Part2Multimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part3multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, Part3Multimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part4multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, Part4Multimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part5multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, Part5Multimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsMultimedia.this, MenuPlay.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    private void scoremultimedia() {
        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1multimedia = mystar.getInt("starpart1multimedia",0);
        int starpart2multimedia = mystar.getInt("starpart2multimedia",0);
        int starpart3multimedia = mystar.getInt("starpart3multimedia",0);
        int starpart4multimedia = mystar.getInt("starpart4multimedia",0);
        int starpart5multimedia = mystar.getInt("starpart5multimedia",0);

        int starmultimedia = starpart1multimedia + starpart2multimedia + starpart3multimedia + starpart4multimedia + starpart5multimedia;
        starText.setText(""+starmultimedia);

        editor.putInt("starmultimedia",starmultimedia);
        editor.apply();

        if (fAuth.getCurrentUser() != null) {
            String userID = fAuth.getCurrentUser().getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference().child(userID).child("star").child("starmultimedia");
            databaseReference.setValue(starmultimedia);
        }

        //part1multimedia
        if (starpart1multimedia == 0){
            part2multimedia.setClickable(false);
            part3multimedia.setClickable(false);
            part4multimedia.setClickable(false);
            part5multimedia.setClickable(false);
        } else {
            part2multimedia.setClickable(true);
            part3multimedia.setClickable(false);
            part4multimedia.setClickable(false);
            part5multimedia.setClickable(false);
            part2multimedia.setImageResource(R.drawable.part2multimedia);
            Star star = new Star(starpart1multimedia,star_part1multimedia);
        }

        //part2multimedia
        if (starpart2multimedia == 0){
            part3multimedia.setClickable(false);
            part4multimedia.setClickable(false);
            part5multimedia.setClickable(false);
        } else {
            part3multimedia.setClickable(true);
            part4multimedia.setClickable(false);
            part5multimedia.setClickable(false);
            part3multimedia.setImageResource(R.drawable.part3multimedia);
            Star star = new Star(starpart2multimedia,star_part2multimedia);
        }

        //part3multimedia
        if (starpart3multimedia == 0){
            part4multimedia.setClickable(false);
            part5multimedia.setClickable(false);
        } else {
            part4multimedia.setClickable(true);
            part5multimedia.setClickable(false);
            part4multimedia.setImageResource(R.drawable.part4multimedia);
            Star star = new Star(starpart3multimedia,star_part3multimedia);
        }

        //part4multimedia
        if (starpart4multimedia == 0){
            part5multimedia.setClickable(false);
        } else {
            part5multimedia.setClickable(true);
            part5multimedia.setImageResource(R.drawable.part4multimedia);
            Star star = new Star(starpart4multimedia,star_part4multimedia);
        }

        //part5multimedia
        if (starpart5multimedia == 0){
        } else {
            Star star = new Star(starpart5multimedia,star_part5multimedia);
        }
    }

    private void heart() {
        SharedPreferences myheartmultimedia = this.getSharedPreferences("heartMultimedia", Context.MODE_PRIVATE);
        int heartmultimedia = myheartmultimedia.getInt("heartmultimedia",3);
        HeartPoint heartPoint = new HeartPoint(heartmultimedia, heart);
    }

    private void show_lock() {
        part2multimedia.setImageResource(R.drawable.partmultimedialock);
        part3multimedia.setImageResource(R.drawable.partmultimedialock);
        part4multimedia.setImageResource(R.drawable.partmultimedialock);
        part5multimedia.setImageResource(R.drawable.partmultimedialock);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent menu_play = new Intent(MapsMultimedia.this, MenuPlay.class);
        startActivity(menu_play);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
