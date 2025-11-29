public class Subtraction {
    public static double calculate(double... nums) {
        if (nums.length == 0) return 0;
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;
    }
}
