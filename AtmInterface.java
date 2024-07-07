import java.util.Scanner;

class BankAccount{
    private float balance;

    public BankAccount(float initialAmount){
        this.balance = initialAmount;
    }

    public float balance(){
        return balance;
    }

    public void deposit(float amount){
        if (amount > 0){
            balance += amount;
            System.out.println("" + amount + "₹ is deposited on your RBI Bank account xxxxxx2047 successfully");
            System.out.println("Your remaining balance"+" "+balance);
        } else {
            System.out.println("Invalid entry. Please choose a number above 0");
        }
    }

    public void withdrawl(float amount){
        if (amount > 0 && amount <= balance){
            System.out.println(""+amount+"₹ Credit on your RBI Bank account xxxxxx2047 successfully");
            balance -= amount;
            System.out.println("Remaining balance"+" "+balance);
        } else {
            System.out.println("Invaid entry!!.Insuffucient balance ");
        }
    }
}

class ATM{

    private final BankAccount account; 
    public ATM(BankAccount account){
        this.account = account;
    }

    public void display(){
        System.out.println("   ~ Select Options ~");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Cancel");
    }

    public void run(){
        try (Scanner sc = new Scanner(System.in)) {
            int option;
            do{
                display();
                System.out.println("Choose an option");
                option = sc.nextInt();
                
                switch (option){
                    case 1 -> {
                        System.out.println("Enter amount to deposit");
                        float depositAmount = sc.nextInt();
                        account.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.println("Enter amount to withdraw");
                        float withdrawAmount = sc.nextInt();
                        account.withdrawl(withdrawAmount);
                    }
                    case 3 -> System.out.println("Current balance " + account.balance());
                    case 4 -> System.out.println("Thanks for using RBI(Raushan Bank of India)");
                    default -> System.out.println("Opps! Choose the correct options");
                }
            }while (option != 4);
        }
    }
}

public class AtmInterface {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BankAccount userAccount = new BankAccount(5600);
            ATM atm = new ATM(userAccount);
            System.out.println("Enter Your PIN");
            String pin = sc.nextLine();
            if (pin.equals("7323")) {
                atm.run();
            } else {
                System.out.println("You have Entered the Wrong pin");      
            }
        }
         }
}