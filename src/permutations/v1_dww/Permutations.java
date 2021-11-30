package permutations.v1_dww;

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

    static int count;

    // Return the string s without the character at position i
    public static String remove (String s, int i)
    {
// check if string is long enough
        int len = s.length();
        if (i >= len || len == 1) return "";

        if (i == 0) {
// i is the first character
            return s.substring (1);
        }
        else {
            if (i == len-1){
// i is the last character
// Note that s.substring (i,j) is the string that
// begins in position i and extends to j-1. Isn't Java fun!

                return s.substring (0, len-1);
            }
            else {
// is is in the middle somewhere
                return s.substring (0,i) + s.substring(i+1,len);
            }
        }
    }

    // This is the recursive method for constructing the permutations.
// We construct all permutations for rest and prepend prefix to them
    public static void writePerms (String prefix,
                                   String rest)
    {
        int len = rest.length();

       // If rest is empty, we have a permutation, so print it!
        if (len == 0) {
            count++;
            System.out.println (prefix);
        }
        else {
            for (int i=0; i < len; i++) {
                writePerms (prefix + rest.charAt(i),
                        remove (rest, i));
            }
        }
    }

    public static void main (String[] args)
    {
        String input = args.length > 0 ? args[0] : "helo";
        System.out.println ("Permutations of " + input);
        count = 0;
        writePerms ("", input);
        System.out.println ("We found " + count + " permutations.");
    }
}
