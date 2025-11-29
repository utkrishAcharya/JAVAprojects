import java.util.Arrays;

public class Median {
    public static double calculate(double[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        double[] copy = Arrays.copyOf(values, values.length);
        Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n/2];
        } else {
            return (copy[n/2 - 1] + copy[n/2]) / 2.0;
        }
    }
}
