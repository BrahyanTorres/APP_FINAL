package com.brahyan.app_tienda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.brahyan.app_tienda.R;

public class LoginActivity extends AppCompatActivity {
        private EditText user, contra;
        private Button login;
        private static final String USER = "admin";
        private static final String CON = "123";
        private Object Toast;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);


            user = findViewById(R.id.txtUsuario);
            contra = findViewById(R.id.txtPassword);
            login = findViewById(R.id.btnLogin);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Obtener el texto de los campos de usuario y contraseña
                    String us = user.getText().toString();
                    String cont = contra.getText().toString();

                    // Comparar con las credenciales correctas
                    if (us.equals(USER) && cont.equals(CON)) {
                        // Inicio de sesión exitoso
                       //showToast("Inicio de sesión exitoso");

                        // Iniciar la actividad principal
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // Nombre de usuario o contraseña incorrectos
                        //showToast("Error en los campos. Verifica tus credenciales.");

                        // Limpiar los campos
                        user.setText("");
                        contra.setText("");

                        // Poner el foco en el campo de usuario
                        user.requestFocus();
                    }
                }
            });
        }



}
