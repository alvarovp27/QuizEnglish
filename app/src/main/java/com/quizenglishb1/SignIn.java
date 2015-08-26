package com.quizenglishb1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;


public class SignIn extends ActionBarActivity {

    private static String SIGNIN_URI = "http://quiztionary-api.appspot.com/api/users/new-user";

    private EditText user;
    private EditText pass1;
    private EditText pass2;
    Button signin;
    Button login;

    private Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user = (EditText) findViewById(R.id.signin_username);
        pass1 = (EditText) findViewById(R.id.signin_password1);
        pass2 = (EditText) findViewById(R.id.signin_password2);
        signin = (Button) findViewById(R.id.signin_button);
        login = (Button) findViewById(R.id.btn_to_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Login.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAlight = true;
                if(user.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"You must insert an username.",Toast.LENGTH_SHORT).show();
                    isAlight = false;
                }
                if(user.getText().toString().contains(" ")){
                    Toast.makeText(getApplicationContext(),"Your user name ought not to contain any whitespaces.",Toast.LENGTH_SHORT).show();
                isAlight = false;
                }
                if(pass1.getText().toString().equals("") || pass2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"You must to write your password in both password fields.",Toast.LENGTH_SHORT).show();
                    isAlight = false;
                }
                if(!pass1.getText().toString().equals(pass2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"The password fields doesn't match",Toast.LENGTH_SHORT).show();
                    isAlight = false;
                }

                if(isAlight){
                    SignInAsync sia = new SignInAsync();
                    sia.execute(user.getText().toString(), pass1.getText().toString());

                    String resp = "FAIL";

                    try {
                        resp = sia.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    if(resp.equals("FAIL") || resp.equals("NULL"))
                        Toast.makeText(context,"Failed signing in. Please try again later.", Toast.LENGTH_SHORT);
                    else if(resp.equals("User already exits"))
                        Toast.makeText(context,"The user name which you have introduced is already registered.", Toast.LENGTH_SHORT);
                    else{
                        Intent i = new Intent(context, Login.class);
                        i.putExtra("registered","Sign in successful! Now log in.");
                        startActivity(i);
                    }
                }
            }
        });
    }

    private class SignInAsync extends AsyncTask<String, Integer, String>{
        @Override
        protected String doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            HttpClient hc = new DefaultHttpClient();
            HttpPost post = new HttpPost(SIGNIN_URI);
            post.setHeader("Content-type", "application/json");

            JSONObject obj = new JSONObject();

            String res = "NULL";
            try {
                obj.put("name",username);
                obj.put("password", password);
                StringEntity entity = new StringEntity(obj.toString());
                post.setEntity(entity);

                HttpResponse resp = hc.execute(post);
                res = EntityUtils.toString(resp.getEntity());

                if(resp.getStatusLine().getStatusCode()==200)
                    res = res.substring(22,res.length());

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
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
