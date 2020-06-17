package com.example.click_contact;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.click_contact.entities.User;
import com.example.click_contact.manager.ContactManager;
import com.example.click_contact.manager.UserManager;
import com.example.click_contact.services.ConnexionBd;
public class Register extends AppCompatActivity {
    Context ctx;
    TextView textview;
    TextView tv_titre;
    ImageView imageView;
    EditText et_name, et_pwd,et_email;
    Button btnSave;
    LinearLayout llMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx= this;
        setContentView(R.layout.register);

        textview = findViewById(R.id.textView);
        tv_titre = findViewById(R.id.tv_titre);
        imageView = findViewById(R.id.imageView);
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        et_email = findViewById(R.id.et_email);
        btnSave = findViewById(R.id.btnSave);
        ConnexionBd.getBd(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= et_name.getText().toString();
                String password= et_pwd.getText().toString();
                String email= et_email.getText().toString();
                User userAdd= new User (name,password,email);

                if(!name.equals("")&& !password.equals("") && !email.equals("")){
                    if(UserManager.add(ctx,userAdd)){
                        Toast.makeText(ctx, "Utilisateur Bien Ajoute", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ctx, "Problem D ajout", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

//    ajouterUser

    public void ajouterUser(View view) {
        User UserToAdd = new User();
        UserManager.add(this, UserToAdd);

        for (User user : UserManager.getAll(this)) {

            TextView tv = new TextView(this);
            tv.setText(user.getName());
            tv.setText(user.getPassword());
            tv.setText(user.getEmail());


        }
    }

}
