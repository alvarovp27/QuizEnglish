package com.quizenglishb1.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.quizenglishb1.WordsDB;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Alvaro on 25/08/2015.
 */
public class FavouritesOperationsAsync extends AsyncTask<String,Integer,Void>{
    private Context context;
    public FavouritesOperationsAsync(Context context){
        this.context=context;
    }

    private static String URI = "http://quiztionary-api.appspot.com/api/words/favs";

    @Override
    protected Void doInBackground(String... params) {
        //En params[0] estará la palabra, en params[1] la operación a realizar, y en params[2] el token
        String exito = "FAIL"; //banderín para determinar si las operaciones tuvieron éxito
        String word = params[0];
        String operation = params[1];
        String token = params[2];

        HttpClient hc = new DefaultHttpClient();

        if(operation.equals("add")){
            HttpPost post = new HttpPost(URI);
            post.setHeader("Authentication", token);
            post.setHeader("Content-type", "application/json");

            JSONObject obj = new JSONObject();
            try {
                obj.put("word",word);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                StringEntity entity = new StringEntity(obj.toString());
                post.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                HttpResponse resp = hc.execute(post);
                if(resp.getStatusLine().getStatusCode()==201)
                    exito="SUCCESSFUL";
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String wordURI ="";
            for(int i = 0; i<word.length();i++)
                if(word.charAt(i)==' ')
                    wordURI+="%20";
                else
                    wordURI+=word.charAt(i);

            HttpDelete delete = new HttpDelete(URI+"/"+wordURI);
            delete.setHeader("Authentication", token);
            delete.setHeader("Content-type", "application/json");

            try {
                HttpResponse resp = hc.execute(delete);
                if(resp.getStatusLine().getStatusCode()==204)
                    exito="SUCCESSFUL";
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Log.d("exito-fav",exito);
        WordsDB db = new WordsDB(context);
        if(exito.equals("FAIL"))
            db.setFavouriteDirty(word,true);
        else
            db.setFavouriteDirty(word,false);
        db.close();
        return null;
    }
}
