import java.util.Scanner;

public class ATM {
    float Balance;
    int pin = 1234;

    public void checkPin() {
        System.out.println("Enter your PIN");
        try (Scanner sc = new Scanner(System.in)) {
            int enteredPin = sc.nextInt();
            if (enteredPin == pin) {
                menu();
            } else {
                System.out.println("Enter a valid PIN");
            }
        }
    }

    public void menu() {
        System.out.println("Enter your Choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

        try (Scanner sc = new Scanner(System.in)) {
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter a valid choice");
                    menu();
            }
        }
    }

    public void checkBalance() {
        System.out.println("Check Balance: " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.print("Enter amount to be withdrawn: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money withdrawal successful");
        }
        menu();
    }

    public void depositMoney() {
        System.out.print("Enter amount to be deposited: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money deposited successfully");
        menu();
    }

    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}
