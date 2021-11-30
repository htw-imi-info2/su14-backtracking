package permutations.v2_function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveTest {

    @ParameterizedTest
    @CsvSource({"hallo, 1, hllo",
            "hallo, 0, allo",
            "hallo, 4, hall"})
    public void remove(String input, int p, String result){
        assertEquals(result, Permutations.remove(input,p));
    }
}
