
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        //inits Scanner
        Scanner sc = new Scanner(System.in);

        //inits Bank
        Bank theBank = new Bank("Bank of Shtil'");

        //add a user which also creates a savings account
        User aUser = theBank.addUser("John", "Conor" , "1234");

        //add a checking account for our user
        Account newAccount = new Account("Cheking", aUser , theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true){

            //stay in login prompt until successful login
            curUser = ATM.mainMenuPromt(theBank , sc);

            //stay in main menu until user quits
            ATM.printUserMenu(curUser , sc);


        }
    }
    public static User mainMenuPromt(Bank theBank , Scanner sc){

        //inits
        String userID;
        String pin;
        User authUser;

        //promt the user for user ID/pin combo until a correct one is reached
        do {
            System.out.printf("\n\nWelcome to %s\n\n" , theBank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter pin: ");
            pin = sc.nextLine();

            //try to get the user object corresponding to the ID and pin combo
            authUser = theBank.userLogin(userID , pin);
            if(authUser == null){
                System.out.println("Incorrent user ID or pin.  " +
                        "Please try again.");
            }

        } while(authUser == null); //continue looping until successful login

        return authUser;
    }

    public static void printUserMenu(User theUser , Scanner sc){

        //print a summary of user`s accounts
        theUser.printAccountSummary();

        //inits
        int choice;

        //user menu
        do {
            System.out.printf("Welcome %s , what would you like to do?" ,
                    theUser.getFirstname());
            System.out.println("  1) Show account transaction history\n  2) Withdrawl\n  3) Deposit" +
                    "\n  4) Transfer\n  5) Quit\nEnter your choice:");
            choice = sc.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice. Please choose 1-5");
            }
        }while (choice < 1 || choice > 5);

        //process the choice
        switch (choice){
            case 1:
                ATM.showTransHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawlFunds(theUser , sc);
                break;
            case 3:
                ATM.depositFunds(theUser , sc);
                break;
            case 4:
                ATM.transferFunds(theUser , sc);
                break;
        }

        //redisplay this menu unless the user wants to quite
        if(choice != 5){
            ATM.printUserMenu(theUser , sc);
        }
    }
}
