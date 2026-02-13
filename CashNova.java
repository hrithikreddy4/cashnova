import java.util.Scanner;

// Account Class
class Account {
    private String username;
    private String pin;
    private double balance;

    public Account(String username, String pin, double balance) {
        this.username = username;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(String user, String inputPin) {
        return username.equals(user) && pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// ATM Class
class ATM {
    private Account account;
    private Scanner sc = new Scanner(System.in);

    public ATM(Account account) {
        this.account = account;
    }

    public void start() {
        System.out.println("===== Welcome to CashNova ATM =====");

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (account.authenticate(user, pin)) {
            System.out.println("Login Successful!\n");
            showMenu();
        } else {
            System.out.println("Invalid Credentials. Exiting...");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n--- CashNova ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ₹");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Thank you for using CashNova!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

// Main Class
public class CashNova {
    public static void main(String[] args) {
        Account userAccount = new Account("hrithik", "1234", 5000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
