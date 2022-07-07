package com.radenmas.educationtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MenuHighscore extends AppCompatActivity {

    private ImageView btn_back;
    private TextView scorejaringan, scoremultimedia, scorerpl, tvTotalStar;
    FirebaseAuth fAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_highscore);

        init();
        showScore();
        onClick();
    }

    private void init() {
        fAuth = FirebaseAuth.getInstance();
        btn_back = findViewById(R.id.btn_back);
        scorejaringan = findViewById(R.id.scorejaringan);
        scoremultimedia = findViewById(R.id.scoremultimedia);
        scorerpl = findViewById(R.id.scorerpl);
        tvTotalStar = findViewById(R.id.tvTotalStar);
    }

    private void showScore() {
        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starjaringan = mystar.getInt("starjaringan",0);
        int starmultimedia = mystar.getInt("starmultimedia",0);
        int starrpl = mystar.getInt("starrpl",0);

        int totalstar = starjaringan + starmultimedia + starrpl;

        scorejaringan.setText(""+starjaringan);
        scoremultimedia.setText(""+starmultimedia);
        scorerpl.setText(""+starrpl);
        tvTotalStar.setText(""+totalstar);
        editor.putInt("totalstar",totalstar);
        editor.apply();


//        if (fAuth.getCurrentUser() != null) {
//            String userID = fAuth.getCurrentUser().getUid();
//            databaseReference = FirebaseDatabase.getInstance().getReference().child(userID).child("star");
//            databaseReference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    String starjaringan = dataSnapshot.child("starjaringan").getValue().toString();
//                    String starmultimedia = dataSnapshot.child("starmultimedia").getValue().toString();
//                    String starrpl = dataSnapshot.child("starrpl").getValue().toString();
//                    String totalstar = dataSnapshot.child("totalstar").getValue().toString();
//
//                    scorejaringan.setText(""+starjaringan);
//                    scoremultimedia.setText(""+starmultimedia);
//                    scorerpl.setText(""+starrpl);
//                    tvTotalStar.setText(""+totalstar);
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        } else {
//
//        }

    }
    private void onClick() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuHighscore.this, Startup.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MenuHighscore.this, Startup.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
