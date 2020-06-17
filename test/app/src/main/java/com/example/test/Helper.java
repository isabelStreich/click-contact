package com.example.test;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Helper extends SQLiteOpenHelper {
private static String _DatabaseName = "clientDatabase";

public Helper(Context context) : base(context, _DatabaseName, null, 1) { }
public override void OnCreate(SQLiteDatabase db)
        {
        db.ExecSQL(Helper.CreateQuery);
        }

public override void OnUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
        db.ExecSQL(Helper.DeleteQuery);
        OnCreate(db);
        }

private const string TableName = "adminTable";
private const string ColumnID = "id";
private const string ColumnUsername = "username";
private const string ColumnFirstName = "firstname";
private const string ColumnLastName = "lastname";
private const string ColumnAddress = "address";
private const string ColumnCountry = "country";
private const string ColumnPassword = "password";
private const string ColumnEmail = "email";
private const string ColumnMobile = "mobile";

public const string CreateQuery = "CREATE TABLE " + TableName +
        " ( "
        + ColumnID + " INTEGER PRIMARY KEY,"
        + ColumnUsername + " TEXT,"
        + ColumnFirstName + " TEXT,"
        + ColumnLastName + " TEXT,"
        + ColumnAddress + " TEXT,"
        + ColumnCountry + " TEXT,"
        + ColumnPassword + " TEXT,"
        + ColumnEmail + " TEXT,"
        + ColumnMobile + " TEXT)";

public const string DeleteQuery = "DROP TABLE IF EXISTS " + TableName;

public void Register(Context context, UserDetails user)
        {
        SQLiteDatabase db = new Helper(context).WritableDatabase;
        ContentValues Values = new ContentValues();
        Values.Put(ColumnUsername, user.Username);
        Values.Put(ColumnFirstName, user.FirstName);
        Values.Put(ColumnLastName, user.LastName);
        Values.Put(ColumnCountry, user.Country);
        Values.Put(ColumnAddress, user.Address);
        Values.Put(ColumnPassword, user.Password);
        Values.Put(ColumnEmail, user.Email);
        Values.Put(ColumnMobile, user.Mobile);
        db.Insert(TableName, null, Values);
        db.Close();
        }
public UserDetails Authenticate(Context context, UserDetails user)
        {
        SQLiteDatabase db = new Helper(context).ReadableDatabase;
        ICursor cursor = db.Query(TableName, new string[]
        { ColumnID, ColumnFirstName,ColumnLastName,ColumnAddress,ColumnCountry, ColumnUsername, ColumnPassword, ColumnEmail, ColumnMobile },
        ColumnUsername + "=?", new string[] { user.Username }, null, null, null);
        if(cursor != null && cursor.MoveToFirst() && cursor.Count > 0)
        {
        UserDetails user1 = new UserDetails(cursor.GetString(6));
        if (user.Password.Equals(user1.Password))
        return user1;
        }
        return null;
        }

public List<UserDetails> GetUser(Context context)
        {
        List<UserDetails> users = new List<UserDetails>();
        SQLiteDatabase db = new Helper(context).ReadableDatabase;
        string[] columns = new string[] {ColumnID,ColumnUsername,ColumnFirstName,ColumnLastName,ColumnAddress,ColumnCountry,ColumnPassword,ColumnEmail,ColumnMobile };
        using(ICursor cursor = db.Query(TableName, columns, null, null, null, null, null))
        {
        while (cursor.MoveToNext())
        {
        users.Add(new UserDetails
        {
        ID = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnID)),
        Username = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnUsername)),
        FirstName = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnFirstName)),
        Country = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnCountry)),
        Address = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnAddress)),
        LastName = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnLastName)),
        Password = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnPassword)),
        Email = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnEmail)),
        Mobile = cursor.GetString(cursor.GetColumnIndexOrThrow(ColumnMobile))

        });
        }
        db.Close();
        return users;
        }
        }
        }
