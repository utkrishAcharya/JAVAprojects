public class Addition {

    public static double calculate(double... nums) {
        double sum = 0;
        for (double n : nums) {
            sum += n;
        }
        return sum;
    }
}
