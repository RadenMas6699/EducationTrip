package com.radenmas.educationtrip.jaringan;

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


public class MapsJaringan extends AppCompatActivity {

    private ImageView btn_back, heart,
            part1jaringan, part2jaringan, part3jaringan, part4jaringan, part5jaringan,
            star_part1jaringan, star_part2jaringan, star_part3jaringan, star_part4jaringan, star_part5jaringan;
    private TextView starText;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_jaringan);

        init();
        show_lock();
        onClick();
        scorejaringan();
//        heart();
    }

    private void init() {
        fAuth = FirebaseAuth.getInstance();
        part1jaringan = findViewById(R.id.part1jaringan);
        part2jaringan = findViewById(R.id.part2jaringan);
        part3jaringan = findViewById(R.id.part3jaringan);
        part4jaringan = findViewById(R.id.part4jaringan);
        part5jaringan = findViewById(R.id.part5jaringan);
        star_part1jaringan = findViewById(R.id.star_part1jaringan);
        star_part2jaringan = findViewById(R.id.star_part2jaringan);
        star_part3jaringan = findViewById(R.id.star_part3jaringan);
        star_part4jaringan = findViewById(R.id.star_part4jaringan);
        star_part5jaringan = findViewById(R.id.star_part5jaringan);
        starText = findViewById(R.id.starText);
        btn_back = findViewById(R.id.btn_back);
//        heart = findViewById(R.id.heart);
    }

    private void onClick() {
        part1jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, Part1Jaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part2jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, Part2Jaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part3jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, Part3Jaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part4jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, Part4Jaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part5jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, Part5Jaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsJaringan.this, MenuPlay.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    private void scorejaringan() {
        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1jaringan = mystar.getInt("starpart1jaringan",0);
        int starpart2jaringan = mystar.getInt("starpart2jaringan",0);
        int starpart3jaringan = mystar.getInt("starpart3jaringan",0);
        int starpart4jaringan = mystar.getInt("starpart4jaringan",0);
        int starpart5jaringan = mystar.getInt("starpart5jaringan",0);

        int starjaringan = starpart1jaringan + starpart2jaringan + starpart3jaringan + starpart4jaringan + starpart5jaringan;
        starText.setText(""+starjaringan);

        editor.putInt("starjaringan",starjaringan);
        editor.apply();

        if (fAuth.getCurrentUser() != null) {
            String userID = fAuth.getCurrentUser().getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference().child(userID).child("star").child("starjaringan");
            databaseReference.setValue(starjaringan);
        }

        //part1jaringan
        if (starpart1jaringan == 0){
            part2jaringan.setClickable(false);
            part3jaringan.setClickable(false);
            part4jaringan.setClickable(false);
            part5jaringan.setClickable(false);
        } else {
            part2jaringan.setClickable(true);
            part3jaringan.setClickable(false);
            part4jaringan.setClickable(false);
            part5jaringan.setClickable(false);
            part2jaringan.setImageResource(R.drawable.part2jaringan);
            Star star = new Star(starpart1jaringan,star_part1jaringan);
        }

        //part2jaringan
        if (starpart2jaringan == 0){
            part3jaringan.setClickable(false);
            part4jaringan.setClickable(false);
            part5jaringan.setClickable(false);
        } else {
            part3jaringan.setClickable(true);
            part4jaringan.setClickable(false);
            part5jaringan.setClickable(false);
            part3jaringan.setImageResource(R.drawable.part3jaringan);
            Star star = new Star(starpart2jaringan,star_part2jaringan);
        }

        //part3jaringan
        if (starpart3jaringan == 0){
            part4jaringan.setClickable(false);
            part5jaringan.setClickable(false);
        } else {
            part4jaringan.setClickable(true);
            part5jaringan.setClickable(false);
            part4jaringan.setImageResource(R.drawable.part4jaringan);
            Star star = new Star(starpart3jaringan,star_part3jaringan);
        }

        //part4jaringan
        if (starpart4jaringan == 0){
            part5jaringan.setClickable(false);
        } else {
            part5jaringan.setClickable(true);
            part5jaringan.setImageResource(R.drawable.part4jaringan);
            Star star = new Star(starpart4jaringan,star_part4jaringan);
        }

        //part5jaringan
        if (starpart5jaringan == 0){
        } else {
            Star star = new Star(starpart5jaringan,star_part5jaringan);
        }
    }

    private void heart() {
        SharedPreferences myheartjaringan = this.getSharedPreferences("heartJaringan", Context.MODE_PRIVATE);
        int heartjaringan = myheartjaringan.getInt("heartjaringan",3);
        HeartPoint heartPoint = new HeartPoint(heartjaringan, heart);
    }

    private void show_lock() {
        part2jaringan.setImageResource(R.drawable.partjaringanlock);
        part3jaringan.setImageResource(R.drawable.partjaringanlock);
        part4jaringan.setImageResource(R.drawable.partjaringanlock);
        part5jaringan.setImageResource(R.drawable.partjaringanlock);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MapsJaringan.this, MenuPlay.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
