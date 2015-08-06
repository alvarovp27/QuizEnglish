package com.quizenglishb1.com.quizenglishb1.utilities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvaro on 06/08/2015.
 */
public class Answer implements Serializable{

    private String question;
    private String answered;
    private List<String> rightAsnwers;

    public Answer(String question,String answered,List<String> rightAsnwers){
        this.answered=answered;
        this.question=question;
        this.rightAsnwers = new ArrayList<>(rightAsnwers);
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswered(){
        return answered;
    }

    public List<String> getRightAsnwers(){
        return new ArrayList<>(rightAsnwers);
    }

    public boolean isRight(){
        return rightAsnwers.contains(answered);
    }

}
