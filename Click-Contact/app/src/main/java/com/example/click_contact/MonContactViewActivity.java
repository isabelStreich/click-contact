package com.example.click_contact;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.click_contact.adapters.OperationViewAdapter;
class MonContactViewActivity extends Activity {
    Context ctx;
    OperationViewAdapter operationViewAdapter;
//    EditText et_name;
//    EditText et_adresse;
//    EditText et_telephone;
//    EditText et_email;
//    EditText et_nameBanc;
//    //falta TextView titulos
//    EditText et_operationId;
//    EditText et_destinataire;
//    EditText et_typeOperation;
//    EditText et_positionTarifaire;
//    EditText et_incoterms;
//    EditText et_nameBancDestinataire;
//    RadioButton rb_statusOperation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.client_info);

//        et_name = findViewById(R.id.et_name);
//        et_adresse = findViewById(R.id.et_adresse);
//        et_telephone = findViewById(R.id.et_telephone);
//        et_email = findViewById(R.id.et_email);
//        et_operationId = findViewById(R.id.et_operationId);
//        et_destinataire = findViewById(R.id.et_destinataire);
//        et_typeOperation = findViewById(R.id.et_typeOperation);
//        et_incoterms = findViewById(R.id.et_incoterms);
//        et_positionTarifaire = findViewById(R.id.et_positionTarifaire);
//        et_nameBancDestinataire = findViewById(R.id.et_nameBancDestinataire);
//        rb_statusOperation = findViewById(R.id.rb_statusOperation);

//        TextView txtProduct = (TextView) findViewById(R.id.team_label);
//        Intent i = getIntent();
//        // getting attached intent data
//        String product = i.getStringExtra("team");
//        // displaying selected product name
//        txtProduct.setText(product);
    }
}
