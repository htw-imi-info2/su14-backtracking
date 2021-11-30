package permutations.v3_iterative;

public class Factorial {
    public static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
