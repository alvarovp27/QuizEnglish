package com.quizenglishb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.quizenglishb1.asynctasks.FavouritesOperationsAsync;
import com.quizenglishb1.asynctasks.WordStatsOperationsAsync;
import com.quizenglishb1.com.quizenglishb1.utilities.CoupleString;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;
import com.quizenglishb1.com.quizenglishb1.utilities.WordStat;
import com.quizenglishb1.typesForJSON.WordStat2;
import com.quizenglishb1.typesForJSON.WordTranslation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alvaro on 07/07/2015.
 */
public class WordsDB extends SQLiteOpenHelper{

    private String createWORDTRANSLATIONTABLE = "CREATE TABLE IF NOT EXISTS WORDTRANSLATIONS" +
            "(wordSP TEXT," +
            "typeSP TEXT," +
            "wordEN TEXT," +
            "typeEN TEXT," +
            "category TEXT)";

    private String createFAVOURITES = "CREATE TABLE IF NOT EXISTS FAVOURITES"+
            "(wordEN TEXT)";

    private String createFAVOURITESSP = "CREATE TABLE IF NOT EXISTS FAVOURITESSP"+
            "(wordSP TEXT)";

    private String createWORDSTATS = "CREATE TABLE IF NOT EXISTS WORDSTATS"+
            "(word TEXT," +
            "hits INTEGER," +
            "fails INTEGER)";

    private String createCATEGORYS = "CREATE TABLE IF NOT EXISTS CATEGORIES"+
            "(name TEXT)";

    public WordsDB(Context context) {
        super(context, "DataBase", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createWORDTRANSLATIONTABLE);
        db.execSQL(createFAVOURITES);
        db.execSQL(createFAVOURITESSP);
        db.execSQL(createWORDSTATS);
        db.execSQL(createCATEGORYS);
        //init(db);
    }

    private void init(SQLiteDatabase db){
        /*db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','get','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','catch','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atrapar','v','catch','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('surgir','v','arise','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despertar','v','wake up','v')");
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dormir','v','sleep','v')");*/


        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS",null);

        if(cursor.getCount()==0){
            System.out.println("*******ESTOY INICIALIZANDO LA BD*********");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('averiarse','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('romperse','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llorar','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colapsar','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hundirse','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar abajo','loc v','break down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('irrumpir','v','break in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('forzar la entrada','loc v','break in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deshacerse','v','break up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desintegrarse','v','break up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('separarse','v','break up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dividir','v','break up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir','v','break up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('criar','v','bring up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exigir','v','call for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar a','loc v','call for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('requerir','v','call for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer pasar','loc v','call in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer entrar','loc v','call in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decir que entre','loc v','call in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir','v','carry on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proseguir','v','carry on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','v','carry on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer','v','carry out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('realizar','v','carry out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar a cabo','loc v','carry out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coquetear','v','come on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tachar','v','cross out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cortar en pedazos','loc v','cut up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trocear','v','cut up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('picar','v','cut up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resolver algo','loc v','deal with','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('negociar algo','loc v','deal with','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tratar algo','loc v','deal with','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocuparse de algo','loc v','deal with','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('depender de','loc v','depend on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('depender de','loc v','depend upon','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar en','loc v','end up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar en','loc v','end up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar','v','end up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('completar','v','fill in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rellenar','v','fill in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sustituir','v','fill in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llenar','v','fill up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','v','find out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enterarse de','loc v','find out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevarse bien','loc v','get along','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver','v','get back','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','v','get back','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','v','get down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantenerse en forma','loc v','get fit','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar a casa','loc v','get in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','v','get in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('meterse','v','get in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','v','get in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajarse','v','get off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('molar','v','get off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevarse bien','loc v','get on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar bien','loc v','get on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abordar','v','get on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subirse','v','get on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('meterse','v','get into','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subirse','v','get into','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','v','give back','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse por vencido','loc v','give in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rendirse','v','give in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar','v','give out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('emitir','v','give out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repartir algo','loc v','give out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','v','give up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','v','give up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse por vencido','loc v','give up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('donar','v','give away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('elegir','v','go for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decantarse','v','go for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decidirse','v','go for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('explotar','v','go off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sonar','v','go off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasarse','v','go off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('partir','v','go on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','v','go on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir','v','go on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','v','go on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proseguir','v','go on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','v','go out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagarse','v','go out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entregar','v','hand in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('distribuir','v','hand out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repartir','v','hand out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasar el rato','loc v','hang out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colgar','v','hang out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colgar','v','hang up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cortar','v','hang up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','v','hang up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('contener','v','keep in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reprimir','v','keep in','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir','v','keep on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('persistir en','loc v','keep on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('insistir','v','keep on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir el ritmo','loc v','keep up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acostarse','v','lie down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tumbarse','v','lie down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echarse','v','lie down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('velar por','loc v','look after','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuidar','v','look after','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocuparse de','loc v','look after','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar a alguien de reojo','loc v','look at','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar de reojo','loc v','look at','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar con suspicacia','loc v','look at','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','v','look for','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ansiar','v','look forward to','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('anhelar','v','look forward to','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener muchas ganas de','loc v','look forward to','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parecer','v','look like','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parecerse','v','look like','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener cuidado','loc v','look out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar atento','loc v','look out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('elevar la vista','loc v','look up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','v','look up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('elevar la mirada','loc v','look up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar hacia arriba','loc v','look up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar por','loc v','look through','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar a través de','loc v','look through','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','v','pick up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ordenar','v','put away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guardar','v','put away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','v','put away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hablar mal de alguien','loc v','put down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('menospreciar','v','put down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sacrificar','v','put down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desalentar','v','put off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('posponer','v','put off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse','v','put on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse ropa','loc v','put on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('incomodar','v','put out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','v','put out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer pasar','loc v','put through','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aprobar','v','put through','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colgar','v','put up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desplegar','v','put up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','v','put up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantar','v','put up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver a llamar','loc v','ring back','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lamar por teléfono','loc v','ring up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('marcar','v','ring up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','v','set off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('partir','v','set off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('activar','v','set off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disparar','v','set off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir de viaje','loc v','set out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('partir','v','set out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('instalar','v','set up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fundar','v','set up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('armar','v','set up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse','v','sit down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quedarse','v','saty behind','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargarse de','loc v','take care of','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocuparse de','loc v','take care of','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuidar de','loc v','take care of','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitar','v','take away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('requisar','v','take away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('confiscar','v','take away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despegar','v','take off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('participar','v','take part','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener lugar','loc v','take place','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empezar a hacer','loc v','take up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar','v','take up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('iniciar','v','take up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('emprender','v','take up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tirar','v','throw away','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('organizar','v','tidy up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','v','tidy up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('probarse','v','try on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('probarse ropa','loc v','try on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar','v','turn down','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convertirse en','loc v','turn into','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('transformarse en','loc v','turn into','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('girar','v','turn into','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','v','turn off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salirse de','loc v','turn off','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encender','v','turn on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volverse en contra de','loc v','turn on','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejarse caer','loc v','turn up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('caer','v','turn up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aparecer','v','turn up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','v','turn up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despertarse','v','wake up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arrastrar','v','wash up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fregar','v','wash up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lavar','v','wash up','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('agotar','v','wear out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cansar','v','wear out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fatigar','v','wear out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ejercitarse','v','work out','phr v','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer ejercicio','loc v','work out','phr v','phrasal verbs')");


            /**TODO CITY AND NATURE*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('compras','n','shopping','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empleo','n','employment','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vida nocturna','n','night-life','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('transporte','n','transport','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aire puro','n','fresh air','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aire fresco','n','fresh air','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aire limpio','n','fresh air','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salud','n','health','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estilo de vida','n','way of life','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entretenimiento','n','entertainment','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('diversión','n','entertainment','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estudios','n','education','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('educación','n','education','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('formación','n','education','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('campo','n','countryside','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('campo','n','field','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sembrados','n','field','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('banco','n','bench','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('banco para sentarse','n','bench','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tanda','n','batch','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('grupo de personas','n','batch','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pobreza','n','poverty','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('combustible','n','fuel','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gasolina','n','fuel','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('basura','n','rubbish','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('habitantes','n','inhabitants','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('minerales','n','minerals','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('predicción','n','forecast','n','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pronóstico','n','forecast','n','city and nature')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('polvoriento','adj','dusty','adj','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('urgente','adj','urgent','adj','city and nature')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('respirar','v','breathe','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir','v','destroy','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('frenar a alguien','v','prevent','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('impedir','v','prevent','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prevenir','v','prevent','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rescatar','v','rescue','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salvar','v','rescue','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arruinar','v','spoil','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar a perder','v','spoil','v','city and nature')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir','v','destroy','v','city and nature')");

            /**TODO CLOTHES AND PERSONAL THINGS*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ropas','n','clothes','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ropa','n','clothe','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chaqueta','n','jacket','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('manga','n','sleeve','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traje','n','suit','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bata','n','coat','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pantalón vaquero','n','jeans','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('uniforme','n','uniform','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrigo','n','coat','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chaquetón','n','coat','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bota','n','boot','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('zapato','n','shoe','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('corbata','n','tie','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cinturón','n','belt','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuello','n','collar','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuello (camisa)','n','collar','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('collar','n','collar','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bolsillo','n','pocket','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('maleta','n','bag','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mochila','n','backpack','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('camiseta','n','shirt','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('falda','n','skirt','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('calcetines','n','socks','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('medias','n','tights','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mallas','n','tights','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lana','n','wool','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('algodón','n','cotton','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mancha','n','spot','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('granit','n','spot','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lunar','n','spot','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('franja','n','stripe','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('raya','n','stripe','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cremallera','n','zip','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('botón','n','button','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bata','n','white coat','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ropa interior','n','underwear','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('secador','n','hairdryer','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('peine','n','comb','n','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cepillo','n','brush','n','clothes and personal things')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar puesto','v','wear','v','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atar','v','tie','v','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cepillarse el pelo','v','brush hair','v','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cepillarse','v','brush','v','clothes and personal things')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lavarse','v','brush','v','clothes and personal things')");


            /**TODO economy, finances and shops*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tienda','n','shop','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comercio','n','shop','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('crédito','n','charge','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('débito','n','charge','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cargo','n','charge','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cheque','n','cheque','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('billete','n','note','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('billete','n','bill','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('moneda','n','coin','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambio','n','coin exchange','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recibo','n','receipt','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('factura','n','receipt','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('propina','n','tip','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ascensor','n','lift','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chollo','n','bargain','n','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ganga','n','bargain','n','economy, finances and shops')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ganar','v','earn','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ahorrar','v','save','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deber','v','owe','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pedir prestado','v','borrow','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prestar','v','lend','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer compras','v','shop','v','economy, finances and shops')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cobrar','v','charge','v','economy, finances and shops')");

            /**TODO holidays and luggage*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('equipaje','n','luggage','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('afuera - OTHER','n','outside','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacia fuera - OTHER','n','outside','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vida nocturna','n','nightlife','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('preparación de las maletas','n','packing','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('nervioso','n','nervous','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('de los nervios','n','nervous','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ropas','n','clothes','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vacaciones','n','holiday','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('al extranjero','n','abroad','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extranjero','n','abroad','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('plástico','n','plastic','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('de plástico','n','plastic','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglo','n','arrangement','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disposición','n','arrangement','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('teléfono','n','phone','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('agencia de viajes','n','travel agency','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estante','n','shelf','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repositor','n','shelf','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('librería','n','shelf','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('biblioteca','n','shelf','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escritorio','n','desk','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mostrador','n','desk','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('viaje','n','trip','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('excursión','n','trip','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bolígrafo','n','pen','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('folleto','n','brochure','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hotel','n','hotel','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('campo','n','countryside','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gafas de sol','n','sunglasses','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('almeja','n','shell','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('concha','n','shell','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('avión','n','plane','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer fotos','n','taking photos','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('natación','n','swimming','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('autocar','n','coach','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('postal','n','postcard','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tren','n','train','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('casa de huéspedes','n','guest house','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coche','n','car','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar el sol','n','sunbathing','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tienda de campaña','n','tent','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('crema solar','n','suntain lotion','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('artesanía','n','handicraft','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trabajos manuales','n','handicraft','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('playa','n','beach','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guía turística','n','guide book','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('picnic','n','picnic','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('personal','n','staff','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empleados','n','staff','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tripulación','n','crew','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empleados','n','crew','n','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer turismo','n','sightseeing','n','holidays and luggage')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('discutir','v','discuss','v','holidays and luggage')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hablar','v','discuss','v','holidays and luggage')");

            /**TODO Hhouse and rooms*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dormitorio','n','bedroom','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('edredón','n','quilt','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colcha','n','quilt','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estante','n','shelf','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repisa','n','shelf','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('expositor','n','shelf','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('biblioteca','n','shelf','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('librería','n','shelf','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('persiana','n','blind','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ciego – OTHER','n','blind','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cortina','n','curtain','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('clóset','n','closet','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('armario','n','closet','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('manta','n','blanket','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comedor','n','diving room','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sala de estar','n','living room','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('jardín','n','garden','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cocina','n','kitchen','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuarto de baño','n','bathroom','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('baño','n','bathroom','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escaleras','n','stairs','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('peldaño','n','stair','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escalón','n','stair','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vestíbulo','n','hallway','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recibidor','n','hallway','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasillo','n','hallway','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despensa','n','storeroom','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('almacén','n','storeroom','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('garaje','n','garage','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('balcón','n','balcony','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sótano','n','basement','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lavavajillas','n','dishwasher','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mesa de café','n','coffe table','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fogón','n','cooker','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('armario','n','wardrobe','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ropero','n','wardrobe','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lavabo','n','washbasin','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lámpara','n','lamp','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('toallero','n','towel rail','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cómoda','n','chest of drawers','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cajonera','n','chest of drawers','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('frigorífico','n','fridge','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('espejo','n','mirror','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pila','n','sink','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fregadero','n','sink','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tocador','n','dressing table','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ducha','n','shower','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sofá','n','sofa','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('máquina de coser','n','sewing machine','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('jarrón','n','vase','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('florero','n','vase','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cajón','n','drawer','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mesa de noche','n','night stand','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sábana','n','bed sheet','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buhardilla','n','loft','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ático','n','loft','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desván','n','loft','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ático','n','attic','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buhardilla','n','attic','n','house and rooms')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desván','n','attic','n','house and rooms')");

            /**TODO JOBS AND ACTIVITIES*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buceo','n','scuba','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buceo','n','diving','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arquitecto','n','architect','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arquitectura','n','architecture','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('médico','n','doctor','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('medicina','n','medicine','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abogado','n','lawyer','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ley','n','law','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derecho','n','law','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('artista','n','artist','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arte','n','art','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('concinero','n','cook','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cocina','n','cooking','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ingeniero','n','engineer','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ingeniería','n','engineering','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guía turístico','n','tourist guide','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('turismo','n','tourism','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('peluquero','n','haridresser','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('peluquería','n','hairdressing','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('periodista','n','journalist','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('periodismo','n','journalism','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empresaria','n','businesswoman','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mujer de negocios','n','businesswoman','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('negocios','n','business','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('actor','n','actor','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('interpretación','n','acting','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('actuación','n','acting','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('actriz','n','actress','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('farmacéutico','n','chemist','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('química','n','chemistry','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('biólogo','n','biologist','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('biología','n','biology','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('físico','n','physicist','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('física','n','physics','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('músico','n','musician','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('música','n','music','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('utilidad','n','application','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplicación','n','application','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('organización','n','organization','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('título','n','qualification','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('certificado','n','qualification','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decisión','n','decision','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('veredicto','n','decision','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('operación','n','operation','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('procedimiento','n','operation','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empleo','n','employment','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('profesión','n','employment','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trabajador','n','employee','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('anuncio','n','advertisement','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('publicidad','n','advertisement','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gobierno','n','goverment','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dirección','n','management','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('manejo','n','management','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('jubilación','n','retirement','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguro','n','insurance','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('éxito','n','success','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('triunfador','n','success','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('controlador de tráfico','n','controlling traffic','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('microscopio','n','microscope','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('agencia de publicidad','n','advertising agency','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ayuda al consumidor','n','helping customer','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('equipamiento','n','equipment','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('equipo','n','equipment','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('camarero','n','waiter','n','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('camarera','n','waitress','n','jobs and activities')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bucear','v','dive','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse','v','apply','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplicarse','v','apply','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('organizar','v','organize','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cimplir los requisitos','v','qualify','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar cualificado','v','qualify','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decidir','v','decide','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('decidirse','v','decide','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('operar','v','operate','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('manejar','v','operate','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('emplear','v','employ','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('contratar a','v','employ','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('anunciar','v','advetise','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gobernar','v','govern','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dirigir','v','manage','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('manejar','v','manage','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gestionar','v','manage','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retirarse','v','retire','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('jubilarse','v','retire','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asegurar','v','insure','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener éxito','v','succeed','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asegurar','v','claim','v','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ganar dinero','v','earn money','v','jobs and activities')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exitoso','adj','successful','adj','jobs and activities')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('capaz','adj','successful','adj','jobs and activities')");

            /**TODO PERSONAL DESCRIPTION*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pelo rizado','adj','curly hair','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' pelo liso','adj','straight hair','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rubio','adj','fair-haired','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pelo claro','adj','fair-haired','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('maduro','adj','middle-aged','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cansado','adj','tired','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('soñoliento','adj','tired','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gafas','adj','glasses','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sonriente','adj','smiling','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atractivo','adj','attractive','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seductor','adj','attractive','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fascinante','adj','attractive','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('feo','adj','ugly','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trabajador','adj','hard-working','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('diligente','adj','hard-working','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perezoso','adj','lazy','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vago','adj','lazy','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cauto','adj','careful','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuidadoso','adj','careful','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descuidado','adj','careless','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('negligente','adj','careless','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tímido','adj','shy','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vergonzoso','adj','shy','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alegre','adj','cheerful','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('triste','adj','miserable','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fuerte','adj','strong','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('debil','adj','weak','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tonto','adj','foolish','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ingenuo','adj','foolish','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sabio','adj','wise','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gracioso','adj','funny','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chistoso','adj','funny','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('divertido','adj','amussing','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gracioso','adj','amussing','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('claro','adj','fair','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pálido','adj','fair','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('blanco','adj','fair','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rubio','adj','blond','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esbelto','adj','slim','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('delgado','adj','slim','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fino','adj','thin','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('delgado','adj','thin','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('honesto','adj','honest','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('honrado','adj','honest','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('honrado','adj','truthful','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('veraz','adj','truthful','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprensivo','adj','understanding','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('paciente','adj','patient','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aburrido','adj','dull','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('soso','adj','dull','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aburrido','adj','boring','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tedioso','adj','boring','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ansioso','adj','anxious','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inquieto','adj','anxious','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('nervioso','adj','anxious','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('moreno','adj','dark haired','adj','personal description')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('castaño','adj','brown','adj','personal description')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('señalar a','v','point at','v','personal description')");

            /**TODO TRANSPORT*/
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conductor','n','driver','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('medidor','n','meter','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('contador','n','meter','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tarifa','n','fare','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('precio del pasaje','n','fare','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('illete','n','ticket','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('andén','n','platform','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('maquinista','n','driver','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('horario','n','timetable','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vagón','n','coach','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estación','n','station','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('piloto','n','pilot','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('auxiliar','n','attendant','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargado','n','attendant','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('azafata','n','flight attendant','n','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tarjeta de embarque','n','boarding pass','n','transport')");

            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger (taxi','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar (taxi','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pillar (taxi','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pillar','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','catch','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger (taxi','v','take','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar (taxi','v','take','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('coger','v','take','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar','v','take','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abordar','v','get on','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subirse','v','get on','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('registrarse','v','check in','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder','v','miss','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder (transporte)','v','miss','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aterrizar','v','land','v','transport')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despegar','v','take off','v','transport')");



            /**TODO CATEGORÍAS*/
            db.execSQL("INSERT INTO CATEGORIES VALUES('prhasal verbs')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('city and nature')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('clothes and personal things')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('jobs and activities')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('economy, finances and shops')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('holidays and luggage')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('house and rooms')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('personal descriptions')");
            db.execSQL("INSERT INTO CATEGORIES VALUES('transport')");

            System.out.println("*******TERMINÉ DE AÑADIR TUPLAS*********");
        }
        cursor.close();
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
                "WHERE wordSP="+spanish.getFirst()+" AND typeSP="+spanish.getSecond(),null);

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
                "WHERE wordEN="+english.getFirst()+" AND typeEN="+english.getSecond(),null);
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
            res.put(cursor.getString(2), cursor.getString(3));
        cursor.close();
        db.close();
        return res;
    }

    /**
     * Recibe un String que representa una palabra en inglés con su
     * y devuelve un Map que representa todas las palabras que coinciden
     * con dicha traducción
     * */
    public List<String> translateFromEnglish(String english){
        List<String> res = new ArrayList<>();
        res.add(english);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS " +
                "WHERE wordEN='" + english + "'", null);
        while(cursor.moveToNext())
            res.add(cursor.getString(0));
        cursor.close();
        db.close();
        return res;
    }

    public List<String[]> getAll(){
        List<String[]> res = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS", null);
        while(cursor.moveToNext()){
            String aux[] = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)};
            res.add(aux);
        }
        cursor.close();
        db.close();
        return res;
    }

    /**Devuelve todas las palabras existentes en la BD organizadas de la siguiente manera:
     * palabra en inglés - traducciones al español. */
    public List<List<String>> getAllClasified(){
        List<List<String>> res = new ArrayList<>();
        List<String> showed = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS",null);

        while(cursor.moveToNext())
            if(!showed.contains(cursor.getString(2)))
                res.add(translateFromEnglish(cursor.getString(2)));


        cursor.close();
        db.close();
        return res;
    }

    /**Devuelve todas las palabras existentes, desde el inglés y sus traducciones al español.
     * Están clasificadas según el tipo de palabra*/
    public List<Word> getAllEnglishWords(){
        List<Word> res = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS ORDER BY wordEN, typeEN ASC",null);

        while(cursor.moveToNext()){
            String english = cursor.getString(2);
            String type = cursor.getString(3);

            Word word = Word.create(english,type);

            if(res.contains(word))
                res.get(res.size()-1).addTranslation(Word.create(cursor.getString(0), cursor.getString(1)));
            else{
                word.addTranslation(Word.create(cursor.getString(0),cursor.getString(1)));
                res.add(word);
            }
        }

        cursor.close();
        db.close();

        return res;
    }

    public List<Word> getWordFromEn(String word){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDTRANSLATIONS WHERE wordEN ='" + word + "' ORDER BY wordEN,typeEN ASC", null);

        List<Word> res = new ArrayList<>();

        while(cursor.moveToNext()){
            String english = cursor.getString(2);
            String type = cursor.getString(3);

            Word wordW = Word.create(english,type);

            if(res.contains(wordW))
                res.get(res.size()-1).addTranslation(Word.create(cursor.getString(0), cursor.getString(1)));
            else{
                wordW.addTranslation(Word.create(cursor.getString(0), cursor.getString(1)));
                res.add(wordW);
            }
        }

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


    public List<Word> getAllFavouritesEn(){
        //FAVOURITESEN

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM FAVOURITES ORDER BY wordEN ASC", null);

        List<Word> res = new ArrayList<>();

        while(cursor.moveToNext()){
            List<Word> aux = getWordFromEn(cursor.getString(0));
            for(Word w:aux)
                res.add(w);
        }

        cursor.close();
        db.close();

        return res;
    }

    public void addFavouriteEn(String word, String token){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO FAVOURITES VALUES('" + word + "')");
        db.close();
        FavouritesOperationsAsync foa = new FavouritesOperationsAsync();
        foa.execute(word,"add",token);
    }

    public void removeFavouriteEn(String word, String token){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM FAVOURITES WHERE wordEN = '" + word + "'");
        db.close();
        FavouritesOperationsAsync foa = new FavouritesOperationsAsync();
        foa.execute(word, "remove", token);
    }


    /**METHODS RELATED WITH THE WORDSTATS TABLE*/
    public void addHit(String word, String token){
        SQLiteDatabase dbR = getReadableDatabase();
        SQLiteDatabase dbW = getWritableDatabase();
        Cursor cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        if(cursor.getCount()==0){ //Esto es porque la palabra aún no apareció en ningún juego
            dbW.execSQL("INSERT INTO WORDSTATS VALUES ('"+word+"', 1, 0)");
        } else {
            dbW.execSQL("UPDATE WORDSTATS SET hits = hits + 1 WHERE word = '"+word+"'");
        }


        //Sacar el número de hits y fails mediante consulta
        cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        cursor.moveToNext();
        int hits = cursor.getInt(1);
        int fails = cursor.getInt(2);
        cursor.close();
        dbR.close();
        dbW.close();
        //crear la asynctask y pasarle word, hits y fails
        WordStatsOperationsAsync woa = new WordStatsOperationsAsync();
        woa.execute(word,""+hits,""+fails,token);
    }

    public void addFail(String word, String token){
        SQLiteDatabase dbR = getReadableDatabase();
        SQLiteDatabase dbW = getWritableDatabase();
        Cursor cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        if(cursor.getCount()==0){ //Esto es porque la palabra aún no apareció en ningún juego
            dbW.execSQL("INSERT INTO WORDSTATS VALUES ('"+word+"', 0, 1)");
        } else {
            dbW.execSQL("UPDATE WORDSTATS SET fails = fails + 1 WHERE word = '"+word+"'");
        }

        //Sacar el número de hits y fails mediante consulta
        cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        cursor.moveToNext();
        int hits = cursor.getInt(1);
        int fails = cursor.getInt(2);
        cursor.close();
        dbR.close();
        dbW.close();
        //crear la asynctask y pasarle word, hits y fails
        WordStatsOperationsAsync woa = new WordStatsOperationsAsync();
        woa.execute(word, "" + hits, "" + fails, token);
    }

    public List<WordStat> getBestWords(){
        List<WordStat> res = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDSTATS WHERE hits > fails AND hits > 0 ORDER BY (hits - fails) ASC",null);

        while(cursor.moveToNext()){
            List<Word> aux = getWordFromEn(cursor.getString(0));
            for(Word w:aux){
                WordStat ws = WordStat.create(w.getMainWord(),w.getTranslations(),w.getType(),new Integer(cursor.getString(1)), new Integer(cursor.getString(2)));
                res.add(ws);
            }

        }

        cursor.close();
        db.close();

        return res;
    }

    public List<WordStat> getWorstWords(){
        List<WordStat> res = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORDSTATS WHERE fails > hits AND fails > 0 ORDER BY (fails - hits) ASC",null);

        while(cursor.moveToNext()){
            List<Word> aux = getWordFromEn(cursor.getString(0));
            for(Word w:aux){
                WordStat ws = WordStat.create(w.getMainWord(),w.getTranslations(),w.getType(),new Integer(cursor.getString(1)), new Integer(cursor.getString(2)));
                res.add(ws);
            }

        }

        cursor.close();
        db.close();

        return res;
    }

    /** Métodos para sincronizar desde la API*/
    public void resetDB(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM WORDSTATS");
        db.execSQL("DELETE FROM WORDTRANSLATIONS");
        db.execSQL("DELETE FROM FAVOURITES");
        db.close();
    }

    public void insertWordTranslation(WordTranslation wt){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('" + wt.getWordSP() + "', '" +
                wt.getTypeSP() + "', '" + wt.getWordEN() + "', '" + wt.getTypeEN() + "', '" +
                wt.getCategory() + "')");
        db.close();
    }

    public void insertFavourite(String word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO FAVOURITES VALUES('"+word+"')");
        db.close();
    }

    public void insertWordStat(WordStat2 ws){



        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO WORDSTATS VALUES('"+ws.getWord()+"', '"+ws.getHits()+"', '"+ws.getFails()+"')");
        db.close();
    }

}