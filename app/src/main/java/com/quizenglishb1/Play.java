package com.quizenglishb1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class Play extends ActionBarActivity {

    private Button sendWord;
    private EditText wordSpanish;
    private TextView wordEnglish;
    private TextView listWords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        wordEnglish = (TextView) findViewById(R.id.englishWord);
        wordSpanish = (EditText) findViewById(R.id.introduceSpanish);
        sendWord = (Button) findViewById(R.id.sendWord);

        listWords = (TextView) findViewById(R.id.allWords);
        listWords.setMovementMethod(new ScrollingMovementMethod());

        final WordsDB db = new WordsDB(this);

        List<String[]> allWords = db.getAll();
        for(String[] s:allWords){
            String line = s[0]+" ("+s[1]+") - "+s[2]+" ("+s[3]+")\n";
            listWords.append(line);
        }



    }

    private void loadQuestions(){
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
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
