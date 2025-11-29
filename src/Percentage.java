public class Percentage {

    public static double calculate(double part, double whole) {
        if (whole == 0) {
            throw new IllegalArgumentException("Whole cannot be zero when computing percentage");
        }
        return (part / whole) * 100.0;
    }
}
