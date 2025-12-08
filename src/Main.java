
import java.util.Scanner;
import java.util.Arrays;  // for Arrays.toString
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("^_^ WELCOME TO THE UTKRISH WORLD ^_^");
            System.out.println("____ Calculator Menu____");
            System.out.print("1 – Addition");
            System.out.println("2 – Subtraction");
            System.out.println("3 – Multiplication");
            System.out.println("4 – Division");
            System.out.println("5 – Percentage");
            System.out.println("6 – Average");
            System.out.println("7 – Mean");
            System.out.println("8 – Median ");
            System.out.println("9 – Mode ");
            System.out.println("10 – Show History");
            System.out.println("11 – Turn Off Calculator");
//            System.out.print("Enter What you want to Calculate (1-11): ");

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                // arithmetic
                System.out.print("How many numbers do you want to Calculate? ");
                int n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Enter at least 1 number.");
                    continue;
                }
                double[] values = new double[n];
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    values[i] = sc.nextDouble();
                }

                double result = 0;
                String operation = switch (choice) {
                    case 1 -> {
                        result = Addition.calculate(values);
                        yield "Addition";
                    }
                    case 2 -> {
                        result = Subtraction.calculate(values);
                        yield "Subtraction";
                    }
                    case 3 -> {
                        result = Multiplication.calculate(values);
                        yield "Multiplication";
                    }
                    case 4 -> {
                        result = Division.calculate(values);
                        yield "Division";
                    }
                    default -> "";
                };

                System.out.println("Processing!!!!!!!!");
                System.out.println("Result is : " + result);

                // record history
                History.add(operation + " " + Arrays.toString(values) + " = " + result);

            } else if (choice == 5) {

                System.out.print("Enter a (number): ");
                double a = sc.nextDouble();
                System.out.print("Enter b (number): ");
                double b = sc.nextDouble();
                double result = Percentage.calculate(a, b);
                System.out.println("Percentage: " + result + "%");

                History.add("Percentage: " + a + " and " + b + " => " + result + "%");

            } else if (choice >= 6 && choice <= 9) {
                //  statistics (Average, Mean, Median, Mode)
                System.out.print("How many numbers are in the list? ");
                int n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("You must have at least 1 number.");
                    continue;
                }
                double[] arr = new double[n];
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    arr[i] = sc.nextDouble();
                }

                switch (choice) {
                    case 6:
                        double avg = Average.calculate(arr);
                        System.out.println("Average = " + avg);
                        History.add("Average of " + Arrays.toString(arr) + " = " + avg);
                        break;
                    case 7:
                        double mean = Mean.calculate(arr);
                        System.out.println("Mean = " + mean);
                        History.add("Mean of " + Arrays.toString(arr) + " = " + mean);
                        break;
                    case 8:
                        double med = Median.calculate(arr);
                        System.out.println("Median = " + med);
                        History.add("Median of " + Arrays.toString(arr) + " = " + med);
                        break;
                    case 9:
                        Double m = Mode.calculate(arr);
                        if (m == null) {
                            System.out.println("No unique mode found.");
                            History.add("Mode of " + Arrays.toString(arr) + " = none");
                        } else {
                            System.out.println("Mode = " + m);
                            History.add("Mode of " + Arrays.toString(arr) + " = " + m);
                        }
                        break;
                }

            } else if (choice == 10) {
                History.show();

            } else if (choice == 11) {
                exit = true;
                System.out.println(" Thank you Goodbye!");
            } else {
                System.out.println("Wrong input. Try again.");
            }
        }

        sc.close();
    }
}
