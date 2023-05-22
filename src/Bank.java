import java.util.ArrayList;
import java.util.Random;

public class Bank {

    /**
    The name of this bank
     */
    private String name;

    /**
    The list of users
     */
    private ArrayList<User> users;

    /**
    The list of accounts
     */
    private ArrayList<Account> accounts;

    /**
     * Generate a new universally unique ID for the User
     * @return the UUID
     */
    public String getNewUserUUID(){

        //inits
        String uuid;
        Random rng = new Random();
        int length = 6;
        boolean nonUnique;

        //looping until we get a unique ID
        do {

            //generate the number
            uuid="";
            for(int i = 0 ; i < length ; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it`s unique
            nonUnique = false;
            for(User user: this.users){
                if(uuid.compareTo(user.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }


        }while (nonUnique);

        return uuid;
    }

    /**
     * Generate a new universally unique ID for the Account
     * @return the UUID
     */
    public String getNewAccountUUID(){
        //inits
        String uuid;
        Random rng = new Random();
        int length = 10;
        boolean nonUnique;

        //looping until we get a unique ID
        do {

            //generate the number
            uuid="";
            for(int i = 0 ; i < length ; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it`s unique
            nonUnique = false;
            for(Account account: this.accounts){
                if(uuid.compareTo(account.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }


        }while (nonUnique);

        return uuid;
    }

    /**
     * Add an account
     * @param anAcct the     account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

}
