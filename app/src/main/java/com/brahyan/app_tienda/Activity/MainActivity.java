package com.brahyan.app_tienda.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.brahyan.app_tienda.Adapters.ListAdapters;
import com.brahyan.app_tienda.Domain.PopularDomain;
import com.brahyan.app_tienda.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPop;
    private RecyclerView reViePop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_home);

        initRecyclerView();


    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();

        items.add(new PopularDomain("Silla Xl",152000,"img","Silla en madera para descansar"));
        items.add(new PopularDomain("Cama Doble",2000000,"imgcloset",""));
        items.add(new PopularDomain("Closet",400000,"imgcama",""));

        reViePop=findViewById(R.id.listapop);
        reViePop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPop= new ListAdapters(items);
        reViePop.setAdapter(adapterPop);
    }
}