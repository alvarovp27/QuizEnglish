package com.quizenglishb1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Answer;
import com.quizenglishb1.com.quizenglishb1.utilities.Word;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Alvaro on 10/08/2015.
 */
public class WordListAdapter extends BaseAdapter{

    private Context context;
    private List<Word> words;

    public WordListAdapter(Context context, List<Word> words){
        this.context=context;
        this.words=words;
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int position) {
        return words.get(position);
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

        Word word = this.words.get(position);
        mainWord.setText(word.getMainWord());
        typeMainWord.setText("(" + word.getType() + ")");

        System.out.println("****" + word.getTranslations().toString());

        translations.setText("");
        String translationsStr = "";

        for(int i = 0; i<words.get(position).getTranslations().size();i++){
            Word aux = words.get(position).getTranslations().get(i);
            translationsStr+=aux.getMainWord()+" ("+aux.getType()+")";
            if(i!=words.get(position).getTranslations().size()-1)
                translationsStr+=("\n");
        }

        translations.setText(translationsStr);


        return rowView;
    }
}
