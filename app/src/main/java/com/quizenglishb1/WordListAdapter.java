package com.quizenglishb1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Answer;
import com.quizenglishb1.com.quizenglishb1.utilities.ListTypes;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;
import com.quizenglishb1.com.quizenglishb1.utilities.WordStat;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Alvaro on 10/08/2015.
 */
public class WordListAdapter extends BaseAdapter{

    private Context context;
    private List<Word> words;
    private List<Word> favList;
    private List<WordStat> bestWords;
    private List<WordStat> worstWords;
    private ListTypes listTypes;

    private String token;

    public WordListAdapter(Context context, List<Word> words, List<Word> favList, List<WordStat> bestWords, List<WordStat> worstWords, ListTypes listTypes, String token){
        this.context=context;
        this.words=words;
        this.favList=favList;
        this.bestWords=bestWords;
        this.worstWords=worstWords;
        this.listTypes=listTypes;
        this.token = token;
    }


    @Override
    public int getCount() {
        if(listTypes==ListTypes.ALL)
            return words.size();
        else if(listTypes==ListTypes.FAVOURITES)
            return favList.size();
        else if(listTypes==ListTypes.BEST)
            return bestWords.size();
        else if(listTypes==ListTypes.WORST)
            return worstWords.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        if(listTypes==ListTypes.ALL)
            return words.get(position);
        else if(listTypes==ListTypes.FAVOURITES)
            return favList.get(position);
        else if(listTypes==ListTypes.BEST)
            return bestWords.get(position);
        else if(listTypes==ListTypes.WORST)
            return worstWords.get(position);
        else
            return 0;
    }

    @Override
    public long getItemId(int position) { return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.word_list_adapter, parent, false);
        }

        TextView mainWord = (TextView) rowView.findViewById(R.id.main_word);
        TextView typeMainWord = (TextView) rowView.findViewById(R.id.type_main_word);
        TextView translations = (TextView) rowView.findViewById(R.id.word_translations);
        final ImageButton favButton = (ImageButton) rowView.findViewById(R.id.favourites_img_button);

        String translationsStr = "";

        switch(listTypes){
            case ALL:
                final Word word = this.words.get(position);
                mainWord.setText(word.getMainWord());
                typeMainWord.setText("(" + word.getType() + ")");

                System.out.println("****" + word.getTranslations().toString());

                translations.setText("");
                for(int i = 0; i<words.get(position).getTranslations().size();i++){
                    Word aux = words.get(position).getTranslations().get(i);
                    translationsStr+=aux.getMainWord()+" ("+aux.getType()+")";
                    if(i!=words.get(position).getTranslations().size()-1)
                        translationsStr+=("\n");
                }
                translations.setText(translationsStr);

                if(favList.contains(word)){
                    favButton.setImageResource(R.drawable.ic_fav);
                    Log.d("PR", word.getMainWord()+" --- "+favList.toString());
                } else {
                    favButton.setImageResource(R.drawable.ic_non_fav);
                }

                //Comportamiento del botón de fav
                favButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (favList.contains(word)) {
                            WordsDB db = new WordsDB(context);
                            db.removeFavouriteEn(word.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(word.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_fav);
                            notifyDataSetChanged();
                        }
                    }
                });
                break;

            case FAVOURITES:
                final Word favouriteWord = favList.get(position);

                mainWord.setText(favouriteWord.getMainWord());
                typeMainWord.setText(favouriteWord.getType());

                translations.setText("");
                for(int i = 0; i<favouriteWord.getTranslations().size();i++){
                    Word aux = favouriteWord.getTranslations().get(i);
                    translationsStr+=aux.getMainWord()+" ("+aux.getType()+")";
                    if(i!=favouriteWord.getTranslations().size()-1)
                        translationsStr+=("\n");
                }
                translations.setText(translationsStr);

                if(favList.contains(favouriteWord)){
                    favButton.setImageResource(R.drawable.ic_fav);
                } else {
                    favButton.setImageResource(R.drawable.ic_non_fav);
                }

                //Comportamiento del botón de fav
                favButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (favList.contains(favouriteWord)) {
                            WordsDB db = new WordsDB(context);
                            db.removeFavouriteEn(favouriteWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(favouriteWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_fav);
                            notifyDataSetChanged();
                        }
                    }
                });
                break;

            case BEST:
                final WordStat bestWord = bestWords.get(position);
                mainWord.setText(bestWord.getMainWord());
                typeMainWord.setText(bestWord.getType());

                TextView stats = (TextView) rowView.findViewById(R.id.hits_and_fails);
                stats.setText("Hits: "+bestWord.getHits()+" - Fails: "+bestWord.getFails());

                translations.setText("");
                for(int i = 0; i<bestWord.getTranslations().size();i++){
                    Word aux = bestWord.getTranslations().get(i);
                    translationsStr+=aux.getMainWord()+" ("+aux.getType()+")";
                    if(i!=bestWord.getTranslations().size()-1)
                        translationsStr+=("\n");
                }
                translations.setText(translationsStr);

                final Word wAux2 = Word.create(bestWord.getMainWord(),bestWord.getType());
                if(favList.contains(wAux2)){
                    favButton.setImageResource(R.drawable.ic_fav);
                } else {
                    favButton.setImageResource(R.drawable.ic_non_fav);
                }

                //Comportamiento del botón de fav
                favButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (favList.contains(wAux2)) {
                            WordsDB db = new WordsDB(context);
                            db.removeFavouriteEn(bestWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(bestWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_fav);
                            notifyDataSetChanged();
                        }
                    }
                });
                break;

            case WORST:
                final WordStat worstWord = worstWords.get(position);
                mainWord.setText(worstWord.getMainWord());
                typeMainWord.setText(worstWord.getType());

                TextView statsWorst = (TextView) rowView.findViewById(R.id.hits_and_fails);
                statsWorst.setText("Hits: "+worstWord.getHits()+" - Fails: "+worstWord.getFails());

                translations.setText("");
                for(int i = 0; i<worstWord.getTranslations().size();i++){
                    Word aux = worstWord.getTranslations().get(i);
                    translationsStr+=aux.getMainWord()+" ("+aux.getType()+")";
                    if(i!=worstWord.getTranslations().size()-1)
                        translationsStr+=("\n");
                }
                translations.setText(translationsStr);

                //No debería ser necesario hacer esto, pero si no no pilla que WordStat hereda de
                //Word. Algo raro ocurre ahí.
                final Word wAux = Word.create(worstWord.getMainWord(),worstWord.getType());
                if(favList.contains(wAux)){
                    favButton.setImageResource(R.drawable.ic_fav);
                } else {
                    favButton.setImageResource(R.drawable.ic_non_fav);
                }

                Log.d("Contains?","** Contiene la lista de favoritos la palabr actual? "+favList.contains(wAux));
                Log.d("ListFav content","** Contenido de la lista de favoritos: "+favList.toString());

                //Comportamiento del botón de fav
                favButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (favList.contains(wAux)) {
                            WordsDB db = new WordsDB(context);
                            db.removeFavouriteEn(worstWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(worstWord.getMainWord(), token, context);
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_fav);
                            notifyDataSetChanged();
                        }
                    }
                });
                break;

        }
        return rowView;
    }
}
