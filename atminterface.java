import java.util.Scanner;

public class atminterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.00;  // Initial balance
        int pin = 1234;            // Dummy PIN for authentication

        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = scanner.nextInt();

        // Authenticate PIN
        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        int choice;
        do {
            // Display menu
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Check balance
                    System.out.printf("Your current balance is: ₹%.2f\n", balance);
                    break;

                case 2: // Deposit money
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("₹%.2f deposited successfully.\n", deposit);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3: // Withdraw money
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("₹%.2f withdrawn successfully.\n", withdraw);
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
