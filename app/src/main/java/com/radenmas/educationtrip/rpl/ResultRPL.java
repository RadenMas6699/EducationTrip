package com.radenmas.educationtrip.rpl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.Startup;
import com.spark.submitbutton.SubmitButton;

public class ResultRPL extends AppCompatActivity {

    private TextView username, score, mapel;
    private SubmitButton btn_menu;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_quiz);

        init();
        scoreRPL();
        onClick();

    }

    private void init() {
        username = findViewById(R.id.username);
        score = findViewById(R.id.score);
        btn_menu = findViewById(R.id.btn_menu);
        mapel = findViewById(R.id.mapel);
        mapel.setText("R P L");
    }

    private void scoreRPL() {
        SharedPreferences myAccount = this.getSharedPreferences("myAccount", Context.MODE_PRIVATE);
        String user = myAccount .getString("username","");
        username.setText(user);

        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1rpl = mystar.getInt("starpart1rpl",0);
        int starpart2rpl = mystar.getInt("starpart2rpl",0);
        int starpart3rpl = mystar.getInt("starpart3rpl",0);
        int starpart4rpl = mystar.getInt("starpart4rpl",0);
        int starpart5rpl = mystar.getInt("starpart5rpl",0);

        int starrpl = starpart1rpl + starpart2rpl + starpart3rpl + starpart4rpl + starpart5rpl;
        score.setText(""+starrpl);

        editor.putInt("starrpl",starrpl);
        editor.apply();

        mediaPlayer = MediaPlayer.create(this, R.raw.win);
        mediaPlayer.start();
    }

    private void onClick() {
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ResultRPL.this, Startup.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                },2000);
            }
        });
    }
}
