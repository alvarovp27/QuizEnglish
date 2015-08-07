package com.quizenglishb1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Answer;

import java.util.List;


public class Result extends ActionBarActivity {

    private TextView results;
    private TextView mark;
    private ListView summary;
    private Button home;

    private List<Answer> answers;
    private Integer right;
    private Integer wrong;
    private Integer total;



    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = (Button) findViewById(R.id.home_button);
        results = (TextView) findViewById(R.id.results_text);
        mark = (TextView) findViewById(R.id.mark_text);
        summary = (ListView) findViewById(R.id.summary_list);

        answers = (List<Answer>) getIntent().getSerializableExtra("answers");
        right = getIntent().getIntExtra("right",0);
        wrong = getIntent().getIntExtra("wrong",0);
        total = getIntent().getIntExtra("total",100);

        results.setText("You have " + right + " questions right of " + total);
        double markDouble = (new Double(right)*10.0)/(new Double(total));
        mark.append(""+markDouble);

        /*Se le pasa un adaptador al ListView*/
        this.summary.setAdapter(new AnswerAdapter(context, answers));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
