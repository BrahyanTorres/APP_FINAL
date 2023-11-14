package com.brahyan.app_tienda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.brahyan.app_tienda.R;

public class Splahs_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        Animation animacion= AnimationUtils.loadAnimation( this, R.anim.desplazamiento_arriba);

        ImageView logo= findViewById(R.id.logo);
        logo.setAnimation(animacion);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splahs_Screen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
}
}