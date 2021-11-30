package permutations.v2_function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import permutations.v3_iterative.Factorial;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PermutationsTest {
    Permutations permutations = new Permutations();

    @ParameterizedTest
    @MethodSource("permutationsProvider")
    public void testPermutations(String input, String[] expectedPermutations){
        List<String> actualPermutations = permutations.permutations(input);
        assertEquals(expectedPermutations.length,actualPermutations.size());
        Set<String> expected = new HashSet<>(Arrays.asList(expectedPermutations));
        Set<String> actual = new HashSet<>(actualPermutations);

        for (String p : expected) {
            assertTrue(actual.contains(p)," permutation missing: "+p);
        }
    }


    @ParameterizedTest
    @ValueSource(strings = { "Apfel",  "Apfel6",  "Methode", "Methode8", "Mandarine", "Mandarin10", "Mandarine11" })
    // length 12 produces an OutOfMemoryError on my machine
    //@ValueSource(strings = { "Apfel",  "Apfel6",  "Methode", "Methode8", "Mandarine", "Mandarin10", "Mandarine11", "Mandarinen12" })
    public void testLongerPermutations(String input){
        //assertEquals(factorial(11),permutations.permutations("stringmit11"));
        List<String> actual = permutations.permutations(input);
        //assertIterableEquals(new String[]{"ab","ba"},actual);
        assertEquals(Factorial.factorial(input.length()),actual.size(), "Input: "+input+" l: "+input.length());
    }

    static Stream<Arguments> permutationsProvider() {
        return Stream.of(
                arguments("a", new String[]{"a"}),
                arguments("ab", new String[]{"ab","ba"}),
                arguments("abc", new String[]{"abc","acb","bac","bca", "cab", "cba"}),
                arguments("abcd", new String[]{"abcd","abdc","acbd","acdb","adbc","adcb","bacd","badc","bcad","bcda","bdac","bdca",
                        "cabd","cadb","cbad","cbda","cdab","cdba","dabc","dacb","dbac","dbca","dcab","dcba"}),
                arguments("AB", new String[]{"AB","BA"})
        );
    }

}
