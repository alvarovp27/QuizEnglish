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
import com.quizenglishb1.com.quizenglishb1.utilities.Word;
import com.quizenglishb1.com.quizenglishb1.utilities.WordStat;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Play extends ActionBarActivity {

    private static String USER_TOKEN = "";

    private Button sendWord;
    private EditText wordSpanish;
    private TextView wordEnglish;
    private TextView listWords;
    private TextView isCorrect;
    private TextView count;

    private List<String> categories = new ArrayList<>();
    private String difficulty;

    private int wordCount = 0;
    private List<Word> questions = new ArrayList<>();

    private List<Answer> answers= new ArrayList<>();
    private int right = 0;
    private int wrong = 0;
    private int total = 10;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        USER_TOKEN=getIntent().getStringExtra("token");

        wordEnglish = (TextView) findViewById(R.id.englishWord);
        wordSpanish = (EditText) findViewById(R.id.introduceSpanish);
        sendWord = (Button) findViewById(R.id.sendWord);

        isCorrect = (TextView) findViewById(R.id.isCorrect);

        count = (TextView) findViewById(R.id.counter);

        listWords = (TextView) findViewById(R.id.allWords);
        listWords.setMovementMethod(new ScrollingMovementMethod());

        total = getIntent().getIntExtra("nQuestions",10);
        if(getIntent().getSerializableExtra("categories")!=null)
            categories = (List<String>) getIntent().getSerializableExtra("categories");

        difficulty = getIntent().getStringExtra("difficulty");

        //Carga las preguntas
        loadQuestions();

       // wordEnglish.setText(questions.get(wordCount).get(wordCount));
        wordEnglish.setText(questions.get(wordCount).getMainWord());

        count.setText("Question 1 of "+total);


        sendWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> translations = new ArrayList<String>();
                for(int i=0; i<questions.get(wordCount).getTranslations().size();i++)
                    translations.add(questions.get(wordCount).getTranslations().get(i).getMainWord());

                answers.add(new Answer(questions.get(wordCount).getMainWord(),wordSpanish.getText().toString(),translations));

                List<String> rightAnswers = new ArrayList<String>();
                for(Word w: questions.get(wordCount).getTranslations())
                    rightAnswers.add(w.getMainWord());

                if(rightAnswers.contains(wordSpanish.getText().toString())){
                    isCorrect.setText("OK!");

                    WordsDB db = new WordsDB(context);
                    db.addHit(wordEnglish.getText().toString(),USER_TOKEN,context);
                    db.close();

                    right++;
                }else{
                    isCorrect.setText("Wrong\nThe correct answer for "+questions.get(wordCount).getMainWord());

                    WordsDB db = new WordsDB(context);
                    db.addFail(wordEnglish.getText().toString(), USER_TOKEN, context);
                    db.close();

                    if(questions.get(wordCount).getTranslations().size()>2)
                        isCorrect.append(" are");
                    else
                        isCorrect.append(" is");

                    for(int i = 0;i<questions.get(wordCount).getTranslations().size();i++)
                        if(i==questions.get(wordCount).getTranslations().size()-1)
                            isCorrect.append(" "+questions.get(wordCount).getTranslations().get(i).getMainWord()+".");
                          else
                            isCorrect.append(" "+questions.get(wordCount).getTranslations().get(i).getMainWord()+",");
                    wrong++;
                }

                //Pasa a la siguiente pregunta
                if(wordCount!=total-1){
                    wordCount++;
                    wordEnglish.setText(questions.get(wordCount).getMainWord());
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
        /*final WordsDB db = new WordsDB(this);
        List<List<String>> allClasified = db.getAllClasified();
        db.close();

        for(int i = 0;i<total;i++){
            int random = Randoms.randomInt(allClasified.size()-1);
            questions.add(allClasified.get(random));
        }*/

        final WordsDB db = new WordsDB(this);
        //List<List<String>> allClasified = db.getAllClasified();
        List<Word> allWords = new ArrayList<>();
        if(difficulty.equals("hard")){
            List<WordStat> allWordStats = db.getWorstWords();
            for(WordStat ws:allWordStats)
                allWords.add(ws);
        }else{
            //TODO Eliminar la selección por categorías en la sentencia SQL
            allWords = db.getAllEnglishWords(/*categories*/new ArrayList<String>());
        }
        db.close();
        List<Word> allWordsByCategory = new ArrayList<>();
        if(!categories.isEmpty()) {
            for (Word w : allWords)
                if (categories.contains(w.getCategory()))
                    allWordsByCategory.add(w);
        }else
            allWordsByCategory.addAll(allWords);

        if(total>allWordsByCategory.size())
            total=allWordsByCategory.size();

        for(int i = 0;i<total;i++){
            int random = Randoms.randomInt(allWordsByCategory.size()-1);
            while(questions.contains(allWordsByCategory.get(random))){
                random = Randoms.randomInt(allWordsByCategory.size()-1);
            }
            questions.add(allWordsByCategory.get(random));
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
