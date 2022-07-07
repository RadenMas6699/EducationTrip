package com.radenmas.educationtrip.rpl;

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
import com.radenmas.educationtrip.MenuPlay;
import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.function.HeartPoint;
import com.radenmas.educationtrip.function.Star;

public class MapsRPL extends AppCompatActivity {

    private ImageView btn_back, heart,
            part1rpl, part2rpl, part3rpl, part4rpl, part5rpl,
            star_part1rpl, star_part2rpl, star_part3rpl, star_part4rpl, star_part5rpl;
    private TextView starText;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_rpl);

        init();
        show_lock();
        onClick();
        scorerpl();
//        heart();
    }

    private void init() {
        fAuth = FirebaseAuth.getInstance();
        part1rpl = findViewById(R.id.part1rpl);
        part2rpl = findViewById(R.id.part2rpl);
        part3rpl = findViewById(R.id.part3rpl);
        part4rpl = findViewById(R.id.part4rpl);
        part5rpl = findViewById(R.id.part5rpl);
        star_part1rpl = findViewById(R.id.star_part1rpl);
        star_part2rpl = findViewById(R.id.star_part2rpl);
        star_part3rpl = findViewById(R.id.star_part3rpl);
        star_part4rpl = findViewById(R.id.star_part4rpl);
        star_part5rpl = findViewById(R.id.star_part5rpl);
        starText = findViewById(R.id.starText);
        btn_back = findViewById(R.id.btn_back);
//        heart = findViewById(R.id.heart);
    }

    private void onClick() {
        part1rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent part1rpl = new Intent(MapsRPL.this, Part1RPL.class);
                startActivity(part1rpl);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part2rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent part2rpl = new Intent(MapsRPL.this, Part2RPL.class);
                startActivity(part2rpl);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part3rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent part3rpl = new Intent(MapsRPL.this, Part3RPL.class);
                startActivity(part3rpl);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part4rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent part4rpl = new Intent(MapsRPL.this, Part4RPL.class);
                startActivity(part4rpl);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        part5rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent part5rpl = new Intent(MapsRPL.this, Part5RPL.class);
                startActivity(part5rpl);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_play = new Intent(MapsRPL.this, MenuPlay.class);
                startActivity(menu_play);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    private void scorerpl() {
        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1rpl = mystar.getInt("starpart1rpl",0);
        int starpart2rpl = mystar.getInt("starpart2rpl",0);
        int starpart3rpl = mystar.getInt("starpart3rpl",0);
        int starpart4rpl = mystar.getInt("starpart4rpl",0);
        int starpart5rpl = mystar.getInt("starpart5rpl",0);

        int starrpl = starpart1rpl + starpart2rpl + starpart3rpl + starpart4rpl + starpart5rpl;
        starText.setText(""+starrpl);

        editor.putInt("starrpl",starrpl);
        editor.apply();

        if (fAuth.getCurrentUser() != null) {
            String userID = fAuth.getCurrentUser().getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference().child(userID).child("star").child("starrpl");
            databaseReference.setValue(starrpl);
        }

        //part1rpl
        if (starpart1rpl == 0){
            part2rpl.setClickable(false);
            part3rpl.setClickable(false);
            part4rpl.setClickable(false);
            part5rpl.setClickable(false);
        } else {
            part2rpl.setClickable(true);
            part3rpl.setClickable(false);
            part4rpl.setClickable(false);
            part5rpl.setClickable(false);
            part2rpl.setImageResource(R.drawable.part2rpl);
            Star star = new Star(starpart1rpl,star_part1rpl);
        }

        //part2rpl
        if (starpart2rpl == 0){
            part4rpl.setClickable(false);
            part5rpl.setClickable(false);
        } else {
            part3rpl.setClickable(true);
            part4rpl.setClickable(false);
            part5rpl.setClickable(false);
            part3rpl.setImageResource(R.drawable.part3rpl);
            Star star = new Star(starpart2rpl,star_part2rpl);
        }

        //part3rpl
        if (starpart3rpl == 0){
            part4rpl.setClickable(false);
            part5rpl.setClickable(false);
        } else {
            part4rpl.setClickable(true);
            part5rpl.setClickable(false);
            part4rpl.setImageResource(R.drawable.part4rpl);
            Star star = new Star(starpart3rpl,star_part3rpl);
        }

        //part4rpl
        if (starpart4rpl == 0){
            part5rpl.setClickable(false);
        } else {
            part5rpl.setClickable(true);
            part5rpl.setImageResource(R.drawable.part5rpl);
            Star star = new Star(starpart4rpl,star_part4rpl);
        }

        //part5rpl
        if (starpart5rpl == 0){
        } else {
            Star star = new Star(starpart5rpl,star_part5rpl);
        }
    }

    private void heart() {
        SharedPreferences myheartrpl = this.getSharedPreferences("heartRPL", Context.MODE_PRIVATE);
        int heartrpl = myheartrpl.getInt("heartrpl",3);
        HeartPoint heartPoint = new HeartPoint(heartrpl, heart);
    }

    private void show_lock() {
        part2rpl.setImageResource(R.drawable.partrpllock);
        part3rpl.setImageResource(R.drawable.partrpllock);
        part4rpl.setImageResource(R.drawable.partrpllock);
        part5rpl.setImageResource(R.drawable.partrpllock);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent menu_play = new Intent(MapsRPL.this, MenuPlay.class);
        startActivity(menu_play);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
