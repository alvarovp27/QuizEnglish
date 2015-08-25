package com.quizenglishb1;

import android.content.Context;
import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quizenglishb1.com.quizenglishb1.utilities.User;
import com.quizenglishb1.typesForJSON.WordStat2;
import com.quizenglishb1.typesForJSON.WordTranslation;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Login extends ActionBarActivity {

    private static String login_URI = "http://quiztionary-api.appspot.com/api/users/get-token";
    private static String allWordTranslations_URI = "http://quiztionary-api.appspot.com/api/words";
    private static String allFavourites_URI = "http://quiztionary-api.appspot.com/api/words/favs";
    private static String allWordStats_URI = "http://quiztionary-api.appspot.com/api/words/stats";

    private EditText userText;
    private EditText passText;
    private Button  loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userText = (EditText) findViewById(R.id.login_username);
        passText = (EditText) findViewById(R.id.login_password);
        loginBtn = (Button) findViewById(R.id.login_button);

        final Context contexto = this;

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginAsync la = new LoginAsync();
                la.execute(userText.getText().toString(), passText.getText().toString());

                String resp = "FAILED";
                try {
                    resp = la.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                Log.d("resp_login", "-" + resp);
                if(resp.equals("FAILED") || resp.equals("Bad login")){
                    Toast.makeText(contexto,"Login failed. Please try again.", Toast.LENGTH_SHORT).show();
                } else {
                    UsersDB db = new UsersDB(contexto);
                    String token = resp.substring(22,resp.length());
                    Log.d("token", "-" + token);

                    if(db.isEmpty()){
                        db.addUser(userText.getText().toString(),passText.getText().toString(),token);
                        db.updateToken(userText.getText().toString(),token);
                        db.close();
                        launchActivity(contexto,token);
                    }else{
                        User aux = db.getUsers();
                        Log.d("user_en_DB","Username:-"+aux.getName()+", Password:-"+aux.getPassword());
                        if(aux.getName().equals(userText.getText().toString()) &&
                            aux.getPassword().equals(passText.getText().toString())){
                            db.updateToken(aux.getName(),token);
                            db.close();
                            launchActivity(contexto,token);
                        }else{
                            Toast.makeText(contexto,"Login failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    db.close();

                }

                TextView status = (TextView) findViewById(R.id.login_status);
                status.setText(resp);
            }
        });


    }

    private void launchActivity(Context contexto, String token){
        WordsDB wdb = new WordsDB(contexto);
        wdb.resetDB();
        WordTranslationsAsync wta = new WordTranslationsAsync();
        wta.execute(token);

        List<WordTranslation> wordsToAdd = new ArrayList<>();

        try {
            wordsToAdd = wta.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.d("Lista_word_transl", wordsToAdd.toString());

        for(WordTranslation wt:wordsToAdd)
            wdb.insertWordTranslation(wt);

        Log.d("exito_wordtranslation","EXITO INSERT WORDTRANSLATIONS");

        //Pido los favoritos y los meto en la BD
        FavouritesAsync fa = new FavouritesAsync();
        fa.execute(token);
        List<String> favourites = new ArrayList<>();

        try {
            favourites = fa.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("fav_Async", "Voy a introducir los favs en BD");
        for(String s:favourites)
            wdb.insertFavourite(s);
        Log.d("fav_Async", "Termine de introducir los datos en BD");

        //Pido las estadísticas y las almaceno en la BD
        WordStatsAsync wsa = new WordStatsAsync();
        wsa.execute(token);
        List<WordStat2> wordStats = new ArrayList<>();

        try{
            wordStats = wsa.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for(WordStat2 ws:wordStats)
        wdb.insertWordStat(ws);

        wdb.close();
        Intent i = new Intent(contexto, MainActivity.class);
        i.putExtra("token",token);
        startActivity(i);
    }

    private class WordStatsAsync extends AsyncTask<String,Integer,List<WordStat2>>{
        @Override
        protected List<WordStat2> doInBackground(String... params) {
            List<WordStat2> res = new ArrayList<>();

            HttpClient hc = new DefaultHttpClient();
            HttpGet get = new HttpGet(allWordStats_URI);
            get.setHeader("Authentication", params[0]);

            try {
                HttpResponse resp = hc.execute(get);

                String respStr = EntityUtils.toString(resp.getEntity());

                //Construyo JSON a partir de la resp.
                JSONArray respJSON = new JSONArray(respStr);
                //Log.d("Resp_word_transl_JSON",respJSON.toString());
                for(int i = 0;i<respJSON.length();i++){
                    JSONObject j = respJSON.getJSONObject(i);
                    res.add(new WordStat2(j.getString("word"), j.getInt("hits"), j.getInt("fails")));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return res;
        }
    }

    private class FavouritesAsync extends AsyncTask<String,Integer,List<String>>{
        @Override
        protected List<String> doInBackground(String... params) {
            HttpClient hc = new DefaultHttpClient();
            HttpGet get = new HttpGet(allFavourites_URI);
            get.setHeader("Authentication", params[0]);

            List<String> res = new ArrayList<>();

            Log.d("fav_Async", "Estoy dentro de fav.async");

            try {
                HttpResponse resp = hc.execute(get);

                String respStr = EntityUtils.toString(resp.getEntity());

                Log.d("fav_Async", "Respuesta recibida");

                //Construyo JSON a partir de la resp.
                JSONArray respJSON = new JSONArray(respStr);
                //Log.d("Resp_word_transl_JSON",respJSON.toString());
                for(int i = 0;i<respJSON.length();i++){
                    JSONObject j = respJSON.getJSONObject(i);
                    res.add(new String(j.getString("word")));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("fav_Async", "He salido de favAsync");
            return res;
        }
    }

    private class WordTranslationsAsync extends AsyncTask<String, Integer, List<WordTranslation>>{
        @Override
        protected List<WordTranslation> doInBackground(String... params) {
            HttpClient hc = new DefaultHttpClient();

            HttpGet get = new HttpGet(allWordTranslations_URI);
            get.setHeader("Authentication",params[0]);

            List<WordTranslation> res = new ArrayList<>();

            try {
                HttpResponse resp = hc.execute(get);
                String respStr = EntityUtils.toString(resp.getEntity());

                //Construyo JSON a partir de la resp.
                JSONArray respJSON = new JSONArray(respStr);
                Log.d("Resp_word_transl_JSON",respJSON.toString());
                for(int i = 0;i<respJSON.length();i++){
                    JSONObject j = respJSON.getJSONObject(i);
                    res.add(new WordTranslation(j.getString("wordSP"),j.getString("typeSP"),
                            j.getString("wordEN"),j.getString("typeEN"),j.getString("category")));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return res;
        }
    }


    private class LoginAsync extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... params) {
            JSONObject loginInfo = new JSONObject();
            try {
                loginInfo.put("name",params[0]);
                loginInfo.put("password",params[1]);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            HttpClient hc = new DefaultHttpClient();

            HttpPost post = new HttpPost(login_URI);
            post.setHeader("Content-type", "application/json");

            try {
                StringEntity entity = entity = new StringEntity(loginInfo.toString());
                post.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String respStr = "NULL";
            try {
                HttpResponse resp = hc.execute(post);

                respStr = EntityUtils.toString(resp.getEntity());

            } catch (IOException e) {
                e.printStackTrace();
            }

            return respStr;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
