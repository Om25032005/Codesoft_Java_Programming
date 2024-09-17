import java.util.Scanner;
public class ATMSystem3
{
    static class BankAccount
    {
        private double balance;
        public BankAccount(double initialBalance)
        {
            if (initialBalance >= 0)
            {
                this.balance = initialBalance;
            }
            else
            {
                System.out.println("Initial balance cannot be negative.");
                this.balance = 0;
            }
        }
        public double getBalance()
        {
            return balance;
        }
        public void deposit(double amount)
        {
            if (amount > 0)
            {
                balance += amount;
                System.out.println("Successfully deposited $" + amount);
            }
            else
            {
                System.out.println("Deposit amount must be positive.");
            }
        }
        public boolean withdraw(double amount)
        {
            if (amount > 0 && amount <= balance)
            {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
                return true;
            }
            else if (amount > balance)
            {
                System.out.println("Insufficient funds.");
            }
            else
            {
                System.out.println("Withdrawal amount must be positive.");
            }
            return false;
        }
    }
    static class ATM
    {
        private BankAccount account;
        private Scanner scanner;
        public ATM(BankAccount account)
        {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }
        public void start()
        {
            boolean running=true;
            while(running)
            {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice)
                {
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
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
        private void checkBalance()
        {
            System.out.println("Current balance: $" + account.getBalance());
        }
        private void deposit()
        {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
        private void withdraw()
        {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.start();
    }
}



/* 

Output:-

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1
Current balance: $1000.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 2
Enter amount to deposit: 500
Successfully deposited $500.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 3
Enter amount to withdraw: 200
Successfully withdrew $200.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option: 1
Current balance: $1300.0

ATM Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Choose an option:
*/