package ATM;

import java.util.Scanner;


public  class Main {
    boolean running = true;
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. check your balance");
            System.out.println("2. deposit money");
            System.out.println("3. withdraw money");
            System.out.println("4. Thank you for using the ATM");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + 1000);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    System.out.println("You have deposited: " + depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    System.out.println("You have withdrawn: " + withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
         }
    }
    
}
