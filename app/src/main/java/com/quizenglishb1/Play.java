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

import com.quizenglishb1.com.quizenglishb1.utilities.Answer;
import com.quizenglishb1.com.quizenglishb1.utilities.Randoms;

import org.w3c.dom.Text;

import java.io.Serializable;
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
    private TextView count;

    private int wordCount = 0;
    private List<List<String>> questions = new ArrayList<>();

    private List<Answer> answers= new ArrayList<>();
    private int right = 0;
    private int wrong = 0;
    private int total = 10;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        wordEnglish = (TextView) findViewById(R.id.englishWord);
        wordSpanish = (EditText) findViewById(R.id.introduceSpanish);
        sendWord = (Button) findViewById(R.id.sendWord);

        isCorrect = (TextView) findViewById(R.id.isCorrect);

        count = (TextView) findViewById(R.id.counter);

        listWords = (TextView) findViewById(R.id.allWords);
        listWords.setMovementMethod(new ScrollingMovementMethod());

        total = getIntent().getIntExtra("nQuestions",10);

        loadQuestions();

        wordEnglish.setText(questions.get(wordCount).get(wordCount));

        count.setText("Question 1 of "+total);

        sendWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> englishWords = new ArrayList<String>();
                for(int i=1; i<questions.get(wordCount).size();i++)
                    englishWords.add(questions.get(wordCount).get(i));

                answers.add(new Answer(questions.get(wordCount).get(0),wordSpanish.getText().toString(),englishWords));

                if(questions.get(wordCount).contains(wordSpanish.getText().toString())){
                    isCorrect.setText("OK!");
                    right++;
                }else{
                    isCorrect.setText("Wrong\nThe correct answer for "+questions.get(wordCount).get(0));
                    if(questions.get(wordCount).size()>2)
                        isCorrect.append(" are");
                    else
                        isCorrect.append(" is");

                    for(int i = 1;i<questions.get(wordCount).size();i++)
                        if(i==questions.get(wordCount).size()-1)
                            isCorrect.append(" "+questions.get(wordCount).get(i)+".");
                          else
                            isCorrect.append(" "+questions.get(wordCount).get(i)+",");
                    wrong++;
                }

                //Pasa a la siguiente pregunta
                if(wordCount!=total-1){
                    wordCount++;
                    wordEnglish.setText(questions.get(wordCount).get(0));
                    wordSpanish.setText("");
                    count.setText("Question "+(wordCount+1)+" of "+total);
                } else {
                    Intent i = new Intent(context,Result.class);
                    //b.putExtra("answers",answers);
                    i.putExtra("answers", (Serializable) answers);
                    i.putExtra("right",right);
                    i.putExtra("wrong",wrong);
                    i.putExtra("total",total);
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

        for(int i = 0;i<total;i++){
            int random = Randoms.randomInt(allClasified.size()-1);
            questions.add(allClasified.get(random));
        }

        db.close();
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
