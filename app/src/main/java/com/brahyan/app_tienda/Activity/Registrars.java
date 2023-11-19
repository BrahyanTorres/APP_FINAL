package com.brahyan.app_tienda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.brahyan.app_tienda.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registrars extends AppCompatActivity {
    private EditText name, contra, core;

    private Button btn_crear,btn_volver;

    FirebaseFirestore mFire;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_user);

        mFire = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.inpName);
        contra = findViewById(R.id.inpContraseña);
        core = findViewById(R.id.inpCorreo);
        btn_crear = findViewById(R.id.btnLogin);
        btn_volver = findViewById(R.id.btnVolver);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrars.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameUser= name.getText().toString().trim();
                String coreUser= core.getText().toString().trim();
                String passUser= contra.getText().toString().trim();

                if (nameUser.isEmpty() && coreUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(Registrars.this,"Llene los campos", Toast.LENGTH_SHORT).show();

                }else{
                    registrarUser(nameUser,coreUser,passUser);
                }

            }
        });
    }

    private void registrarUser(String nameUser, String coreUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(coreUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String,Object> map = new HashMap<>();
                map.put("id",id);
                map.put("name",nameUser);
                map.put("email",coreUser);
                map.put("pass",passUser);

                startActivity(new Intent(Registrars.this, LoginActivity.class));
                Toast.makeText(Registrars.this, "Usuario registrado con Exito!", Toast.LENGTH_SHORT).show();
                finish();



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(Registrars.this, "Error al registrarse", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

