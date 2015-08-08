package com.quizenglishb1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private TextView welcome;
    private Button play;
    private Button list;
    private Button tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WordsDB db = new WordsDB(this);
        db.close();

        welcome = (TextView) findViewById(R.id.welcome);
        list = (Button) findViewById(R.id.list);
        tools = (Button) findViewById(R.id.tools);

        /*final WordsDB myDB = new WordsDB(this);

        Map<String,String> map = myDB.translateFromEnglish("get");

        welcome.setText(map.toString());*/
        play = (Button) findViewById(R.id.playButton);
        final Context contexto = this;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
