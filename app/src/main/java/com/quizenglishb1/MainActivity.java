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


}
