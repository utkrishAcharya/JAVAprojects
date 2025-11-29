public class Multiplication {
    public static double calculate(double... nums) {
        if (nums.length == 0) return 0;
        double result = 1;
        for (double n : nums) {
            result *= n;
        }
        return result;
    }
}
