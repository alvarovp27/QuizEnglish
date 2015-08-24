package com.quizenglishb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.quizenglishb1.com.quizenglishb1.utilities.User;

/**
 * Created by Alvaro on 24/08/2015.
 */
public class UsersDB extends SQLiteOpenHelper {

    String createUSERS = "CREATE TABLE IF NOT EXISTS USERS (user TEXT, password TEXT, token TEXT)";

    public UsersDB(Context context) {
        super(context, "UsersDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUSERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isEmpty(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USERS",null);
        if(c.getCount() == 0){
            c.close();
            db.close();
            return true;
        }
        c.close();
        db.close();
        return false;
    }

    public User getUsers(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USERS",null);

        User res=null;
        while(c.moveToNext()) {
            Log.d("UsersDB_columna_0: ",c.getString(0));
            res = new User(c.getString(0), c.getString(1), c.getString(2));
        }
        c.close();
        db.close();
        return res;
    }

    public void addUser(String name, String password, String token){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO USERS VALUES('" + name + "','" + password + "','" + token + "')");
        db.close();
    }

    public void updateToken(String name, String token){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE USERS SET token='"+token+"' WHERE user = '"+name+"'");
        db.close();
    }

}
