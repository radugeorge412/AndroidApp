package com.example.radugym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        final EditText userName = (EditText) findViewById(R.id.newUser);
        final EditText password = (EditText) findViewById(R.id.newPassword);
        final EditText email = (EditText) findViewById(R.id.newEmail);

        Button btnRegister = (Button) findViewById(R.id.butonNouRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser + newPassword +"data", "Welcome "+ newUser + "!" + "\n" +"Lets get started!");
                editor.commit();

                Intent loginScreen = new Intent(Register.this, Login.class);
                startActivity(loginScreen);
            }
        });

    }
}
