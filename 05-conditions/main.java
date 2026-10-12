import java.util.Scanner;

class movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age < 5) {
            System.out.println("free movie ticket");
        }
        else if (age < 17) {
            System.out.println("Movie price is 120");
        }
        else if (age <= 60) {
            System.out.println("Movie price is 200");
        }
        else {
            System.out.println("mar ja mt dekh movie ghar beth.");
        }

        sc.close();
    }
}