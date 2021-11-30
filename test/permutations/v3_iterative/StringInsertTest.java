package permutations.v3_iterative;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringInsertTest {

    @Test
    public void insert(){
        assertEquals("hallo",Permutations.insert('a',1,"hllo"));
    }
    @ParameterizedTest
    @CsvSource({"hallo, a, 1, hllo",
            "hallo, h, 0, allo",
            "hallo, o, 4, hall"})
    public void insert(String result,char c, int p, String input){
        assertEquals(result,Permutations.insert(c,p,input));
    }
}
