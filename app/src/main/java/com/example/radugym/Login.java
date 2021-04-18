package com.example.radugym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final EditText etName = (EditText) findViewById(R.id.user);
        final EditText etPassword = (EditText) findViewById(R.id.password);

        Button btnLogin = (Button) findViewById(R.id.butonLogin);
        Button btnRegister = (Button) findViewById(R.id.butonRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String userDetails = preferences.getString(user + password +"data", "Username or Password is incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();


                Intent display = new Intent(Login.this, DisplayScreen.class);
                startActivity(display);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen =new Intent(Login.this, Register.class);
                startActivity(registerScreen);
            }
        });



    }
}
