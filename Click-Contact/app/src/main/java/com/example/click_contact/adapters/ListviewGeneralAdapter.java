package com.example.click_contact.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.click_contact.R;
import com.example.click_contact.entities.Contact;
import com.example.click_contact.manager.ContactManager;

import java.util.List;
public class ListviewGeneralAdapter extends ArrayAdapter<Contact> {
    int res;
    TextView tv_rol;
    TextView tv_name;
    TextView tv_adresse;
    TextView tv_telephone;
    TextView tv_courriel;
    TextView tv_entiteBancaire;
    EditText et_rol;
    EditText et_name;
    EditText et_adresse;
    EditText et_telephone;
    EditText et_courriel;
    EditText et_entiteBancaire;

    Context ctx;
    public ListviewGeneralAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        res = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Contact contact = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_contact, null);
        }
//        TEXTEVIEW
        tv_rol = convertView.findViewById(R.id.tv_rol);
        tv_name = convertView.findViewById(R.id.tv_name);
        tv_adresse = convertView.findViewById(R.id.tv_adresse);
        tv_telephone = convertView.findViewById(R.id.tv_telephone);
        tv_courriel = convertView.findViewById(R.id.tv_email);
        tv_entiteBancaire = convertView.findViewById(R.id.tv_nameBanc);

        tv_rol.setText(contact.getRol());
        tv_name.setText(contact.getName());
        tv_adresse.setText(contact.getAdresse());
        tv_telephone.setText(contact.getTelephone());
        tv_courriel.setText(contact.getEmail());
        tv_entiteBancaire.setText(contact.getEntiteFinanciereUtilise());

        return convertView;
    }
}

