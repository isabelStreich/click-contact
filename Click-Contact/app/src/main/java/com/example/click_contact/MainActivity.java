package com.example.click_contact;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.click_contact.adapters.ListviewGeneralAdapter;
import com.example.click_contact.entities.User;
import com.example.click_contact.manager.UserManager;
import com.example.click_contact.services.ConnexionBd;
import com.example.click_contact.sqliteHelper.DatabaseHelper;
public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnRegister;
    EditText et_name;
    EditText et_pwd;
    ConnexionBd connexionBd;
    DatabaseHelper dataBaseHelper;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context= this;
        setContentView(R.layout.activity_main);
//        /        recuperar mis elementos
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
//        conexion bd
//        ConnexionBd.copyBdFromAssets(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User isExist = UserManager.checkUserExist(context,et_name.getText().toString(),et_pwd.getText().toString());
                if (isExist!= null) {
                    Intent intent = new Intent(MainActivity.this, UserListActivity.class);
                    intent.putExtra("name", et_name.getText().toString());
                    startActivity(intent);
                } else {
                    et_pwd.setText(null);
                    Toast.makeText(MainActivity.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent (MainActivity.this, Register.class);
                startActivity(intentRegister);

            }
        });
    }
}

