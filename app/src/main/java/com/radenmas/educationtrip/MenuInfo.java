package com.radenmas.educationtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuInfo extends AppCompatActivity {

    private ImageView btn_back, igSukron, igHaidir, igYaya, igRafqi, igRian, igFitri, igWini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_info);

        init();
        onClick();
    }

    private void init() {
        igSukron = findViewById(R.id.igSukron);
        igHaidir = findViewById(R.id.igHaidir);
        igYaya = findViewById(R.id.igYaya);
        igRafqi = findViewById(R.id.igRafqi);
        igRian = findViewById(R.id.igRian);
        igFitri = findViewById(R.id.igFitri);
        igWini = findViewById(R.id.igWini);
    }

    private void onClick() {
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuInfo.this, Startup.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        igSukron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/mas_syukron99/");
            }
        });
        igHaidir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/khaidir_64/");
            }
        });
        igYaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/rahmathdyt____/");
            }
        });
        igRafqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/muhmmadrafky/");
            }
        });
        igRian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/rianar02/");
            }
        });
        igFitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/fitryusuff_/");
            }
        });
        igWini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/arwinipuspitasary/");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MenuInfo.this, Startup.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void instagram(String ig){
        Uri uri = Uri.parse(ig);
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(ig)));
        }
    }
}
