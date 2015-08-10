package com.quizenglishb1.com.quizenglishb1.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvaro on 09/08/2015.
 */
public class Word {

    private String mainWord;
    private List<Word> translations;
    private String type;

    private Word(String mainWord, List<Word> translations, String type){
        this.mainWord=mainWord;
        this.type=type;

        if(translations!=null)
            this.translations = new ArrayList<>(translations);
        else
            this.translations = new ArrayList<>();
    }

    public static Word create(String mainWord, List<Word> translations, String type){
        return new Word(mainWord,translations,type);
    }

    public static Word create(String mainWord,String type){
        return new Word(mainWord,null,type);
    }

    public String getMainWord(){
        return mainWord;
    }

    public List<Word> getTranslations(){
        return new ArrayList<>(translations);
    }

    public String getType(){
        return type;
    }

    public void addTranslation(Word word){
        translations.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!mainWord.equals(word.mainWord)) return false;
        return type.equals(word.type);

    }

    @Override
    public int hashCode() {
        int result = mainWord.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    public String toString(){
        return mainWord+" ("+type+")";
    }
}
