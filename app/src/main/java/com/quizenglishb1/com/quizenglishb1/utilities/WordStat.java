package com.quizenglishb1.com.quizenglishb1.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvaro on 10/08/2015.
 */
public class WordStat extends Word{
    private Integer hits;
    private Integer fails;

    protected WordStat(String mainWord, List<Word> translations, String type, Integer hits, Integer fails){
        super(mainWord,translations,type,null);

        this.hits=hits;
        this.fails=fails;
    }

    public static WordStat create(String mainWord, List<Word> translations, String type, Integer hits, Integer fails){
        return new WordStat(mainWord, translations, type, hits, fails);
    }

    public void setStats(Integer hits, Integer fails){
        this.hits=hits;
        this.fails=fails;
    }

    public Integer getHits(){
        return hits;
    }

    public Integer getFails(){
        return fails;
    }
}
