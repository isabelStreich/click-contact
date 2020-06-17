package com.example.click_contact;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.click_contact.adapters.ListviewGeneralAdapter;
import com.example.click_contact.entities.Contact;
import com.example.click_contact.entities.User;
import com.example.click_contact.manager.ContactManager;
import com.example.click_contact.services.ConnexionBd;

import java.util.ArrayList;
public class UserListActivity extends AppCompatActivity {
    ListviewGeneralAdapter listviewGeneralAdapter;
    TextView tv_titre;
    Button btnAjouterContact;
    ListView lv_generalList;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.listview_general);

        tv_titre= findViewById(R.id.tv_titre);
        btnAjouterContact= findViewById(R.id.btnAjouterContact);
        lv_generalList= findViewById(R.id.lv_generalList);

        ConnexionBd.copyBdFromAssets(this);

        listviewGeneralAdapter = new ListviewGeneralAdapter(context, R.layout.view_contact, ContactManager.getAll(context));
        lv_generalList.setAdapter(listviewGeneralAdapter);
        lv_generalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact) parent.getItemAtPosition(position);
                Intent intent = new Intent(UserListActivity.this, MonContactViewActivity.class);

                startActivity(intent);

            }
        });

        lv_generalList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Mon contact a changer");
//                LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.editer_suprimer_contact, null);
//                builder.setView(layout);
                builder.setMessage("que vous voulez faire");
                builder.setPositiveButton("ajouter",null);
                builder.setNeutralButton("modifier",null);
                builder.setNegativeButton("suprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.show();
                return true;
            }
        });

//AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Mon contact a changer");
//                LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.editer_suprimer_contact, null);
//                builder.setView(layout);
//                AlertDialog dialog = builder.show();
//                return true;

            btnAjouterContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contact contact= new Contact();


                }
            });
        }
    }

