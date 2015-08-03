package com.quizenglishb1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Play extends ActionBarActivity {

    private Button sendWord;
    private EditText wordSpanish;
    private TextView wordEnglish;
    private TextView listWords;
    private TextView isCorrect;

    private int wordCount = 0;
    private List<List<String>> questions = new ArrayList<>();

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        wordEnglish = (TextView) findViewById(R.id.englishWord);
        wordSpanish = (EditText) findViewById(R.id.introduceSpanish);
        sendWord = (Button) findViewById(R.id.sendWord);

        isCorrect = (TextView) findViewById(R.id.isCorrect);

        listWords = (TextView) findViewById(R.id.allWords);
        listWords.setMovementMethod(new ScrollingMovementMethod());


        loadQuestions();

        wordEnglish.setText(questions.get(wordCount).get(0));
        sendWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions.get(wordCount).contains(wordSpanish.getText().toString()))
                    isCorrect.setText("OK!");
                else
                    isCorrect.setText("Wrong");


                if(wordCount!=9){
                    wordCount++;
                    wordEnglish.setText(questions.get(wordCount).get(0));
                } else {
                    Intent i = new Intent(context,MainActivity.class);
                    startActivity(i);
                }


            }
        });

    }

    private void loadQuestions(){
        final WordsDB db = new WordsDB(this);

        List<String[]> allWords = db.getAll();
        for(String[] s:allWords){
            String line = s[0]+" ("+s[1]+") - "+s[2]+" ("+s[3]+")\n";
            listWords.append(line);
        }

        List<List<String>> allClasified = db.getAllClasified();

        for(int i = 0;i<10;i++){
            int random = Randoms.randomInt(allClasified.size()-1);
            questions.add(allClasified.get(random));
        }
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
