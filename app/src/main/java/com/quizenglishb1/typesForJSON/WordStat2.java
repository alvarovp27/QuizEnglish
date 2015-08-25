package com.quizenglishb1.typesForJSON;

/**
 * Created by Alvaro on 25/08/2015.
 */
public class WordStat2 {

    private String word;
    private int hits;
    private int fails;

    public WordStat2(String word, int hits, int fails) {
        this.word = word;
        this.hits = hits;
        this.fails = fails;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }
}
