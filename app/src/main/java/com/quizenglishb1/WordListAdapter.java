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

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Alvaro on 10/08/2015.
 */
public class WordListAdapter extends BaseAdapter{

    private Context context;
    private List<Word> words;
    private List<Word> favList;
    private ListTypes listTypes;

    public WordListAdapter(Context context, List<Word> words, List<Word> favList, ListTypes listTypes){
        this.context=context;
        this.words=words;
        this.favList=favList;
        this.listTypes=listTypes;
    }


    @Override
    public int getCount() {
        if(listTypes==ListTypes.ALL)
            return words.size();
        else if(listTypes==ListTypes.FAVOURITES)
            return favList.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        if(listTypes==ListTypes.ALL)
            return words.get(position);
        else if(listTypes==ListTypes.FAVOURITES)
            return favList.get(position);
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
                            db.removeFavouriteEn(word.getMainWord());
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(word.getMainWord());
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
                    if(i!=words.get(position).getTranslations().size()-1)
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
                            db.removeFavouriteEn(favouriteWord.getMainWord());
                            favList = db.getAllFavouritesEn();
                            db.close();
                            favButton.setImageResource(R.drawable.ic_non_fav);
                            notifyDataSetChanged(); //Refresca la ListView tras cambiar algún elemento
                        } else {
                            WordsDB db = new WordsDB(context);
                            db.addFavouriteEn(favouriteWord.getMainWord());
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
