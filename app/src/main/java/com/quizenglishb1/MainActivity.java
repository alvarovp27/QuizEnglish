package com.quizenglishb1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    private static String USER_TOKEN = "";
    private static String checkToken_URI = "http://quiztionary-api.appspot.com/api/users/is-token-available/";

    private TextView welcome;
    private Button play;
    private Button list;
    private Button tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("estoy_en_main_activity","Hola!");

        final WordsDB db = new WordsDB(this);
        db.close();

        final Context contexto = this;

        /** Obtengo el token que he recibido como extra*/

        USER_TOKEN = getIntent().getStringExtra("token");


        /** Compruebo si hay usuarios registrados en el local, y si es así,
         * compruebo si el token ha expirado*/
        final UsersDB usersDB = new UsersDB(this);
        if(usersDB.isEmpty()){
            Intent intent = new Intent(contexto, Login.class);
            startActivity(intent);
        } else {
            USER_TOKEN = usersDB.getUsers().getToken();

            CheckToken ct = new CheckToken();
            ct.execute(USER_TOKEN);

            String resp = "NO-RESP";

            try {
                resp = ct.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if(resp.equals("EXPIRED")){
                Intent needLogin = new Intent(contexto,Login.class);
                startActivity(needLogin);
            }
        }


        welcome = (TextView) findViewById(R.id.welcome);
        list = (Button) findViewById(R.id.list);
        tools = (Button) findViewById(R.id.tools);

        /*final WordsDB myDB = new WordsDB(this);

        Map<String,String> map = myDB.translateFromEnglish("get");

        welcome.setText(map.toString());*/
        play = (Button) findViewById(R.id.playButton);


        setTitle("English Quizz");
        //getActionBar().setBackgroundDrawable(new ColorDrawable());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(contexto, GameSettings.class);
                startActivity(i);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto, WordList.class);
                startActivity(i);
            }
        });
    }


    private class CheckToken extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            String toSend = checkToken_URI+params[0];

            HttpClient hc = new DefaultHttpClient();

            HttpGet get = new HttpGet(toSend);

            String respStr="CONECTION-FAILED";

            try {
                HttpResponse resp = hc.execute(get);

                //Así obtengo el código de estado:
                if(resp.getStatusLine().getStatusCode()==304)
                    respStr="UP-TO-DATE";
                else
                    respStr="EXPIRED";

            } catch (IOException e) {
                e.printStackTrace();
            }

            return respStr;
        }
    }


}
