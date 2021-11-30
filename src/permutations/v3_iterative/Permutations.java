package permutations.v3_iterative;

import java.util.ArrayList;
import java.util.List;

/**
 * Überschrift: Permutations
 * Beschreibung: Example of an application that cannot be solved by
 * iteration, recursion is necessary because you don't
 * know how many nested loops you need
 * Copyright: Copyright (c) 2003-04-14
 * Organisation: FHTW
 * @author Debora Weber-Wulff
 * @version 1.16
 */

public class Permutations {

    public static String insert(char c, int pos, String str){
        return str.substring(0,pos)+c+str.substring(pos,str.length());
    }
    public List<String> permutations(String input){
        List<String> permutations = new ArrayList<>();
        permutations.add(""+input.charAt(0));
        for(int i=1;i<input.length();i++){
            // permutationsSoFar enthaelt i! permutations der Länge i
            assert permutations.size() == Factorial.factorial(i);
            assert permutations.get(0).length() == i;

            char c = input.charAt(i);
            List<String> newPermutations = new ArrayList<>(i*permutations.size());
            for(String iLengthPermutation : permutations){ // * i!
              for(int p = 0; p<=i; p++) { // *i
                  newPermutations.add(insert(c,p,iLengthPermutation));
              }
            }
            permutations = newPermutations;
        }
        return permutations;
    }

}
