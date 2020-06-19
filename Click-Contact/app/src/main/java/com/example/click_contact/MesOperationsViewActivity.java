package com.example.click_contact;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.click_contact.adapters.ListviewGeneralAdapter;
import com.example.click_contact.adapters.OperationViewAdapter;
import com.example.click_contact.manager.ContactManager;
import com.example.click_contact.manager.OperationManager;
import com.example.click_contact.services.ConnexionBd;
public class MesOperationsViewActivity extends AppCompatActivity {
//    Declaration de variables
    Context context;
    ListView lv_listOperationes;
    TextView tv_titreOp;
    Button btnAdd;
    Button btnEdit;
    Button btnDelete;
    OperationViewAdapter operationViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.operation_client);

        tv_titreOp= findViewById(R.id.tv_titreOp);
        lv_listOperationes= findViewById(R.id.lv_listOperationes);
        btnAdd= findViewById(R.id.btnAdd);
        btnEdit= findViewById(R.id.btnEdit);
        btnDelete= findViewById(R.id.btnDelete);

        ConnexionBd.copyBdFromAssets(this);

        operationViewAdapter = new OperationViewAdapter(context,R.layout.view_operation, OperationManager.getAll(context));
        lv_listOperationes.setAdapter(operationViewAdapter);


    }
}

//    LinearLayout lLInfoOperation;
//    EditText et_operationId;
//    EditText et_destinataire;
//    EditText et_typeOperation;
//    EditText et_positionTarifaire;
//    EditText et_incoterms;
//    EditText et_nameBancDestinataire;
//    RadioButton rb_statusOperation;
