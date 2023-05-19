import java.util.ArrayList;

public class User {

    /*
    The first name of the user
     */
    private String firstname;

    /*
    The last name of the user
     */
    private String lastname;

    /*
    The ID number of the user
     */
    private String uuid;

    /*
    The MD5 hash of the user`s pin number
     */
    private byte pinHash[];

    /*
    The list of accounts for this user
     */
    private ArrayList<Account> accounts;


}
