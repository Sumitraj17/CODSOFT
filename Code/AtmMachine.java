package Code;
import java.util.*;
interface Atm{
    public void withdraw(int amount,int code);
    public void deposit(int amount,int code);
    public void check_balance();
}
class User_account implements Atm{
    int bank_balance,pin;
    String user_name;
    public User_account(int balance,String name,int pin){
        this.bank_balance=balance;
        this.user_name=name;
        this.pin=pin;
    }
    public void withdraw(int amount,int code){
        if(validate(amount,code))
            bank_balance-=amount;
        else{
            System.out.println("\n\t\t***** Insufficient Balance *****\t\t\n");
        }
        check_balance();
    }
    public void deposit(int amount,int code){
        if (validate(amount,code)){
            bank_balance+=amount;
        }
        else{
            System.out.println("\n\t\t***** Maximum deposit per day is 100000 *****\t\t\n");
            return;
        }
        check_balance();
    }
    public void check_balance(){
        System.out.println("\n\t\t***** Your bank balance is "+this.bank_balance+" *****\t\t\n");
    }
    private boolean validate(int amount,int code){
        if (code==1){
            if(bank_balance-amount<1000)
                return false;
        }
        if(code==2)
            if(amount>100000)
                return false;
        return true;
    }
}
public class AtmMachine {
    public static void main(String args[]) {
        System.out.println("\n\t\t***** ATM MACHINE *****\t\t\n");
        Scanner sc = new Scanner(System.in);
        User_account user = new User_account(50000,"Alex",1234);
        System.out.println("Please Enter your pin");
        int pin=sc.nextInt();
        if(pin!=user.pin){
            System.out.println("\n\t\t***** Invalid Pin *****\t\t\n");
            System.exit(0);
        }
        boolean choice=true;
        while(choice){
            System.out.println("\n\t\t***** 1:- WidthDraw\t2:-Deposit\t3:-Check Balance\t4:-Exit *****\t\t\n");
            int c=sc.nextInt();
            switch(c){
                case 1:System.out.println("\nAmount:- ");
                        int withdraw_amount=sc.nextInt();
                        user.withdraw(withdraw_amount,c);
                        break;
                case 2:System.out.println("\nAmount:- ");
                        int deposit_amount=sc.nextInt();
                        user.deposit(deposit_amount,c);
                        break;
                case 3:user.check_balance();break;
                default:System.out.println("\n\t\t***** Thank You *****\t\t\n");
                    choice=false;
                    break;
            }
        }
        sc.close();
    }
}
