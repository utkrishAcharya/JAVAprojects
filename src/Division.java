public class Division {
    public static double calculate(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("No numbers provided");
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) throw new ArithmeticException("Division by zero");
            result /= nums[i];
        }
        return result;
    }
}
