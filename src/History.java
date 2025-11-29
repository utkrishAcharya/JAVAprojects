import java.util.ArrayList;

public class History {
    private static ArrayList<String> historyList = new ArrayList<>();

    public static void add(String record) {
        historyList.add(record);
    }

    public static void show() {
        if (historyList.isEmpty()) {
            System.out.println("No history yet.");
            return;
        }
        System.out.println("\n===== Calculation History =====");
        for (String rec : historyList) {
            System.out.println(rec);
        }
        System.out.println("|-------_____-------|\n");
    }
}
