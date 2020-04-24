package com.example.beautipackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginForm extends AppCompatActivity {

    Button callSignUp;
    Button login_btn;

    ImageView image;
    TextView sloganTxt, udjiKaoGost, zaboraviliSteLozinku;

    EditText korisnickoIme, lozinka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_form);

        callSignUp = findViewById(R.id.kreirajteNalog);
        login_btn = findViewById(R.id.ulogujSe);
        image = findViewById(R.id.logo_image);
        sloganTxt = findViewById(R.id.sloganTxt);
        udjiKaoGost = findViewById(R.id.nastaviKaoGost);
        zaboraviliSteLozinku = findViewById(R.id.zaboraviliSteLozinku);
        korisnickoIme = findViewById(R.id.korisnickoIme);
        lozinka = findViewById(R.id.lozinka);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LoginForm.this,SignUp.class);
             /*   Pair[] pairs = new Pair[8];
                pairs[0]= new Pair<View, String>(image, "logo_image");
                pairs[1]= new Pair<View, String>(sloganTxt, "slogan_text");
                pairs[2]= new Pair<View, String>(udjiKaoGost, "udji_kao_gost_tran");
                pairs[3]= new Pair<View, String>(zaboraviliSteLozinku, "zaboravili_ste_lozinku_tran");
                pairs[4]= new Pair<View, String>(korisnickoIme, "korisnicki_ime_tran");
                pairs[5]= new Pair<View, String>(lozinka, "lozinka_tran");
                pairs[6]= new Pair<View, String>(login_btn, "button_tran");
                pairs[7]= new Pair<View, String>(callSignUp, "signUp_tran");
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginForm.this,pairs);
                    startActivity(intentRegister,options.toBundle());
                }*/
                startActivity(intentRegister);
            }
        });

    }
}
