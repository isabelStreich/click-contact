package com.example.click_contact.manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.click_contact.entities.Contact;
import com.example.click_contact.services.ConnexionBd;

import java.util.ArrayList;
public class ContactManager {

    private static String queryGetAll = "select * from contact";

    public static ArrayList<Contact> getAll(Context context) {
        ArrayList<Contact> retour = new ArrayList<>();
        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String adresse = cursor.getString(cursor.getColumnIndex("adresse"));
            String telephone = cursor.getString(cursor.getColumnIndex("telephone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String rol = cursor.getString(cursor.getColumnIndex("rol"));
            String entiteFinanciereUtilise = cursor.getString(cursor.getColumnIndex("entiteFinanciereUtilise"));
            Contact contact = new Contact(id, name, adresse, telephone, email, rol, entiteFinanciereUtilise);
            retour.add(contact);
        }
        return retour;
    }
    public static boolean add(Context context, Contact contactToAdd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contactToAdd.getName());
        contentValues.put("adresse", contactToAdd.getAdresse());
        contentValues.put("telephone", contactToAdd.getTelephone());
        contentValues.put("email", contactToAdd.getEmail());
        contentValues.put("rol", contactToAdd.getRol());
        contentValues.put("entiteFinanciereUtilise", contactToAdd.getEntiteFinanciereUtilise());
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        long id = bd.insert("contact", null, contentValues);
        bd.close();
        return id != -1;
    }
    public static boolean delete(Context context, int id) {
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String whereClause = "id = ?";
        String[] whereArg = new String[]{"" + id};
        int nbRowAffect = bd.delete("contact", whereClause, whereArg);
        return nbRowAffect > 0;
    }
    public static boolean updateContact(Context context, Contact contactToChange) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contactToChange.getName());
        contentValues.put("adresse", contactToChange.getAdresse());
        contentValues.put("telephone", contactToChange.getTelephone());
        contentValues.put("email", contactToChange.getEmail());
        contentValues.put("rol", contactToChange.getRol());
        contentValues.put("entiteFinanciereUtilise", contactToChange.getEntiteFinanciereUtilise());
        String whereClause = "id = ?";
        String[] whereArg = new String[]{"" + contactToChange.getId()};
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        int nbRowwAffect = bd.update("contact", contentValues, whereClause, whereArg);
        return nbRowwAffect > 0;
    }


}
