import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    /**
    The first name of the user
     */
    private String firstname;

    /**
    The last name of the user
     */
    private String lastname;

    /**
    The ID number of the user
     */
    private String uuid;

    /**
    The MD5 hash of the user`s pin number
     */
    private byte pinHash[];

    /**
    The list of accounts for this user
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstname the user`s firstname
     * @param lastname the user`s lastname
     * @param pin the user`s account pin number
     * @param theBank the Bank object that the user is customer of
     */
    public User(String firstname , String lastname , String pin , Bank theBank){

        //set user`s name
        this.firstname = firstname;
        this.lastname = lastname;

        //store the pin MD5 hash , rather than an original value
        // for seciurity
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }catch(NoSuchAlgorithmException e){
            System.out.println("ERROR: NoSuchAlgotithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a mew , unique universal ID for the user
        this.uuid = theBank.getNewUserUUID();

        //create empty list for accounts
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.printf("New user %s %s with ID %s was created!\n" ,firstname ,lastname ,uuid);


    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     * Return the user`s UUID
     * @return the uuid
     */
    public String getUUID() {
        return uuid;
    }
}
