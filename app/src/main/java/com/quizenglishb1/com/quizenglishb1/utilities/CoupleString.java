package com.quizenglishb1.com.quizenglishb1.utilities;

/**
 * Created by Alvaro on 07/07/2015.
 */
public class CoupleString {

    private String s1;
    private String s2;

    private CoupleString(String s1, String s2){
        super();
        this.s1=s1;
        this.s2=s2;
    }

    public static CoupleString create(String string1, String string2){
        return new CoupleString(string1,string2);
    }

    public static CoupleString create(){
        return new CoupleString(null,null);
    }

    public void interchange(){
        String aux = s1;
        this.s1=this.s2;
        this.s1=aux;
    }

    public void setFist(String first){
        this.s1=first;
    }

    public void setSecond(String second){
        this.s2=second;
    }

    public String getFirst(){
        return s1;
    }

    public String getSecond(){
        return s2;
    }

    public String toString(){
        return "["+s1+", "+s2+"]";
    }
}
