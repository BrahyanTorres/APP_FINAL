package com.brahyan.app_tienda.Activity;

import static java.util.ResourceBundle.getBundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.brahyan.app_tienda.Domain.PopularDomain;
import com.brahyan.app_tienda.R;

public class HomeActivity extends AppCompatActivity {
    private ImageView img;
    private TextView titulo, precio, desc;
    private  PopularDomain object;
    private Button btncart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        initView();
        getBundle();
        
    }

    private void getBundle() {
        object=(PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResorceId=this.getResources().getIdentifier(object.getImg(),"drawable",this.getPackageName());

        titulo.setText(object.getTitulo());
        precio.setText((int) object.getPrecio());
        desc.setText(object.getDesc());
    }

    private void initView() {
        img=findViewById(R.id.imgDet);
        precio=findViewById(R.id.preTxt);
        titulo=findViewById(R.id.descTxt);
        btncart=findViewById(R.id.btnCart);

        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

    }

}
