package com.quizenglishb1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.quizenglishb1.com.quizenglishb1.utilities.ListTypes;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;
import com.quizenglishb1.com.quizenglishb1.utilities.WordStat;

import org.w3c.dom.Text;

import java.util.List;


public class WordList extends ActionBarActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        //Recojo de la BD Todo lo que necesito
        final WordsDB db = new WordsDB(this);
        List<Word> allWords = db.getAllEnglishWords();
        List<Word> favWords = db.getAllFavouritesEn();
        List<WordStat> bestWords = db.getBestWords();
        List<WordStat> worstWords = db.getWorstWords();
        db.close();


        /*Tabla*/
        Resources res = getResources();

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec1 = tabs.newTabSpec("mitab1");

        //Creo la tabla 1 y la añado al contenedor
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("All");
        tabs.addTab(spec1);

        ListView listViewAllWords = (ListView) findViewById(R.id.list_view_all_words);
        listViewAllWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.ALL));

        //Tabla 2
        TabHost.TabSpec spec2 = tabs.newTabSpec("mitab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("", getResources().getDrawable(R.drawable.ic_fav_icon));
        tabs.addTab(spec2);

        ListView listViewFavWords = (ListView) findViewById(R.id.list_view_fav_words);
        listViewFavWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.FAVOURITES));

        //Tabla 3
        TabHost.TabSpec spec3 = tabs.newTabSpec("mitab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Best");
        tabs.addTab(spec3);

        ListView listViewBestWords = (ListView) findViewById(R.id.list_view_best_words);
        listViewBestWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.BEST));

        //Tabla 4
        TabHost.TabSpec spec4 = tabs.newTabSpec("mitab2");
        spec4.setContent(R.id.tab4);
        spec4.setIndicator("Worst");
        tabs.addTab(spec4);

        ListView listViewWorstWords = (ListView) findViewById(R.id.list_view_worst_words);
        listViewWorstWords.setAdapter(new WordListAdapter(context,allWords, favWords,bestWords,worstWords,ListTypes.WORST));

        tabs.setCurrentTab(0);

        //Este método se invoca cuando cambiamos de pestaña de la tabla
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //Toast.makeText(getApplicationContext(), "Click on tab: " + tabId, Toast.LENGTH_SHORT).show();
                final WordsDB db = new WordsDB(context);
                List<Word> allWords = db.getAllEnglishWords();
                List<Word> favWords = db.getAllFavouritesEn();
                List<WordStat> bestWords = db.getBestWords();
                List<WordStat> worstWords = db.getWorstWords();
                db.close();
                if (tabId == "mitab1") {
                    ListView listViewAllWords = (ListView) findViewById(R.id.list_view_all_words);
                    listViewAllWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.ALL));
                } else if(tabId=="mitab2"){
                    ListView listViewFavWords = (ListView) findViewById(R.id.list_view_fav_words);
                    listViewFavWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.FAVOURITES));
                } else if(tabId=="mitab3"){
                    ListView listViewFavWords = (ListView) findViewById(R.id.list_view_best_words);
                    listViewFavWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.BEST));
                } else if(tabId=="mitab4"){
                    ListView listViewFavWords = (ListView) findViewById(R.id.list_view_worst_words);
                    listViewFavWords.setAdapter(new WordListAdapter(context, allWords, favWords,bestWords,worstWords, ListTypes.WORST));
                }
            }
        });
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
