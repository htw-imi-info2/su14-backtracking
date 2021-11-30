package permutations.v2_function;

import java.util.ArrayList;
import java.util.List;

/**
 * Überschrift: Permutations
 * Beschreibung: Example of an application that is more
 *  * elegantly solved with recursion than iteration
 *  * (comment edited by B. Kleinen)
 *  * Organisation: HTW
 *  * @author Debora Weber-Wulff
 *  * @author Barne Kleinen: created testable function,
 *  everything else close to the original
 */

public class Permutations {

    // Return the string s without the character at position i
    public static String remove (String s, int p){
        return s.substring(0,p)+s.substring(p+1,s.length());
    }
    // This is the recursive method for constructing the permutations.
    // We construct all permutations for rest and prepend prefix to them
    public void writePerms (List<String> output,
                                   String prefix,
                                   String rest)
    {
        int len = rest.length();

        // If rest is empty, we have a permutation, so print it!
        if (len == 0) {
            output.add(prefix);
        }
        else {
            for (int i=0; i < len; i++) {
                writePerms (output,prefix + rest.charAt(i),
                        remove (rest, i));
            }
        }
    }
    public List<String> permutations(String input){
        List<String> permutations = new ArrayList<>();
        writePerms (permutations,"", input);
        return permutations;
    }
    public static void main (String[] args)
    {
        String input = args.length > 0 ? args[0] : "helo";
        System.out.println ("Permutations of " + input);
        List<String> permutations = (new Permutations()).permutations(input);
        for(String s: permutations) System.out.println(s);
        System.out.println ("We found " + permutations.size() + " permutations.");
    }
}
