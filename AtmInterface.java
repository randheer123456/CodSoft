import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful. Current Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance. Current Balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class AtmInterface {
    private BankAccount bankAccount;

    public AtmInterface(BankAccount account) {
        bankAccount = account;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAutomated Teller Machine");
            System.out.println("1 - Withdraw");
            System.out.println("2 - Deposit");
            System.out.println("3 - Check Balance");
            System.out.println("4 - EXIT");
            System.out.print("Choose the operation you want to perform: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter money to be deposited: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(50000); // Initial balance set to 50,000 for example
        AtmInterface atmMachine = new AtmInterface(account);
        atmMachine.startATM();
    }
}
