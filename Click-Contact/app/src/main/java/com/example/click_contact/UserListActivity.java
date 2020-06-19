package com.example.click_contact;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.click_contact.manager.UserManager;
import com.example.click_contact.services.ConnexionBd;

import java.util.ArrayList;
public class UserListActivity extends AppCompatActivity {
    ListviewGeneralAdapter listviewGeneralAdapter;
    TextView tv_titre;
    Button btnAjouterContact;
    ListView lv_generalList;
    Context context;
    EditText et_rol;
    EditText et_name;
    EditText et_adresse;
    EditText et_telephone;
    EditText et_courriel;
    EditText et_entiteBancaire;
    TextView tv_rol;
    TextView tv_name;
    TextView tv_adresse;
    TextView tv_telephone;
    TextView tv_courriel;
    TextView tv_entiteBancaire;
    Contact contact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.listview_general);
        tv_titre = findViewById(R.id.tv_titre);
//        btnAjouterContact = findViewById(R.id.btnAjouterContact);
        lv_generalList = findViewById(R.id.lv_generalList);
//        ConnexionBd.copyBdFromAssets(this);
        listviewGeneralAdapter = new ListviewGeneralAdapter(context, R.layout.view_contact, ContactManager.getAll(context));
        lv_generalList.setAdapter(listviewGeneralAdapter);
        lv_generalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact) parent.getItemAtPosition(position);
                Intent intent = new Intent(UserListActivity.this, MesOperationsViewActivity.class);
                startActivity(intent);
            }
        });
        lv_generalList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Mon contact a Ajouter");
                builder.setMessage("que vous voulez faire");
                builder.setPositiveButton("ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contact contact = (Contact) parent.getItemAtPosition(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Mon Contact a Ajouter");
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.view_contact_crud, null);
                        builder.setView(layout);
                        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog dialog1 = (AlertDialog) dialog;
                                tv_rol = dialog1.findViewById(R.id.tv_rol);
                                et_rol = dialog1.findViewById(R.id.et_rol);
                                et_name = dialog1.findViewById(R.id.et_name);
                                et_adresse = dialog1.findViewById(R.id.et_adresse);
                                et_telephone = dialog1.findViewById(R.id.et_telephone);
                                et_courriel = dialog1.findViewById(R.id.et_email);
                                et_entiteBancaire = dialog1.findViewById(R.id.et_nameBanc);
                                Contact contact = new Contact(et_name.getText().toString(),
                                        et_adresse.getText().toString(),
                                        et_telephone.getText().toString(),
                                        et_courriel.getText().toString(),
                                        et_rol.getText().toString(),
                                        et_entiteBancaire.getText().toString());
                                ContactManager.add(context, contact);
                                listviewGeneralAdapter.add(contact);
                                listviewGeneralAdapter.notifyDataSetChanged();
                            }
                        });
                        AlertDialog dialog1 = builder.show();
                    }
                });
                builder.setNeutralButton("modifier", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Contact contact = (Contact) parent.getItemAtPosition(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Mon Contact a modifier");
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.view_contact_crud, null);
                        builder.setView(layout);
                        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog dialog1 = (AlertDialog) dialog;
                                tv_rol = dialog1.findViewById(R.id.tv_rol);
                                et_rol = dialog1.findViewById(R.id.et_rol);
                                et_name = dialog1.findViewById(R.id.et_name);
                                et_adresse = dialog1.findViewById(R.id.et_adresse);
                                et_telephone = dialog1.findViewById(R.id.et_telephone);
                                et_courriel = dialog1.findViewById(R.id.et_email);
                                et_entiteBancaire = dialog1.findViewById(R.id.et_nameBanc);
                                contact.setRol(et_rol.getText().toString());
                                contact.setName(et_name.getText().toString());
                                contact.setAdresse(et_adresse.getText().toString());
                                contact.setTelephone(et_telephone.getText().toString());
                                contact.setEmail(et_courriel.getText().toString());
                                contact.setEntiteFinanciereUtilise(et_entiteBancaire.getText().toString());
                                ContactManager.updateContact(context, contact);
                                listviewGeneralAdapter.notifyDataSetChanged();
                            }
                        });
                        AlertDialog before = builder.show();
                        tv_rol = before.findViewById(R.id.tv_rol);
                        et_rol = before.findViewById(R.id.et_rol);
                        et_name = before.findViewById(R.id.et_name);
                        et_adresse = before.findViewById(R.id.et_adresse);
                        et_telephone = before.findViewById(R.id.et_telephone);
                        et_courriel = before.findViewById(R.id.et_email);
                        et_entiteBancaire = before.findViewById(R.id.et_nameBanc);
                        et_rol.setText(contact.getRol());
                        et_name.setText(contact.getName());
                        et_adresse.setText(contact.getAdresse());
                        et_telephone.setText(contact.getTelephone());
                        et_courriel.setText(contact.getEmail());
                        et_entiteBancaire.setText(contact.getEntiteFinanciereUtilise());
                    }
                });
                builder.setNegativeButton("suprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Contact contact = (Contact) parent.getItemAtPosition(position);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(UserListActivity.this);
                        builder.setTitle("Mon Contact a Suprimer");
//                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.view_contact_crud, null);
//                        builder.setView(layout);
                        final int positionToRemove = position;
                        builder.setNegativeButton("Cancel", null);
                        builder.setPositiveButton("Je vais suprimir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ContactManager.delete(context, positionToRemove);
                                listviewGeneralAdapter.notifyDataSetChanged();
                            }
                        });
                        builder.show();
                    }
                });
                AlertDialog dialog = builder.show();
                return true;
            }
        });
    }
}