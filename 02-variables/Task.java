package variables;
// chai bill spliter
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total bill amount: ");
        int totalBill = sc.nextInt();
        System.out.print("Enter number of people: ");
        int numberOfPeople = sc.nextInt();
        int amountPerPerson = totalBill / numberOfPeople;
        System.out.println("Every one have to pay : " + amountPerPerson);
        double decimalShare = (double) totalBill / numberOfPeople;
        System.out.printf("Each person should pay: %.2f%n", decimalShare);

        sc.close();
    }
}