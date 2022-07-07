package com.radenmas.educationtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.radenmas.educationtrip.jaringan.ResultJaringan;
import com.spark.submitbutton.SubmitButton;

import java.util.HashMap;
import java.util.Map;

public class MenuSignUp extends AppCompatActivity {

    public EditText etUsername, etEmail, etPassword;
    private TextView tvLogin;
    private Button btnSignUp;
    private ImageView btn_back;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_signup);

        fAuth = FirebaseAuth.getInstance();
        etUsername = findViewById(R.id.etUsername);
        etEmail= findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().isEmpty()){
                    etUsername.setError("Nama kosong");
                } else if (etEmail.getText().toString().isEmpty()){
                    etEmail.setError("Email kosong");
                } else if (etPassword.getText().toString().isEmpty()){
                    etPassword.setError("Password kosong");
                } else {
                    signUp();
                }
            }
        });

        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSignUp.this, MenuLogin.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSignUp.this, MenuLogin.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }


    private void signUp(){
        final String username = etUsername.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            task.getException().printStackTrace();
                            Toast.makeText(MenuSignUp.this, "Proses Pendaftaran Gagal",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            saveUser();
                            progressBar.setVisibility(View.VISIBLE);
                            String userID = fAuth.getCurrentUser().getUid();
                            databaseReference = FirebaseDatabase.getInstance().getReference().child(userID).child("account");

                            Map map = new HashMap();
                            map.put("username", username);
                            map.put("email", email);
                            map.put("password", password);

                            databaseReference.setValue(map);

                            Toast.makeText(MenuSignUp.this, "Proses Pendaftaran Berhasil\n" +
                                            "Email "+email,
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MenuSignUp.this, MenuLogin.class));
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                        }

                    }
                });

    }

    private void saveUser(){
        String username = etUsername.getText().toString();

        SharedPreferences myAccount = this.getSharedPreferences("myAccount", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myAccount.edit();

        editor.putString("username",username);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MenuSignUp.this, MenuLogin.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
