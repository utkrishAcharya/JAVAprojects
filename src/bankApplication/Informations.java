package bankApplication;

import java.util.LinkedList;

public class Informations {

        private String name;
        private String address;
        private String phone;
        private String email;
        private String accountType;
        private long accountNumber;
        private long pin;
        private double balance;
        private LinkedList<String> statement;

        public Informations(String name, String address, String phone, String email,
                            String accountType, long accountNumber, long pin) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.email = email;
            this.accountType = accountType;
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = 0;

            // FIX: statement must be initialized
            this.statement = new LinkedList<>();

            // Initial statement
            statement.add("Account created with balance: 0");
        }

        public long getAccountNumber() {
            return accountNumber;
        }

        public long getPin() {
            return pin;
        }

        public void depositFunds(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Deposit amount must be greater than 0!");
                return;
            }
            balance += amount;
            statement.add("Deposited: " + amount);
            System.out.println("✅ Deposit successful!");
            System.out.println("Current balance: NPR " + balance);
        }

        public void withdrawFunds(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Withdrawal amount must be greater than 0!");
                return;
            }
            if (amount > balance) {
                System.out.println("❌ Insufficient balance!");
            } else {
                balance -= amount;
                statement.add("Withdrawn: " + amount);
                System.out.println("✅ Withdrawal successful!");
                System.out.println("Current balance: NPR " + balance);
            }
        }

        public void checkCustomerBalance() {
            System.out.println("💰 Current balance: NPR " + balance);
        }

        public void showStatement() {

            if (statement.isEmpty()) {
                System.out.println("----- THERE IS NO STATEMENT -----");
            } else {
                System.out.println("\n------ YOUR ACCOUNT STATEMENT ------");
                System.out.println("Name : " + name);
                System.out.println("Address : " + address);
                System.out.println("Phone : " + phone);
                System.out.println("E-mail : " + email);
                System.out.println("Account Type : " + accountType);
                System.out.println("Account Number : " + accountNumber);
                System.out.println("-------------------------------\n");

                System.out.println("\nTransaction History:");
                for (int i = 0; i < statement.size(); i++) {
                    System.out.println(statement.get(i));
                }
            }

            System.out.println("-------------------------------\n");
        }
    }

