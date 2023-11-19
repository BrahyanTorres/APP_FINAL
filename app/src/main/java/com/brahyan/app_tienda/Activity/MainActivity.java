package com.brahyan.app_tienda.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.brahyan.app_tienda.Adapters.ListAdapters;
import com.brahyan.app_tienda.Domain.PopularDomain;
import com.brahyan.app_tienda.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPop;
    private RecyclerView reViePop;
    private ImageView carro, inicio, perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_home);


        initRecyclerView();

        inicio=findViewById(R.id.btnInicio);
        perfil=findViewById(R.id.btnPerfil);
        carro=findViewById(R.id.btnCarro);

        carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }


    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();

        items.add(new PopularDomain("Silla Xl",152000,"pic1","Silla en madera para descansar"));
        items.add(new PopularDomain("Cama Doble",2000000,"pic2",""));
        items.add(new PopularDomain("Closet",400000,"pic3",""));

        reViePop=findViewById(R.id.listapop);
        reViePop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPop= new ListAdapters(items);
        reViePop.setAdapter(adapterPop);
    }
}