package com.quizenglishb1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Word;

import org.w3c.dom.Text;

import java.util.List;


public class WordList extends ActionBarActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        /*Tabla*/
        Resources res = getResources();

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");

        //Creo la tabla 1 y la añado al contenedor
        spec.setContent(R.id.tab1);
        spec.setIndicator("All");
        tabs.addTab(spec);

        //Contenido de la tabla 1
        final WordsDB db = new WordsDB(this);
        List<Word> allWords = db.getAllEnglishWords();
        db.close();

        ListView listViewAllWords = (ListView) findViewById(R.id.list_view_all_words);
        listViewAllWords.setAdapter(new WordListAdapter(context, allWords));



        /*TextView textViewTab1 = (TextView) findViewById(R.id.text_view_tab1);
        textViewTab1.setMovementMethod(new ScrollingMovementMethod());

        final WordsDB db = new WordsDB(this);
        List<String[]> allWords = db.getAll();
        db.close();

        for(String[] s:allWords){
            String line = s[0]+" ("+s[1]+") - "+s[2]+" ("+s[3]+")\n";
            textViewTab1.append(line);
        }*/



        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Favourites");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Learned");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Worst");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_list, menu);
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
