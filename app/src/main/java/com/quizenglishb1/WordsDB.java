package com.quizenglishb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.quizenglishb1.com.quizenglishb1.utilities.CoupleString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvaro on 07/07/2015.
 */
public class WordsDB extends SQLiteOpenHelper{

    private String createWORDTRANSLATIONTABLE = "CREATE TABLE WORDTRANSLATIONS" +
            "(wordSP TEXT," +
            "typeSP TEXT," +
            "wordEN TEXT," +
            "typeEN TEXT)";

    public WordsDB(Context context) {
        super(context, "DataBase", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createWORDTRANSLATIONTABLE);
        init(db);
    }

    private void init(SQLiteDatabase db){
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','get','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','catch','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atrapar','v','catch','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('surgir','v','arise','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despertar','v','wake up','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dormir','v','sleep','v')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Recibe como parámetro un par de String [palabra-tipo] en español y
     * devuelve el resultado de dicha traducción
     * */
    public Map<String,String> translateFromSpanish(CoupleString spanish){
        Map<String,String> res = new HashMap<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS " +
                "WHERE wordSP="+spanish.getFirst()+"AND typeSP="+spanish.getSecond(),null);

        while(cursor.moveToNext())
            res.put(cursor.getString(2),cursor.getString(3));
        cursor.close();
        db.close();
        return res;
    }


    /**
     * Recibe un par de String que representa una palabra en inglés con su
     * tipo y devuelve un Map que representa todas las palabras que coinciden
     * con dicha traducción
     * */
    public Map<String,String> translateFromEnglish(CoupleString english){
        Map<String,String> res = new HashMap<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS " +
                "WHERE wordEN="+english.getFirst()+"AND typeEN="+english.getSecond(),null);
        while(cursor.moveToNext())
            res.put(cursor.getString(0),cursor.getString(1));
        cursor.close();
        db.close();
        return res;
    }


    /**
     * Recibe como parámetro un String en español y
     * devuelve el resultado de dicha traducción
     * */
    public Map<String,String> translateFromSpanish(String spanish){
        Map<String,String> res = new HashMap<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS " +
                "WHERE wordSP="+spanish,null);

        while(cursor.moveToNext())
            res.put(cursor.getString(2),cursor.getString(3));
        cursor.close();
        db.close();
        return res;
    }

    /**
     * Recibe un String que representa una palabra en inglés con su
     * y devuelve un Map que representa todas las palabras que coinciden
     * con dicha traducción
     * */
    public Map<String,String> translateFromEnglish(String english){
        Map<String,String> res = new HashMap<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS " +
                "WHERE wordEN='"+english+"'",null);
        while(cursor.moveToNext())
            res.put(cursor.getString(0),cursor.getString(1));
        cursor.close();
        db.close();
        return res;
    }

    /**
     * Añade a la base de datos la palabra que recibe como parámetro (spanish) y le
     * asocia las traducciones indicadas en el Map<String,String>
     * */
    public void addTranslationsFromSpanish(CoupleString spanish,Map<String,String> english){
        Map<String,String> englishOnDB = translateFromSpanish(spanish);
        SQLiteDatabase db = getWritableDatabase();
        for(String s:english.keySet())
            if(!englishOnDB.containsKey(s))
                if(english.get(s) != englishOnDB.get(s))
                    db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(" +
                            spanish.getFirst()+","
                            + spanish.getSecond()+","
                            + s+","
                            + english.get(s)+")");
        db.close();
    }

    public void addTranslationFromEnglish(CoupleString english, Map<String,String> spanish){
        Map<String,String> spanishOnDB=translateFromEnglish(english);
        SQLiteDatabase db = getWritableDatabase();
        for(String s:spanish.keySet())
            if(!spanish.containsKey(s))
                if(spanish.get(s) != spanishOnDB.get(s))
                    db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(" +
                            s+","
                            + spanish.get(s)+","
                            + english.getFirst()+","
                            + english.getSecond()+")");
        db.close();
    }
}
