package bankApplication;
import java.util.*;

public class Userdetails{

    static long accountCounter = 10000000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Informations> customers = new LinkedList<>();

        while (true) {
            System.out.println("\n\n########  WELCOME TO UtkrishDADA BANK LIMITED  ########");
            System.out.println("\t\t\t\tLOGIN AND SIGN-UP PAGE");
            System.out.println("1. Sign-up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter the Option: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter numbers only.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\t!^!!!!^!!!!!!!^!!  SIGN-UP PAGE !^!!!!!^!!!!!^!\n");
                    try {
                        System.out.print("Enter User Name: ");
                        String customerName = sc.nextLine();
                        if (customerName.trim().isEmpty())
                            throw new Exceptions("Name cannot be empty!");
                        if (!customerName.matches("[a-zA-Z ]+"))
                            throw new Exceptions("Name cannot be numeric!");

                        System.out.print("Enter Customer Address: ");
                        String customerAddress = sc.nextLine();
                        if (customerAddress.trim().isEmpty())
                            throw new Exceptions("Address cannot be empty!");

                        System.out.print("Enter Customer Phone Number: ");
                        String customerPhone = sc.nextLine();
                        if (!customerPhone.matches("\\d{10}"))
                            throw new Exceptions("Phone number must be 10 digits!");

                        System.out.print("Enter Customer E-mail: ");
                        String customerEmail = sc.nextLine();
                        if (!customerEmail.contains("@gmail.com"))
                            throw new Exceptions("Invalid email format!");

                        // Choose account type
                        String customerAccountType = "";
                        do {
                            System.out.println("\nPlease Select Account Type:");
                            System.out.println("1. Savings Account");
                            System.out.println("2. Current Account");
                            System.out.println("3. Fixed Deposit Account");
                            System.out.print("Enter option from 1 to 3 = ");
                            choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1: customerAccountType = "SAVINGS ACCOUNT"; break;
                                case 2: customerAccountType = "CURRENT ACCOUNT"; break;
                                case 3: customerAccountType = "FIXED DEPOSIT ACCOUNT"; break;
                                default: System.out.println(" Invalid choice! Please choose from 1 to 3.");
                            }
                        } while (customerAccountType.isEmpty());

                        // Generate unique account number
                        accountCounter++;
                        long accNumber = accountCounter;

                        // Create PIN
                        long pin = 0;
                        boolean validPin = false;
                        do {
                            System.out.println("\n\nPIN CODE OPTION.");
                            System.out.println("1. Create PIN Random");
                            System.out.println("2. Create PIN Self");
                            System.out.println("3. Exit");
                            System.out.print("Enter the option : ");
                            choice = sc.nextInt();
                            sc.nextLine();

                            switch (choice) {
                                case 1:
                                    pin = 1000 + new Random().nextInt(9000);
                                    validPin = true;
                                    break;
                                case 2:
                                    System.out.print("Create your PIN code (4 digits): ");
                                    pin = sc.nextLong();
                                    sc.nextLine();
                                    if (pin < 1000 || pin > 9999) {
                                        System.out.println(" PIN must be 4 digits!");
                                    } else {
                                        validPin = true;
                                    }
                                    break;
                                case 3:
                                    System.out.println("Thanks for using the App!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println(" Invalid PIN choice!");
                            }
                        } while (!validPin);

                        // Create customer account
                        Informations customerAccount = new Informations(
                                customerName, customerAddress, customerPhone,
                                customerEmail, customerAccountType, accNumber, pin
                        );
                        customers.add(customerAccount);

                        System.out.println("\nAccount created successfully!");
                        System.out.println("Account Number: " + accNumber);
                        System.out.println("Transaction PIN: " + pin);

                    } catch (Exceptions e) {
                        System.out.println("\n Error: " + e.getMessage());
                        System.out.println("Please enter correct information. Thank you!");
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input type!");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("\t\t\t\t<<<<<<<<<<<<<  LOGIN PAGE  >>>>>>>>>>>");
                    try {
                        System.out.print("Enter Account Number: ");
                        long loginAcc = sc.nextLong();
                        System.out.print("Enter PIN: ");
                        long loginPin = sc.nextLong();
                        sc.nextLine();

                        boolean loggedIn = false;
                        for (int i = 0; i < customers.size(); i++) {
                            Informations cust = customers.get(i);
                            if (cust.getAccountNumber() == loginAcc && cust.getPin() == loginPin) {
                                loggedIn = true;
                                System.out.println("\n Login successful!");
                                int op;
                                do {
                                    System.out.println("\nChoose an option:");
                                    System.out.println("1. Deposit");
                                    System.out.println("2. Withdraw");
                                    System.out.println("3. Check Balance");
                                    System.out.println("4. Show Statement");
                                    System.out.println("5. Logout");
                                    System.out.print("Enter choice: ");
                                    op = sc.nextInt();
                                    sc.nextLine();

                                    switch (op) {
                                        case 1:
                                            System.out.print("Enter deposit amount: ");
                                            double dep = sc.nextDouble();
                                            sc.nextLine();
                                            cust.depositFunds(dep);
                                            break;
                                        case 2:
                                            System.out.print("Enter withdrawal amount: ");
                                            double wd = sc.nextDouble();
                                            sc.nextLine();
                                            cust.withdrawFunds(wd);
                                            break;
                                        case 3:
                                            cust.checkCustomerBalance();
                                            break;
                                        case 4:
                                            cust.showStatement();
                                            break;
                                        case 5:
                                            System.out.println("Logging out...");
                                            break;
                                        default:
                                            System.out.println(" Invalid choice!");
                                    }
                                } while (op != 5);
                                break;
                            }
                        }
                        if (!loggedIn) {
                            System.out.println(" Invalid Account Number or PIN!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(" Invalid input type! Only numbers are allowed.");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("Thanks for using the App!");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid option! Please choose 1 to 3.");
            }
        }
    }
}
