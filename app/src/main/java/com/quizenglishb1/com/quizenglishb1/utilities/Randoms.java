package com.quizenglishb1.com.quizenglishb1.utilities;

import java.util.Random;

/**
 * Created by Alvaro on 03/08/2015.
 */
public class Randoms {


    /**
     * Pr�ximos m�todos:
     * - Generar un double aleatorio entre 0 y un l�mite superior con una presici�n dada
     * - Generar un int entre un l�mite inferior dado y otro superior
     * - Generar tambi�n n�meros negativos
     *
     * */

    /**
     * Generate a double between 0 and 1
     * */
    private static double randomDouble(){
        int num = randomInt(101);
        double doub = (double) num;
        return doub/100.0;
    }

    /**
     * Returns a int between 0 and the number given as param (inclusive)
     * */
    public static int randomInt(int limSup){
        Random r = new Random();
        return r.nextInt(limSup+1);
    }

}