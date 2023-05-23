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
     * Create a new bank with lists of users and accounts
     * @param name name of the bank
     */
    public Bank(String name){

        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();

    }

    public String getName() {
        return name;
    }

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

    /**
     * Create new User
     * @param firstname User`s firstname
     * @param lastname User`s lastname
     * @param pin User`s pin
     * @return
     */
    public User addUser(String firstname , String lastname , String pin){

        //create a new User object and add it to the list
        User newUser = new User(firstname , lastname ,pin , this);
        this.users.add(newUser);

        //create savings account for the user and add to
        //User and Bank accounts lists
        Account newAccount = new Account("Savings" , newUser , this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    /**
     * Get the User object associated with a particular userID and pin ,
     * if they are valid
     * @param userID the UUID of the user to log in
     * @param pin The pin of the user
     * @return the User object , if the login is successful , or null ,
     * if it`s not
     */
    public User userLogin(String userID ,String pin){

        //sheck the userID is correct
        for(User user : this.users){
            if(user.getUUID().compareTo(userID) == 0 & user.validatePin(pin)){
                return user;
            }
        }

        //if we haven`t found user or pin is incorrect
        return null;
    }
}
