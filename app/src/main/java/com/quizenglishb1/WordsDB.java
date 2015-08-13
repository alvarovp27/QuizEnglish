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
            dbW.execSQL("UPDATE WORDSTATS SET hits = hits + 1 WHERE word = '"+word+"')");
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
            dbW.execSQL("UPDATE WORDSTATS SET fails = fails + 1 WHERE word = '"+word+"')");
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