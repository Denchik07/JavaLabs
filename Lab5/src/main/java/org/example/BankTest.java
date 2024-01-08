package org.example;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Jane Doe", 500);

        System.out.println("Initial Account Details:");
        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());

                // Testing deposit and withdrawal
                account1.deposit(500);
                account2.withdraw(200);

                // Testing insufficient funds exception
                account1.withdraw(2000);

                // Testing negative amount exception
                account2.deposit(-100);

                // Testing account not found exception
                BankAccount account3 = bank.findAccount(3);

                // Testing money transfer
                bank.transferMoney(1, 2, 300);


            System.out.println("\nUpdated Account Details:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());
    }
}
