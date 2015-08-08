package com.quizenglishb1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class GameSettings extends ActionBarActivity {

    private Button start;
    private Button home;
    private EditText nQuestionsEdit;

    private int nQuestions = 10;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        start = (Button) findViewById(R.id.start_button_settings);
        home = (Button) findViewById(R.id.home_button_settings);
        nQuestionsEdit = (EditText) findViewById(R.id.number_of_questions);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Play.class);
                if(nQuestionsEdit.getText().toString().matches("") || nQuestionsEdit.getText().toString()=="0")
                    Toast.makeText(context, "You must insert a number of questions", Toast.LENGTH_SHORT).show();
                else {
                    try{
                        nQuestions = new Integer(nQuestionsEdit.getText().toString());
                    }catch(Exception e){
                        Toast.makeText(context, "You must insert a number of questions", Toast.LENGTH_SHORT).show();
                    }

                    if(nQuestions > 50)
                        Toast.makeText(context, "The number of questions must be less than 50", Toast.LENGTH_SHORT).show();
                    else{
                        i.putExtra("nQuestions",nQuestions);
                        startActivity(i);
                    }
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_settings, menu);
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
