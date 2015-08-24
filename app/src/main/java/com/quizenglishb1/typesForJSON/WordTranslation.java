package com.quizenglishb1.typesForJSON;

/**
 * Created by Alvaro on 24/08/2015.
 */
public class WordTranslation {
    private String wordSP;
    private String typeSP;
    private String wordEN;
    private String typeEN;
    private String category;

    public WordTranslation(String wordSP, String typeSP, String wordEN, String typeEN, String category) {
        this.wordSP = wordSP;
        this.typeSP = typeSP;
        this.wordEN = wordEN;
        this.typeEN = typeEN;
        this.category = category;
    }

    public void setWordSP(String wordSP) {
        this.wordSP = wordSP;
    }

    public void setTypeSP(String typeSP) {
        this.typeSP = typeSP;
    }

    public void setWordEN(String wordEN) {
        this.wordEN = wordEN;
    }

    public void setTypeEN(String typeEN) {
        this.typeEN = typeEN;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWordSP() {
        return wordSP;
    }

    public String getTypeSP() {
        return typeSP;
    }

    public String getWordEN() {
        return wordEN;
    }

    public String getTypeEN() {
        return typeEN;
    }

    public String getCategory() {
        return category;
    }
}
