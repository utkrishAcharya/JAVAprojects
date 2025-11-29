import java.util.HashMap;
import java.util.Map;

public class Mode {
    public static Double calculate(double[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        Map<Double, Integer> freq = new HashMap<>();
        for (double v : values) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        double mode = values[0];
        int maxCount = 1;
        boolean unique = true;
        for (Map.Entry<Double, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            double val = entry.getKey();
            if (count > maxCount) {
                maxCount = count;
                mode = val;
                unique = true;
            } else if (count == maxCount && val != mode) {
                unique = false;
            }
        }
        return unique ? mode : null;
    }
}
