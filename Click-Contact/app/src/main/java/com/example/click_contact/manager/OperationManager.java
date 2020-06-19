package com.example.click_contact.manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.click_contact.entities.Contact;
import com.example.click_contact.entities.Operation;
import com.example.click_contact.services.ConnexionBd;

import java.util.ArrayList;
public class OperationManager {
    private static String queryGetAll = "select * from operation";

    public static ArrayList<Operation> getAll(Context context) {
        ArrayList<Operation> retour = new ArrayList<>();
        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
//            int idClient = cursor.getInt(cursor.getColumnIndex("idClient"));
            String typeOperation = cursor.getString(cursor.getColumnIndex("typeOperation"));
            String tarifPosition = cursor.getString(cursor.getColumnIndex("tarifPosition"));
            String incoterms = cursor.getString(cursor.getColumnIndex("incoterms"));
            String entiteBancaire = cursor.getString(cursor.getColumnIndex("entiteBancaire"));
//            String status = cursor.getString(cursor.getColumnIndex("Status"));

            Operation operation= new Operation(id,typeOperation,tarifPosition,incoterms,entiteBancaire);
//            Operation operation= new Operation(id,idClient,typeOperation,tarifPosition,incoterms,entiteBancaire,status);
            retour.add(operation);
        }
        return retour;
    }
    public static boolean add(Context context, Operation operationToAdd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("idClient", operationToAdd.getIdClient());
        contentValues.put("typeOperation", operationToAdd.getTypeOperation());
        contentValues.put("tarifPosition", operationToAdd.getTarifPosition());
        contentValues.put("incoterms", operationToAdd.getIncoterms());
        contentValues.put("entiteBancaire", operationToAdd.getIncoterms());
        contentValues.put("status", operationToAdd.getStatus());

        SQLiteDatabase bd = ConnexionBd.getBd(context);
        long id = bd.insert("operation", null, contentValues);
        bd.close();
        return id != -1;
    }
    public static boolean delete(Context context, int id) {
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String whereClause = " id = ?";
        String[] whereArg = new String[]{"" + id};
        int nbRowAffect = bd.delete("operation", whereClause, whereArg);
        return nbRowAffect > 0;
    }
    public static boolean updateContact(Context context, Operation operationToChange) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("idClient", operationToChange.getIdClient());
        contentValues.put("typeOperation", operationToChange.getTypeOperation());
        contentValues.put("tarifPosition", operationToChange.getTarifPosition());
        contentValues.put("incoterms", operationToChange.getIncoterms());
        contentValues.put("entiteBancaire", operationToChange.getIncoterms());
        contentValues.put("status", operationToChange.getStatus());
        String whereClause = "id = ?";
        String[] whereArg = new String[]{"" + operationToChange.getId()};
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        int nbRowwAffect = bd.update("operation", contentValues, whereClause, whereArg);
        return nbRowwAffect > 0;
    }
}
