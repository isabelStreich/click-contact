package com.example.click_contact.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.click_contact.R;
import com.example.click_contact.entities.Operation;

import java.util.List;
public class MonContactViewAdapter extends ArrayAdapter<Operation> {
    int res;
    EditText et_operationId;
    EditText et_destinataire;
    EditText et_typeOperation;
    EditText et_positionTarifaire;
    EditText et_incoterms;
    EditText et_nameBancDestinataire;
    RadioButton rb_statusOperation;
    public MonContactViewAdapter(@NonNull Context context, int resource, @NonNull List<Operation> objects) {
        super(context, resource, objects);
        res = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Operation operation = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.client_info, null);
        }
        et_operationId = convertView.findViewById(R.id.et_operationId);
        et_destinataire = convertView.findViewById(R.id.et_destinataire);
        et_typeOperation = convertView.findViewById(R.id.et_typeOperation);
        et_positionTarifaire = convertView.findViewById(R.id.et_positionTarifaire);
        et_incoterms = convertView.findViewById(R.id.et_incoterms);
        et_nameBancDestinataire = convertView.findViewById(R.id.et_nameBancDestinataire);
        rb_statusOperation = convertView.findViewById(R.id.rb_statusOperation);

        et_operationId.setText(""+operation.getId());
        et_destinataire.setText(""+operation.getIdClient());
        et_typeOperation.setText(operation.getTypeOperation());
        et_positionTarifaire.setText(operation.getTarifPosition());
        et_incoterms.setText(operation.getIncoterms());
        et_nameBancDestinataire.setText(operation.getEntiteBancaire());
        rb_statusOperation.setText(operation.getStatus());

        return convertView;
    }


}

