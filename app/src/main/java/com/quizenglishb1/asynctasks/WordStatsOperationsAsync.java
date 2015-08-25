package com.quizenglishb1.asynctasks;

import android.content.Entity;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Alvaro on 25/08/2015.
 */
public class WordStatsOperationsAsync extends AsyncTask<String, Integer, Void>{
    private static String URI = "http://quiztionary-api.appspot.com/api/words/stats";
    @Override
    protected Void doInBackground(String... params) {
        String exito = "FAIL"; //banderín para determinar si las operaciones tuvieron éxito

        String word = params[0];
        Integer hits = new Integer(params[1]);
        Integer fails = new Integer(params[2]);
        //String operation = params[3];
        String token = params[3];

        Log.d("datos_wordstatsasync",word+","+hits+","+fails+","+token);

        HttpClient hc = new DefaultHttpClient();

        String wordURI ="";
        for(int i = 0; i<word.length();i++)
            if(word.charAt(i)==' ')
                wordURI+="%20";
            else
                wordURI+=word.charAt(i);

        HttpPut put = new HttpPut(URI+"/"+wordURI);
        put.setHeader("Content-type", "application/json");
        put.setHeader("Authentication", token);

        JSONObject obj = new JSONObject();
        try {
            obj.put("word",word);
            obj.put("hits",hits);
            obj.put("fails",fails);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            StringEntity entity = new StringEntity(obj.toString());
            put.setEntity(entity);
            HttpResponse resp = hc.execute(put);
            Log.d("put_response_code",""+resp.getStatusLine().getStatusCode());
            if(resp.getStatusLine().getStatusCode()==204)
                exito="SUCCESSFUL";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
