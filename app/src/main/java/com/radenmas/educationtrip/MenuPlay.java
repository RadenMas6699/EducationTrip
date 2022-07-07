package com.radenmas.educationtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.radenmas.educationtrip.jaringan.MapsJaringan;
import com.radenmas.educationtrip.multimedia.MapsMultimedia;
import com.radenmas.educationtrip.rpl.MapsRPL;

public class MenuPlay extends AppCompatActivity {

    private ImageView btn_back;
    private LinearLayout btn_jaringan, btn_multimedia, btn_rpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_play);

        init();
        onClick();
    }

    private void init() {
        btn_back = findViewById(R.id.btn_back);
        btn_jaringan = findViewById(R.id.btn_jaringan);
        btn_multimedia = findViewById(R.id.btn_multimedia);
        btn_rpl = findViewById(R.id.btn_rpl);
    }

    private void onClick() {
        btn_jaringan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPlay.this, MapsJaringan.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_multimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPlay.this, MapsMultimedia.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_rpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPlay.this, MapsRPL.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPlay.this, Startup.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MenuPlay.this, Startup.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
