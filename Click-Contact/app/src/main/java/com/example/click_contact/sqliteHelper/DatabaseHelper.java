package com.example.click_contact.sqliteHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

//    public void createDb(){
//        boolean dbExist = checkDbExist();
//
//        if(!dbExist){
//            this.getReadableDatabase();
//            copyDatabase();
//        }
//    }
//
//    private boolean checkDbExist(){
//        SQLiteDatabase sqLiteDatabase = null;
//
//        try{
//            String path = DATABASE_PATH + DATABASE_NAME;
//            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
//        } catch (Exception ex){
//        }
//
//        if(sqLiteDatabase != null){
//            sqLiteDatabase.close();
//            return true;
//        }
//
//        return false;
//    }
//
//    private void copyDatabase(){
//        try {
//            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
//
//            String outFileName = DATABASE_PATH + DATABASE_NAME;
//
//            OutputStream outputStream = new FileOutputStream(outFileName);
//
//            byte[] b = new byte[1024];
//            int length;
//
//            while ((length = inputStream.read(b)) > 0){
//                outputStream.write(b, 0, length);
//            }
//
//            outputStream.flush();
//            outputStream.close();
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private SQLiteDatabase openDatabase(){
//        String path = DATABASE_PATH + DATABASE_NAME;
//        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//        return db;
//    }
//
//    public void close(){
//        if(db != null){
//            db.close();
//        }
//    }
//
//    public boolean checkUserExist(String name, String password){
//        String[] columns = {"name"};
//        db = openDatabase();
//
//        String selection = "name=? and password = ?";
//        String[] selectionArgs = {name, password};
//
//        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
//        int count = cursor.getCount();
//
//        cursor.close();
//        close();
//
//        if(count > 0){
//            return true;
//        } else {
//            return false;
//        }
    }




