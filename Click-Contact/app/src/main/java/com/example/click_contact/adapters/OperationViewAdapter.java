package com.example.click_contact.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.click_contact.R;
import com.example.click_contact.entities.Operation;

import java.util.List;
public class OperationViewAdapter extends ArrayAdapter<Operation> {
    LinearLayout lLInfoOperation;
    TextView tv_operationId;
    TextView tv_destinataire;
    TextView tv_typeOperation;
    TextView tv_positionTarifaire;
    TextView tv_incoterms;
    TextView tv_nameBancDestinataire;
    TextView rb_status;

    Button btnAdd;
    Button btnEdit;
    Button btnDelete;
    public OperationViewAdapter(@NonNull Context context, int resource, @NonNull List<Operation> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Operation operation = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_operation, null);
        }
        lLInfoOperation = convertView.findViewById(R.id.lLInfoOperation);
        tv_operationId = convertView.findViewById(R.id.tv_operationId);
        tv_destinataire = convertView.findViewById(R.id.tv_destinataire);
        tv_typeOperation = convertView.findViewById(R.id.tv_typeOperation);
        tv_positionTarifaire = convertView.findViewById(R.id.tv_positionTarifaire);
        tv_incoterms = convertView.findViewById(R.id.tv_incoterms);
        tv_nameBancDestinataire = convertView.findViewById(R.id.tv_nameBancDestinataire);
        rb_status = convertView.findViewById(R.id.rb_status);
        tv_operationId.setText("" + operation.getId());
        tv_destinataire.setText("" + operation.getIdClient());
        tv_typeOperation.setText(operation.getTypeOperation());
        tv_positionTarifaire.setText(operation.getTarifPosition());
        tv_incoterms.setText(operation.getIncoterms());
        tv_nameBancDestinataire.setText(operation.getEntiteBancaire());
        rb_status.setText(operation.getStatus());
        return convertView;
    }
}
