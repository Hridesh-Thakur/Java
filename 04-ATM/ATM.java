import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    static double balance = 5000.0;
    static int pin = 1234;
    static ArrayList<String> history = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Sahi number lene ke liye (letters daalne pe crash nahi hoga)
    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Number daalo: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double readAmount() {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid amount. Number daalo: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    // PIN check, 3 attempts
    static boolean login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter your 4-digit PIN: ");
            int entered = readInt();
            if (entered == pin) {
                return true;
            }
            System.out.println("Wrong PIN. Attempts left: " + (3 - attempt));
        }
        return false;
    }

    static void checkBalance() {
        System.out.printf("Your balance is: Rs. %.2f%n", balance);
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = readAmount();
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        balance += amount;
        history.add(String.format("Deposited  Rs. %.2f", amount));
        System.out.printf("Rs. %.2f deposited successfully.%n", amount);
        checkBalance();
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw (multiple of 100): ");
        double amount = readAmount();
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
        } else if (amount % 100 != 0) {
            System.out.println("Amount must be a multiple of 100.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            history.add(String.format("Withdrawn  Rs. %.2f", amount));
            System.out.printf("Please collect your cash: Rs. %.2f%n", amount);
            checkBalance();
        }
    }

    static void changePin() {
        System.out.print("Enter old PIN: ");
        int oldPin = readInt();
        if (oldPin != pin) {
            System.out.println("wrong old PIN. ");
            return;
        }
        System.out.print("Enter new 4-digit PIN: ");
        int newPin = readInt();
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("PIN exactly 4 digit ka hona chahiye (1000 se 9999).");
            return;
        }
        System.out.print("Confirm new PIN: ");
        int confirmPin = readInt();
        if (newPin != confirmPin) {
            System.out.println("PIN match nahi hua.");
            return;
        }
        pin = newPin;
        System.out.println("PIN successfully change ho gaya.");
    }

    static void miniStatement() {
        System.out.println("---- Mini Statement (last 5) ----");
        if (history.isEmpty()) {
            System.out.println("Non e transactions yet.");
        } else {
            int start = Math.max(0, history.size() - 5);
            for (int i = start; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
        checkBalance();
    }

    public static void main(String[] args) {
        System.out.println("===== Welcome to the ATM =====");

        if (!login()) {
            System.out.println("Too many wrong attempts. Card blocked!");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Mini statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    miniStatement();
                    break;
                case 5:
                    changePin();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}