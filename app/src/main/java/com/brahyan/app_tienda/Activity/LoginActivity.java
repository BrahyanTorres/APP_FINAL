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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
        private EditText user, contra;

        private Button login, regis;
        private static final String USER = "admin";
        private static final String CON = "123";

         FirebaseAuth mAuth;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            mAuth = FirebaseAuth.getInstance();

            user = findViewById(R.id.inpName);
            contra = findViewById(R.id.inpContraseña);
            login = findViewById(R.id.btnLogin);
            regis=findViewById(R.id.btnRegis);

            regis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, Registrars.class);
                    startActivity(intent);
                }
            });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String us = user.getText().toString();
                    String passUser= contra.getText().toString();


                    if (us.isEmpty() && passUser.isEmpty()){
                        Toast.makeText(LoginActivity.this,"Llene los campos", Toast.LENGTH_SHORT).show();
                        user.requestFocus();
                    }else{
                        loginUser(us,passUser);
                    }
                }
            });
        }

    private void loginUser(String us, String passUser) {
            mAuth.signInWithEmailAndPassword(us,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        finish();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(LoginActivity.this,"Bienvenido", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"Error, el usuario no esta registrado!", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        contra.setText("");
                        user.requestFocus();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this,"Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            });

    }


}
