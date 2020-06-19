package com.example.click_contact.manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.click_contact.entities.Operation;
import com.example.click_contact.entities.User;
import com.example.click_contact.services.ConnexionBd;

import java.util.ArrayList;
public class UserManager {
    private static String queryGetAll = "select * from user";
    public static ArrayList<User> getAll(Context context) {
        ArrayList<User> retour = new ArrayList<>();
        Cursor cursor = ConnexionBd.getBd(context).rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            User user = new User(id, name, password, email);
            retour.add(user);
        }
        return retour;
    }
    public static boolean add(Context context, User userToAdd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", userToAdd.getId());
        contentValues.put("name", userToAdd.getName());
        contentValues.put("password", userToAdd.getPassword());
        contentValues.put("email", userToAdd.getEmail());
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        long id = bd.insert("user", null, contentValues);
        bd.close();
        return id != -1;
    }
    public static boolean delete(Context context, int id) {
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String whereClause = " id = ?";
        String[] whereArg = new String[]{"" + id};
        int nbRowAffect = bd.delete("user", whereClause, whereArg);
        return nbRowAffect > 0;
    }
    public static boolean updateContact(Context context, User userToChange) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", userToChange.getId());
        contentValues.put("name", userToChange.getName());
        contentValues.put("password", userToChange.getPassword());
        contentValues.put("email", userToChange.getEmail());
        String whereClause = "id = ?";
        String[] whereArg = new String[]{"" + userToChange.getId()};
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        int nbRowwAffect = bd.update("user", contentValues, whereClause, whereArg);
        return nbRowwAffect > 0;
    }
    private static String queryCheckUser = "select * from user where name like ? and password like ?";
    public static User checkUserExist(Context context, String name, String password) {
        User retur = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        Cursor cursor = bd.rawQuery(queryCheckUser, new String[]{name, password});
        if (cursor.moveToNext()) {
            retur = new User();
            retur.setId(cursor.getInt(cursor.getColumnIndex("id")));
            retur.setName(cursor.getString(cursor.getColumnIndex("name")));
            retur.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            retur.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        }
        return retur;
    }
}
