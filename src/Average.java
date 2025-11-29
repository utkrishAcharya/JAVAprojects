public class Average {
    public static double calculate(double[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        double sum = 0;
        for (double v : values) sum += v;
        return sum / values.length;
    }
}
