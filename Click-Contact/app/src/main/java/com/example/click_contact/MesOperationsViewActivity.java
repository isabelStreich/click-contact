package com.example.click_contact;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.click_contact.adapters.ListviewGeneralAdapter;
import com.example.click_contact.adapters.MonContactViewAdapter;
import com.example.click_contact.adapters.OperationViewAdapter;
import com.example.click_contact.entities.Operation;
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
    TextView tv_operationId;
    TextView tv_destinataire;
    TextView tv_typeOperation;
    TextView tv_positionTarifaire;
    TextView tv_incoterms;
    TextView tv_nameBancDestinataire;
    TextView rb_status;
    EditText et_operationId;
    EditText et_destinataire;
    EditText et_typeOperation;
    EditText et_positionTarifaire;
    EditText et_incoterms;
    EditText et_nameBancDestinataire;
    RadioButton rb_statusOperation;
    EditText et_status;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.operation_client);
        tv_titreOp = findViewById(R.id.tv_titreOp);
        lv_listOperationes = findViewById(R.id.lv_listOperationes);

//        ConnexionBd.copyBdFromAssets(this);
        operationViewAdapter = new OperationViewAdapter(context, R.layout.view_operation, OperationManager.getAll(context));
        lv_listOperationes.setAdapter(operationViewAdapter);

        lv_listOperationes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Mon operation");
                builder.setMessage("Qu'est-ce que vous voulez faire?");
                builder.setPositiveButton("ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Operation operation = (Operation) parent.getItemAtPosition(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Mon operation a Ajouter");
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.operation_crud, null);
                        builder.setView(layout);
                        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog dialog1 = (AlertDialog) dialog;
                                et_operationId = dialog1.findViewById(R.id.et_operationId);
                                et_destinataire = dialog1.findViewById(R.id.et_destinataire);
                                et_typeOperation = dialog1.findViewById(R.id.et_typeOperation);
                                et_positionTarifaire = dialog1.findViewById(R.id.et_positionTarifaire);
                                et_incoterms = dialog1.findViewById(R.id.et_incoterms);
                                et_nameBancDestinataire = dialog1.findViewById(R.id.et_nameBancDestinataire);
                                rb_statusOperation = dialog1.findViewById(R.id.rb_statusOperation);
                                et_status = dialog1.findViewById(R.id.et_status);
                                Operation operation = new Operation(et_operationId.getText().toString(),et_destinataire.getText().toString(),et_typeOperation.getText().toString(),et_positionTarifaire.getText().toString(),et_status.getText().toString());
                                OperationManager.add(context, operation);
                                operationViewAdapter.add(operation);
                                operationViewAdapter.notifyDataSetChanged();
                            }
                        });
                        AlertDialog dialog1 = builder.show();
                    }
                });
                builder.setNeutralButton("modifier", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Operation operation = (Operation) parent.getItemAtPosition(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Mon Operation a modifier");
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.operation_crud, null);
                        builder.setView(layout);
                        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog dialog1 = (AlertDialog) dialog;

//                                et_destinataire = dialog1.findViewById(R.id.et_destinataire);
                                et_typeOperation = dialog1.findViewById(R.id.et_typeOperation);
                                et_positionTarifaire = dialog1.findViewById(R.id.et_positionTarifaire);
                                et_incoterms = dialog1.findViewById(R.id.et_incoterms);
                                et_nameBancDestinataire = dialog1.findViewById(R.id.et_nameBancDestinataire);
                                et_status = dialog1.findViewById(R.id.et_status);

//                                operation.setIdClient(et_destinataire.getText().toString());
                                operation.setTypeOperation(et_typeOperation.getText().toString());
                                operation.setTarifPosition(et_positionTarifaire.getText().toString());
                                operation.setIncoterms(et_incoterms.getText().toString());
                                operation.setEntiteBancaire(et_nameBancDestinataire.getText().toString());
                                operation.setStatus(et_status.getText().toString());

                                OperationManager.updateOperation(context, operation);
                                operationViewAdapter.notifyDataSetChanged();
                            }
                        });
                        AlertDialog dialog1 = builder.show();
                        et_typeOperation = dialog1.findViewById(R.id.et_typeOperation);
                        et_positionTarifaire = dialog1.findViewById(R.id.et_positionTarifaire);
                        et_incoterms = dialog1.findViewById(R.id.et_incoterms);
                        et_nameBancDestinataire = dialog1.findViewById(R.id.et_nameBancDestinataire);
                        et_status = dialog1.findViewById(R.id.et_status);

                        et_typeOperation.setText(operation.getTypeOperation());
                        et_positionTarifaire.setText(operation.getTarifPosition());
                        et_incoterms.setText(operation.getIncoterms());
                        et_nameBancDestinataire.setText(operation.getEntiteBancaire());
                        et_status.setText(operation.getStatus());

                    }
                });
                builder.setNegativeButton("suprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Operation operation = (Operation) parent.getItemAtPosition(position);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MesOperationsViewActivity.this);
                        builder.setTitle("Mon operation a Suprimer");
                        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.operation_crud, null);
                        builder.setView(layout);

                        builder.setNegativeButton("Cancel", null);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                OperationManager.delete(context, operation.getId());
                                operationViewAdapter.notifyDataSetChanged();
                            }
                        });

                        AlertDialog dialog1 = builder.show();
                        et_typeOperation = dialog1.findViewById(R.id.et_typeOperation);
                        et_positionTarifaire = dialog1.findViewById(R.id.et_positionTarifaire);
                        et_incoterms = dialog1.findViewById(R.id.et_incoterms);
                        et_nameBancDestinataire = dialog1.findViewById(R.id.et_nameBancDestinataire);
                        et_status = dialog1.findViewById(R.id.et_status);

                        et_typeOperation.setText(operation.getTypeOperation());
                        et_positionTarifaire.setText(operation.getTarifPosition());
                        et_incoterms.setText(operation.getIncoterms());
                        et_nameBancDestinataire.setText(operation.getEntiteBancaire());
                        et_status.setText(operation.getStatus());
                    }
                });
                AlertDialog dialog = builder.show();
                return true;
            }
        });

    }
}
