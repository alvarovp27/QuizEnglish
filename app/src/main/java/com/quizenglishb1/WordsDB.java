package com.quizenglishb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.quizenglishb1.com.quizenglishb1.utilities.CoupleString;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;

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
            "typeEN TEXT)";

    private String createFAVOURITESEN = "CREATE TABLE IF NOT EXISTS FAVOURITESEN"+
            "(wordEN TEXT)";

    private String createFAVOURITESSP = "CREATE TABLE IF NOT EXISTS FAVOURITESSP"+
            "(wordSP TEXT)";

    public WordsDB(Context context) {
        super(context, "DataBase", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createWORDTRANSLATIONTABLE);
        db.execSQL(createFAVOURITESEN);
        db.execSQL(createFAVOURITESSP);
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
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener en cuenta','phrv','allow for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prever','phrv','allow for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' replicar','phrv','answer back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' solicitar','phrv','apply for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('saber de alguien','phrv','ask for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('solicitar','phrv','ask for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pedir','phrv','ask for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a punto de','phrv','be about to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('intentar encontrar','phrv','be after','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar en contra de','phrv','be against','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar después de un largo tiempo de ausencia','phrv','be back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar tras mucho tiempo','phrv','be back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','be down on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','be down on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a favor de','phrv','be for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar en casa','phrv','be in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar','phrv','be on to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','be on to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar lejos de','phrv','be out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse de la cama','phrv','be up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inclinarse','phrv','bend down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extinguir un fuego','phrv','blow out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir con una explosión','phrv','blow up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inflar con aire','phrv','blow up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destruir','phrv','break down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estropearse','phrv','break down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar a la fuerza','phrv','break in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('interrumpir','phrv','break into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dividir','phrv','break off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('separar','phrv','break off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar','phrv','braek off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','break off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar por la fuerza','phrv','break out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar','phrv','break out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atravesar','phrv','break through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desintegrarse','phrv','break up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','break up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','break up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conseguir','phrv','bring about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traer de vuelta','phrv','bring back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','bring back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','bring down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rebajar','phrv','bring down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proponer','phrv','bring forward','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('presentar','phrv','bring forward','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','bring in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducir','phrv','bring in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','bring in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('producir','phrv','bring in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('causar','phrv','bring on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('favorecer','phrv','bring on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mostrar','phrv','bring out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('publicar','phrv','bring out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convencer','phrv','bring round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer volver en sí','phrv','bring round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','bring up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar la atención sobre','phrv','bring up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('educar','phrv','bring up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('criar','phrv','bring up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar un lugar','phrv','call at','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','call for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer entrar','phrv','call in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pedir la ayuda de','phrv','call in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cancelar','phrv','call off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar a una persona','phrv','call on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exclamar','phrv','call out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gritar','phrv','call out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar voces','phrv','call out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar al servicio militar','phrv','call up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('preocuparse por','phrv','care about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','carry on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir','phrv','carry on with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','carry on with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar a cabo','phrv','carry out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('realizar','phrv','carry out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar cosas de sitio','phrv','clear away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar cosas de orden','phrv','clear away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pagar','phrv','clear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('liquidar','phrv','clear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('irse','phrv','clear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','clear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('limpiar','phrv','clear out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','clear out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vaciar','phrv','clear out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer bueno','phrv','clear up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despejar después de la lluvia','phrv','clear up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','clear up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resolver','phrv','clear up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar por casualidad','phrv','come across','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar por casualidad','phrv','come upon','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','come along','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','come on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','come along','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','come on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','come away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','come back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','come back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descender','phrv','come down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proceder','phrv','come from','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','come in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','come into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','come off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','come off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' avanzar','phrv','come on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('venir','phrv','come on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar','phrv','come on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser revelado','phrv','come out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser publicado','phrv','come out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('declararse','phrv','come out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('soltar','phrv','come out with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descolgarse','phrv','come out with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','come over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','come round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver en sí','phrv','come round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantar','phrv','come up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser mencionado','phrv','come up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','come up to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acercarse','phrv','come up to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encenderse','phrv','come up to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('piropear','phrv','compliment on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('preocuparse por','phrv','concern about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglárselas para salir de obstáculos','phrv','cope with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no poder soportar algo','phrv','cope with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir a rastras','phrv','crawl up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cruzar al otro lado','phrv','cross over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('truncar','phrv','cut off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','check through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repartir','phrv','deal out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocuparse','phrv','deal with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener relaciones con','phrv','deal with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('depender de','phrv','depend on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('confiar en','phrv','depend on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desenterrar','phrv','dig up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('remover la tierra','phrv','dig up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abolir','phrv','do away with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suprimir','phrv','do away with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deshacerse','phrv','do away with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' recordar','phrv','do out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('renovar','phrv','do out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cerrar','phrv','do up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrochar','phrv','do up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('redecorar','phrv','do up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prescindir de','phrv','do without','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','draw away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','draw back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar los vehículos','phrv','draw up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder el contacto','phrv','drift out to touch','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un momento','phrv','drop in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un momento','phrv','drop into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar inesperadamente','phrv','drop in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar inesperadamente','phrv','drop into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','drop off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apearse','phrv','drop off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','drop off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desprenderse','phrv','drop out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','drop out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar de asistir','phrv','drop out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recurrir','phrv','fall back on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar mano','phrv','fall back on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quedarse atrás','phrv','fall behind','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enamorarse de','phrv','fall for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disminuir','phrv','fall off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('menguar','phrv','fall off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fracasar','phrv','fall trough','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar a tientas','phrv','feel about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apatecer','phrv','feel like','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('compadecerse','phrv','feel for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cumplimentar','phrv','fill in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cubrir','phrv','fill in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','find out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse cuenta de','phrv','find out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('circular','phrv','get about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('viajar mucho','phrv','get about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prosperar','phrv','get ahead','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitar de en medio','phrv','get away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar a casa','phrv','get back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperar una posesión','phrv','get back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','get down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar en transporte','phrv','get in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en un transporte','phrv','get in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','get off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer progresos','phrv','get on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','get on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener amistad','phrv','get on with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llearse bien con alguien','phrv','get on with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('progresar','phrv','get on with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','get out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','get out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser libre de una ocupación','phrv','get out off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','get over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer comprender','phrv','get over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vencer','phrv','get over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reponerse de','phrv','get over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('persuadir','phrv','get round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar tiempo','phrv','get round to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabar','phrv','get through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aprobar un examen','phrv','get through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse en contacto','phrv','get through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse de la cama','phrv','get up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aprender','phrv','get up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('organizar','phrv','get up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regalar','phrv','give away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descubrir','phrv','give away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traicionar','phrv','give away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperar algo propio','phrv','give back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','give back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar','phrv','give in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rendirse','phrv','give in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('consentir','phrv','give in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enviar','phrv','give out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('anunciar','phrv','give out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('distribuir','phrv','give out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cesar en un intento','phrv','give up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar','phrv','give up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','give up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estropearse','phrv','give up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('andar de un sitio para otro','phrv','go about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar','phrv','go away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('marcharse','phrv','go away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','go back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('faltar a algo','phrv','go back on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','go down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder','phrv','go down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enfermar de','phrv','go down with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atacar','phrv','go for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dedicarse a','phrv','go for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir por','phrv','go for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar muy interesado en','phrv','go in for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprar','phrv','go in for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('investigar','phrv','go into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar en','phrv','go into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asociarse','phrv','go in with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES(' irse','phrv','go off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','go off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasárselo','phrv','go off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','go on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar ua casa','phrv','go out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','go out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','go out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','go out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repetir un examen','phrv','go over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser suficiente','phrv','go round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar vueltas','phrv','go round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('circular','phrv','go round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('examinar cuidadosamente','phrv','go through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','go through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('repasar','phrv','go through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('terminar','phrv','go through with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar un proyecto a cabo','phrv','go through with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','go up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aumentar','phrv','go up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar','phrv','go with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir bien con','phrv','go with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer juego con','phrv','go with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','hand back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','hand down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entregar','phrv','hand in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('distribuir','phrv','hand out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entregar','phrv','hand over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar a cada persona un regalo','phrv','hand round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pasar de mano en mano','phrv','hand round','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar al teléfono','phrv','hold on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplazar','phrv','hold over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('posponer','phrv','hold over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse prisa para volver','phrv','hurry back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('participar en','phrv','join in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retener','phrv','keep back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocultar','phrv','keep back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sujetar','phrv','keep down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dominar','phrv','keep down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no dejar salir','phrv','keep in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener encendido','phrv','keep in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener contacto con','phrv','keep in touch with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('continuar','phrv','keep on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permanecer fuera','phrv','keep out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('excluir','phrv','keep out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantener','phrv','keep up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar sin sentido','phrv','knock out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proveerse de','phrv','lay in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','lay out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inventar','phrv','lay out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','lay out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('almacenar','phrv','lay up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ahorrar','phrv','lay up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar de hacer algo','phrv','leave off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('omitir','phrv','leave out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prescindir de','phrv','leave out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permitir la entrada','phrv','let in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perdonar','phrv','let off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar libre','phrv','let off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alquilar','phrv','let off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('permitir salir','phrv','let out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('prestar atención','phrv','listen to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar la mirada','phrv','look away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cuidar','phrv','look after','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar','phrv','look at','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar hacia atrás','phrv','look back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('volver la cabeza','phrv','look back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar el pasado','phrv','look back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recordar','phrv','look back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','phrv','look for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar algo con mucha ilusión','phrv','look forward to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('echar un vistazo','phrv','look in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer una breve vista','phrv','look in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar la TV','phrv','look in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('investigar','phrv','look into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ser un espectador','phrv','look on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','look on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('buscar','phrv','look out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mirar hacia fuera','phrv','look out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener cuidado','phrv','look out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('valerse por sí mismo','phrv','look out for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar a la expectativa','phrv','look out for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('releer','phrv','look over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('revisar','phrv','look over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('examinar con el fin de elegir','phrv','look through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('leer rápidamente','phrv','look through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','look up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('averiguar','phrv','look up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mejorar','phrv','look up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir hacia','phrv','make for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escaparse','phrv','make off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprender','phrv','make out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reconocer','phrv','make out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extender','phrv','make out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglárselas','phrv','make out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('declarar con falsedad','phrv','make out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('inventar','phrv','make up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deidir','phrv','make up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner junto a','phrv','make up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apilar','phrv','make up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('compensar por','phrv','make up for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','make up for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mudarse de casa','phrv','move away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alejar','phrv','move away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apartar','phrv','move away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer entrar','phrv','move in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar posesión','phrv','move in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mudarse','phrv','move into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desalojar','phrv','move out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('trasladarse','phrv','move out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar muchas órdenes','phrv','order about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perder el conocimiento','phrv','pass out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','pay back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('elegir','phrv','pick out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seleccionar','phrv','pick out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','pick up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprar','phrv','pick up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','pick up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('demoler','phrv','pull down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derribar','phrv','pull down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','pull off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arrancar','phrv','pull off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('lograr con éxito','phrv','pull off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir de un apuro','phrv','pull through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recuperarse de una enfermedad','phrv','pull through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar los coches','phrv','pull up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exponer','phrv','put across','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('exponer','phrv','put over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a salvo para usar en el futuro','phrv','put aside','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar','phrv','put aside','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a salvo para usar en el futuro','phrv','put by','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar','phrv','put by','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guardar','phrv','put away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aplazar','phrv','put back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver a su lugar','phrv','put back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reprimir','phrv','put down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escribir','phrv','put down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('proponer','phrv','put forward','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('adelantarse','phrv','put forward','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hacer una queja','phrv','put in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducir','phrv','put in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('solicitar un puesto','phrv','put in for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('posponer','phrv','put off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','put off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('disuadir','phrv','put off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('alejar','phrv','put off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vestir','phrv','put on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse ropa','phrv','put on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encender','phrv','put on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','put out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desconectar','phrv','put out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('publicar','phrv','put out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sacar fuera','phrv','put out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar enfadado','phrv','be put out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conectar','phrv','put through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner una llamada de teléfono','phrv','put through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('instalar','phrv','put through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir los precios','phrv','put up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantar un edificio','phrv','put up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('hospedar','phrv','put up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener paciencia','phrv','put up with','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aguantar','phrv','put up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner final a una llamada telefónica','phrv','ring off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('colgar','phrv','ring off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llamar por teléfono','phrv','ring up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('perseguir','phrv','run after','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('correr a lo largo de','phrv','run along','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escaparse','phrv','run away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('correr detrás de','phrv','run after','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atropellar','phrv','run down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desacreditar','phrv','run down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parar','phrv','run down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('detener','phrv','run in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar corriendo','phrv','run in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('chocar','phrv','run into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar','phrv','run into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrarse con algo inesperadamente','phrv','run into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar a alguien','phrv','run into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encontrar a alguien','phrv','run across','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vaciar','phrv','run off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dejar salir','phrv','run off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('irse corriendo','phrv','run off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acabarse las existencias','phrv','run out of','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atropellar','phrv','run over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rebasar el límite','phrv','run over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('traspasar','phrv','run through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gastar','phrv','run through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('subir','phrv','run up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar contra','phrv','run up against','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar precipitadamente','phrv','rush into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargarse de','phrv','see about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','see about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('visitar','phrv','see over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('acompañar a la puerta','phrv','see out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevar a cabo','phrv','see through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encargarse de','phrv','see to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reparar','phrv','see to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empezar','phrv','set in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse en camino','phrv','set off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resaltar','phrv','set off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despedir','phrv','set off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un viaje','phrv','set out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('arreglar','phrv','set out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('establecer un récord','phrv','set up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un nuevo negocio','phrv','set up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar','phrv','show up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descansar','phrv','sit back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse cómodamente','phrv','sit back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse','phrv','sit down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aguantar','phrv','sit out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sentarse al aire libre','phrv','sit out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('incorporarse','phrv','sit up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ponerse derecho','phrv','sit up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('darse cuenta','phrv','sit up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deslizarse','phrv','slip in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('introducirse sin ruido','phrv','slip in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deslizarse','phrv','slip out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','slip out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escapar','phrv','slip out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('destrozar','phrv','smash up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desbordarse','phrv','spill over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('derramarse','phrv','spill over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar presente','phrv','stand by','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('atenerse a','phrv','stand by','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('representar','phrv','stand for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ofrecerse para','phrv','stand for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir','phrv','stand out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sobresalir','phrv','stand out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('mantenerse firme','phrv','stand out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('defender oralmente','phrv','stand up for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resistir','phrv','stand up to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','step into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('intervenir','phrv','step into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sobresalir','phrv','stick up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar con los pelos de punta','phrv','stick up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('girarse bruscamente','phrv','swing around','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retractarse','phrv','take aback','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desdecirse','phrv','take aback','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('devolver','phrv','take aback','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('parecerse a','phrv','take after','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llevarse','phrv','take away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('restar','phrv','take away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('regresar','phrv','take back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('retirar','phrv','take back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('escribir un dictado','phrv','take down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','take down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('descolgar','phrv','take down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comprender','phrv','take in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('recoger','phrv','take in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('engañar','phrv','take in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('embaucar','phrv','take in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitar','phrv','take off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desvestirse','phrv','take off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('imitar','phrv','take off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despegar','phrv','take off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('empezar a tener éxito','phrv','take off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aceptar','phrv','take on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('contratar','phrv','take on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quejarse','phrv','take on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('sacar','phrv','take out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extraer','phrv','take out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entretener','phrv','take out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('asumir una responsabilidad','phrv','take over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar el control','phrv','take over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tomar posesión','phrv','take over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gustar','phrv','take to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un hábito','phrv','take to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un estudio','phrv','take up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('comenzar un deporte','phrv','take up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocupar','phrv','take up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('replicar','phrv','talk back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('discutir sobre','phrv','talk over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convencer','phrv','talk into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('no parar de hablar','phrv','talk on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener tendencia a','phrv','tend to','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('pensar acerca de','phrv','think about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('meditar','phrv','think about','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('considerar','phrv','think of','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener en cuenta','phrv','think of','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('planear cuidadosamente','phrv','think out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('reflexionar','phrv','think over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('imaginar','phrv','think up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('deshacerse de','phrv','throw off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar repentinamente','phrv','throw up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('vomitar','phrv','throw up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tropezar','phrv','trip over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('caer','phrv','trip over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('probarse la ropa','phrv','try on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ensayar','phrv','try out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('poner a prueba','phrv','try out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('impedir la entrada','phrv','turn away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despedir','phrv','turn away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar la vuelta','phrv','turn back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('doblar','phrv','turn back','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar un trabajo','phrv','turn down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('rechazar una oferta','phrv','turn down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('bajar','phrv','turn down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ir a la cama','phrv','turn in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar a ser','phrv','turn into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('convertirse','phrv','turn into','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','turn off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desconectar','phrv','turn off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abandonar una dirección','phrv','turn off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('encender','phrv','turn on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('conectar','phrv','turn on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('apagar','phrv','turn out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('extinguir','phrv','turn out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('producir','phrv','turn out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('expulsar','phrv','turn out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('levantarse','phrv','turn out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar la posición','phrv','turn over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ceder','phrv','turn over','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrir','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('abrir','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('llegar','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('aparecer','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('suceder','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('ocurrir','phrv','turn up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('causar confusión','phrv','turn upside down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('cambiar de posición','phrv','turn upside down','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('esperar a','phrv','wait for','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('servir a alguien','phrv','wait on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('despertarse','phrv','wake up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('entrar','phrv','walk in','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('seguir andando','phrv','walk on','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('guiar','phrv','walk through','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('tener cuidado','phrv','watch out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('estar alerta','phrv','watch out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('gastar','phrv','wear away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('consumir','phrv','wear away','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('quitarse','phrv','wear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desaparecer','phrv','wear off','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('usar','phrv','wear out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('envolver','phrv','wind up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('enrollar','phrv','wind up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('dar vueltas','phrv','wind up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('salir bien','phrv','work out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('resolver','phrv','work out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('agotar','phrv','work out','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('desarrollar','phrv','work up','phrv')");
            db.execSQL("INSERT INTO WORDTRANSLATIONS VALUES('fomentar','phrv','work up','phrv')");
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
