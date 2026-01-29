class BankAccount
{
    double balance = 500;

    void deposit(double amt)
    {
        balance = balance + amt;
    }

    void withdraw(double amt)
    {
        balance = balance - amt;
    }
}

class SavingsAccount extends BankAccount
{
    void withdraw(double amt)
    {
        if(balance - amt < 100)
            System.out.println("Withdrawal not allowed");
        else
            balance = balance - amt;
    }

    public static void main(String args[])
    {
        SavingsAccount s = new SavingsAccount();
        s.withdraw(450);
        System.out.println("Balance : " + s.balance);
    }
}
