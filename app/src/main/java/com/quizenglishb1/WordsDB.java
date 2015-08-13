package com.quizenglishb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.quizenglishb1.com.quizenglishb1.utilities.CoupleString;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;
import com.quizenglishb1.com.quizenglishb1.utilities.WordStat;

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

    private String createFAVOURITESEN = "CREATE TABLE IF NOT EXISTS FAVOURITESEN"+
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
        db.execSQL(createFAVOURITESEN);
        db.execSQL(createFAVOURITESSP);
        db.execSQL(createWORDSTATS);
        db.execSQL(createCATEGORYS);
        init(db);
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
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener en cuenta','phrv','allow for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prever','phrv','allow for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' replicar','phrv','answer back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' solicitar','phrv','apply for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('saber de alguien','phrv','ask for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('solicitar','phrv','ask for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pedir','phrv','ask for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a punto de','phrv','be about to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('intentar encontrar','phrv','be after','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar en contra de','phrv','be against','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar después de un largo tiempo de ausencia','phrv','be back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar tras mucho tiempo','phrv','be back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','be down on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','be down on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a favor de','phrv','be for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar en casa','phrv','be in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar','phrv','be on to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','be on to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar lejos de','phrv','be out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse de la cama','phrv','be up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inclinarse','phrv','bend down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extinguir un fuego','phrv','blow out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir con una explosión','phrv','blow up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inflar con aire','phrv','blow up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir','phrv','break down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estropearse','phrv','break down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar a la fuerza','phrv','break in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('interrumpir','phrv','break into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dividir','phrv','break off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('separar','phrv','break off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar','phrv','braek off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','break off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar por la fuerza','phrv','break out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar','phrv','break out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atravesar','phrv','break through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desintegrarse','phrv','break up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','break up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','break up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conseguir','phrv','bring about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traer de vuelta','phrv','bring back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','bring back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','bring down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rebajar','phrv','bring down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proponer','phrv','bring forward','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('presentar','phrv','bring forward','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','bring in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducir','phrv','bring in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','bring in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('producir','phrv','bring in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('causar','phrv','bring on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('favorecer','phrv','bring on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mostrar','phrv','bring out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('publicar','phrv','bring out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convencer','phrv','bring round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer volver en sí','phrv','bring round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','bring up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar la atención sobre','phrv','bring up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('educar','phrv','bring up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('criar','phrv','bring up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar un lugar','phrv','call at','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','call for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer entrar','phrv','call in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pedir la ayuda de','phrv','call in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cancelar','phrv','call off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar a una persona','phrv','call on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exclamar','phrv','call out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gritar','phrv','call out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar voces','phrv','call out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar al servicio militar','phrv','call up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('preocuparse por','phrv','care about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','carry on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir','phrv','carry on with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','carry on with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar a cabo','phrv','carry out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('realizar','phrv','carry out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar cosas de sitio','phrv','clear away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar cosas de orden','phrv','clear away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pagar','phrv','clear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('liquidar','phrv','clear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('irse','phrv','clear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','clear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('limpiar','phrv','clear out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','clear out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vaciar','phrv','clear out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer bueno','phrv','clear up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despejar después de la lluvia','phrv','clear up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','clear up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resolver','phrv','clear up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar por casualidad','phrv','come across','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar por casualidad','phrv','come upon','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','come along','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','come on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','come along','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','come on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','come away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','come back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','come back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descender','phrv','come down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proceder','phrv','come from','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','come in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','come into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','come off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','come off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' avanzar','phrv','come on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('venir','phrv','come on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar','phrv','come on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser revelado','phrv','come out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser publicado','phrv','come out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('declararse','phrv','come out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('soltar','phrv','come out with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descolgarse','phrv','come out with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','come over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','come round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver en sí','phrv','come round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantar','phrv','come up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser mencionado','phrv','come up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','come up to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acercarse','phrv','come up to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encenderse','phrv','come up to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('piropear','phrv','compliment on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('preocuparse por','phrv','concern about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglárselas para salir de obstáculos','phrv','cope with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no poder soportar algo','phrv','cope with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir a rastras','phrv','crawl up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cruzar al otro lado','phrv','cross over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('truncar','phrv','cut off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','check through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repartir','phrv','deal out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocuparse','phrv','deal with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener relaciones con','phrv','deal with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('depender de','phrv','depend on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('confiar en','phrv','depend on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desenterrar','phrv','dig up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('remover la tierra','phrv','dig up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abolir','phrv','do away with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suprimir','phrv','do away with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deshacerse','phrv','do away with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' recordar','phrv','do out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('renovar','phrv','do out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cerrar','phrv','do up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrochar','phrv','do up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('redecorar','phrv','do up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prescindir de','phrv','do without','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','draw away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','draw back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar los vehículos','phrv','draw up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder el contacto','phrv','drift out to touch','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un momento','phrv','drop in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un momento','phrv','drop into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar inesperadamente','phrv','drop in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar inesperadamente','phrv','drop into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','drop off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apearse','phrv','drop off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','drop off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desprenderse','phrv','drop out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','drop out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar de asistir','phrv','drop out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recurrir','phrv','fall back on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar mano','phrv','fall back on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quedarse atrás','phrv','fall behind','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enamorarse de','phrv','fall for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disminuir','phrv','fall off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('menguar','phrv','fall off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fracasar','phrv','fall trough','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar a tientas','phrv','feel about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apatecer','phrv','feel like','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('compadecerse','phrv','feel for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cumplimentar','phrv','fill in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cubrir','phrv','fill in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','find out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse cuenta de','phrv','find out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('circular','phrv','get about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('viajar mucho','phrv','get about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prosperar','phrv','get ahead','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitar de en medio','phrv','get away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar a casa','phrv','get back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperar una posesión','phrv','get back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','get down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar en transporte','phrv','get in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un transporte','phrv','get in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','get off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer progresos','phrv','get on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','get on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener amistad','phrv','get on with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llearse bien con alguien','phrv','get on with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','get on with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','get out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser libre de una ocupación','phrv','get out off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','get over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer comprender','phrv','get over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vencer','phrv','get over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reponerse de','phrv','get over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('persuadir','phrv','get round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar tiempo','phrv','get round to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','get through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aprobar un examen','phrv','get through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse en contacto','phrv','get through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse de la cama','phrv','get up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aprender','phrv','get up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('organizar','phrv','get up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regalar','phrv','give away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','give away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traicionar','phrv','give away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperar algo propio','phrv','give back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','give back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar','phrv','give in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rendirse','phrv','give in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('consentir','phrv','give in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enviar','phrv','give out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('anunciar','phrv','give out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('distribuir','phrv','give out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cesar en un intento','phrv','give up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','give up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','give up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estropearse','phrv','give up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('andar de un sitio para otro','phrv','go about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','go away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('marcharse','phrv','go away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','go back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('faltar a algo','phrv','go back on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','go down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder','phrv','go down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enfermar de','phrv','go down with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atacar','phrv','go for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dedicarse a','phrv','go for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir por','phrv','go for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar muy interesado en','phrv','go in for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprar','phrv','go in for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('investigar','phrv','go into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en','phrv','go into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asociarse','phrv','go in with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' irse','phrv','go off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','go off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasárselo','phrv','go off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','go on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar ua casa','phrv','go out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','go out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','go out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','go out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repetir un examen','phrv','go over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser suficiente','phrv','go round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar vueltas','phrv','go round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('circular','phrv','go round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('examinar cuidadosamente','phrv','go through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','go through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repasar','phrv','go through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','go through with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar un proyecto a cabo','phrv','go through with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','go up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aumentar','phrv','go up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','go with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir bien con','phrv','go with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer juego con','phrv','go with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','hand back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','hand down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entregar','phrv','hand in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('distribuir','phrv','hand out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entregar','phrv','hand over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar a cada persona un regalo','phrv','hand round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasar de mano en mano','phrv','hand round','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar al teléfono','phrv','hold on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplazar','phrv','hold over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('posponer','phrv','hold over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse prisa para volver','phrv','hurry back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('participar en','phrv','join in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retener','phrv','keep back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocultar','phrv','keep back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sujetar','phrv','keep down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dominar','phrv','keep down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no dejar salir','phrv','keep in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener encendido','phrv','keep in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener contacto con','phrv','keep in touch with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','keep on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permanecer fuera','phrv','keep out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('excluir','phrv','keep out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener','phrv','keep up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar sin sentido','phrv','knock out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proveerse de','phrv','lay in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','lay out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inventar','phrv','lay out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','lay out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('almacenar','phrv','lay up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ahorrar','phrv','lay up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar de hacer algo','phrv','leave off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('omitir','phrv','leave out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prescindir de','phrv','leave out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permitir la entrada','phrv','let in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perdonar','phrv','let off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar libre','phrv','let off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alquilar','phrv','let off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permitir salir','phrv','let out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prestar atención','phrv','listen to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar la mirada','phrv','look away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuidar','phrv','look after','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar','phrv','look at','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar hacia atrás','phrv','look back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver la cabeza','phrv','look back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar el pasado','phrv','look back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','look back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','phrv','look for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar algo con mucha ilusión','phrv','look forward to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar un vistazo','phrv','look in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer una breve vista','phrv','look in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar la TV','phrv','look in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('investigar','phrv','look into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser un espectador','phrv','look on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','look on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','phrv','look out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar hacia fuera','phrv','look out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener cuidado','phrv','look out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('valerse por sí mismo','phrv','look out for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a la expectativa','phrv','look out for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('releer','phrv','look over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','look over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('examinar con el fin de elegir','phrv','look through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('leer rápidamente','phrv','look through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','look up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('averiguar','phrv','look up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mejorar','phrv','look up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir hacia','phrv','make for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escaparse','phrv','make off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprender','phrv','make out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reconocer','phrv','make out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extender','phrv','make out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglárselas','phrv','make out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('declarar con falsedad','phrv','make out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inventar','phrv','make up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deidir','phrv','make up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner junto a','phrv','make up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apilar','phrv','make up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('compensar por','phrv','make up for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','make up for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mudarse de casa','phrv','move away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alejar','phrv','move away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','move away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer entrar','phrv','move in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar posesión','phrv','move in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mudarse','phrv','move into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desalojar','phrv','move out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trasladarse','phrv','move out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar muchas órdenes','phrv','order about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder el conocimiento','phrv','pass out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','pay back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('elegir','phrv','pick out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seleccionar','phrv','pick out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','pick up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprar','phrv','pick up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','pick up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('demoler','phrv','pull down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','pull down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','pull off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arrancar','phrv','pull off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lograr con éxito','phrv','pull off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir de un apuro','phrv','pull through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperarse de una enfermedad','phrv','pull through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar los coches','phrv','pull up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exponer','phrv','put across','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exponer','phrv','put over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a salvo para usar en el futuro','phrv','put aside','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar','phrv','put aside','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a salvo para usar en el futuro','phrv','put by','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar','phrv','put by','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guardar','phrv','put away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplazar','phrv','put back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver a su lugar','phrv','put back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reprimir','phrv','put down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escribir','phrv','put down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proponer','phrv','put forward','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('adelantarse','phrv','put forward','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer una queja','phrv','put in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducir','phrv','put in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('solicitar un puesto','phrv','put in for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('posponer','phrv','put off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','put off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disuadir','phrv','put off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alejar','phrv','put off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vestir','phrv','put on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse ropa','phrv','put on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encender','phrv','put on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','put out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desconectar','phrv','put out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('publicar','phrv','put out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sacar fuera','phrv','put out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar enfadado','phrv','be put out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conectar','phrv','put through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner una llamada de teléfono','phrv','put through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('instalar','phrv','put through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir los precios','phrv','put up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantar un edificio','phrv','put up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hospedar','phrv','put up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener paciencia','phrv','put up with','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aguantar','phrv','put up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner final a una llamada telefónica','phrv','ring off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colgar','phrv','ring off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar por teléfono','phrv','ring up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perseguir','phrv','run after','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('correr a lo largo de','phrv','run along','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escaparse','phrv','run away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('correr detrás de','phrv','run after','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atropellar','phrv','run down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desacreditar','phrv','run down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar','phrv','run down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','run in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar corriendo','phrv','run in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chocar','phrv','run into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar','phrv','run into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrarse con algo inesperadamente','phrv','run into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar a alguien','phrv','run into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar a alguien','phrv','run across','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vaciar','phrv','run off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar salir','phrv','run off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('irse corriendo','phrv','run off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabarse las existencias','phrv','run out of','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atropellar','phrv','run over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rebasar el límite','phrv','run over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traspasar','phrv','run through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gastar','phrv','run through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','run up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar contra','phrv','run up against','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar precipitadamente','phrv','rush into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargarse de','phrv','see about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','see about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','see over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar a la puerta','phrv','see out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar a cabo','phrv','see through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargarse de','phrv','see to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reparar','phrv','see to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empezar','phrv','set in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse en camino','phrv','set off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resaltar','phrv','set off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despedir','phrv','set off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un viaje','phrv','set out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','set out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('establecer un récord','phrv','set up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un nuevo negocio','phrv','set up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar','phrv','show up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descansar','phrv','sit back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse cómodamente','phrv','sit back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse','phrv','sit down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aguantar','phrv','sit out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse al aire libre','phrv','sit out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('incorporarse','phrv','sit up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse derecho','phrv','sit up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse cuenta','phrv','sit up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deslizarse','phrv','slip in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducirse sin ruido','phrv','slip in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deslizarse','phrv','slip out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','slip out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','slip out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destrozar','phrv','smash up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desbordarse','phrv','spill over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derramarse','phrv','spill over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar presente','phrv','stand by','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atenerse a','phrv','stand by','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('representar','phrv','stand for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ofrecerse para','phrv','stand for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','stand out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sobresalir','phrv','stand out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantenerse firme','phrv','stand out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('defender oralmente','phrv','stand up for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resistir','phrv','stand up to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','step into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('intervenir','phrv','step into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sobresalir','phrv','stick up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar con los pelos de punta','phrv','stick up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('girarse bruscamente','phrv','swing around','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retractarse','phrv','take aback','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desdecirse','phrv','take aback','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','take aback','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parecerse a','phrv','take after','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevarse','phrv','take away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('restar','phrv','take away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','take back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retirar','phrv','take back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escribir un dictado','phrv','take down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','take down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descolgar','phrv','take down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprender','phrv','take in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','take in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('engañar','phrv','take in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('embaucar','phrv','take in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitar','phrv','take off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desvestirse','phrv','take off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('imitar','phrv','take off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despegar','phrv','take off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empezar a tener éxito','phrv','take off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aceptar','phrv','take on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('contratar','phrv','take on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quejarse','phrv','take on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sacar','phrv','take out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extraer','phrv','take out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entretener','phrv','take out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asumir una responsabilidad','phrv','take over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar el control','phrv','take over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar posesión','phrv','take over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gustar','phrv','take to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un hábito','phrv','take to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un estudio','phrv','take up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un deporte','phrv','take up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocupar','phrv','take up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('replicar','phrv','talk back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('discutir sobre','phrv','talk over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convencer','phrv','talk into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no parar de hablar','phrv','talk on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener tendencia a','phrv','tend to','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pensar acerca de','phrv','think about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('meditar','phrv','think about','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','think of','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener en cuenta','phrv','think of','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('planear cuidadosamente','phrv','think out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reflexionar','phrv','think over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('imaginar','phrv','think up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deshacerse de','phrv','throw off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar repentinamente','phrv','throw up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vomitar','phrv','throw up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar','phrv','trip over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('caer','phrv','trip over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('probarse la ropa','phrv','try on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ensayar','phrv','try out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a prueba','phrv','try out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('impedir la entrada','phrv','turn away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despedir','phrv','turn away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar la vuelta','phrv','turn back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('doblar','phrv','turn back','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar un trabajo','phrv','turn down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar una oferta','phrv','turn down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','turn down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir a la cama','phrv','turn in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar a ser','phrv','turn into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convertirse','phrv','turn into','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','turn off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desconectar','phrv','turn off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar una dirección','phrv','turn off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encender','phrv','turn on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conectar','phrv','turn on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','turn out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extinguir','phrv','turn out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('producir','phrv','turn out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('expulsar','phrv','turn out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse','phrv','turn out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar la posición','phrv','turn over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ceder','phrv','turn over','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrir','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrir','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aparecer','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','turn up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('causar confusión','phrv','turn upside down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar de posición','phrv','turn upside down','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar a','phrv','wait for','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('servir a alguien','phrv','wait on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despertarse','phrv','wake up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','walk in','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir andando','phrv','walk on','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guiar','phrv','walk through','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener cuidado','phrv','watch out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar alerta','phrv','watch out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gastar','phrv','wear away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('consumir','phrv','wear away','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitarse','phrv','wear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','wear off','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('usar','phrv','wear out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('envolver','phrv','wind up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enrollar','phrv','wind up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar vueltas','phrv','wind up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir bien','phrv','work out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resolver','phrv','work out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('agotar','phrv','work out','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desarrollar','phrv','work up','phrv','phrasal verbs')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fomentar','phrv','work up','phrv','phrasal verbs')");

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
        Cursor cursor = db.rawQuery("SELECT * FROM FAVOURITESEN ORDER BY wordEN ASC", null);

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

    public void addFavouriteEn(String word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO FAVOURITESEN VALUES('" + word + "')");
        db.close();
    }

    public void removeFavouriteEn(String word){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM FAVOURITESEN WHERE wordEN = '"+word+"'");
        db.close();
    }


    /**METHODS RELATED WITH THE WORDSTATS TABLE*/
    public void addHit(String word){
        SQLiteDatabase dbR = getReadableDatabase();
        SQLiteDatabase dbW = getWritableDatabase();
        Cursor cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        if(cursor.getCount()==0){ //Esto es porque la palabra aún no apareció en ningún juego
            dbW.execSQL("INSERT INTO WORDSTATS VALUES ('"+word+"', 1, 0)");
        } else {
            dbW.execSQL("UPDATE WORDSTATS SET hits = hits + 1 WHERE word = '"+word+"'");
        }
        cursor.close();
        dbR.close();
        dbW.close();
    }

    public void addFail(String word){
        SQLiteDatabase dbR = getReadableDatabase();
        SQLiteDatabase dbW = getWritableDatabase();
        Cursor cursor = dbR.rawQuery("SELECT * FROM WORDSTATS WHERE word='"+word+"'",null);
        if(cursor.getCount()==0){ //Esto es porque la palabra aún no apareció en ningún juego
            dbW.execSQL("INSERT INTO WORDSTATS VALUES ('"+word+"', 0, 1)");
        } else {
            dbW.execSQL("UPDATE WORDSTATS SET fails = fails + 1 WHERE word = '"+word+"'");
        }
        cursor.close();
        dbR.close();
        dbW.close();
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

}