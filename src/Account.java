import java.util.ArrayList;

public class Account {

    /*
    The name of the account
     */
    private String name;

    /**
    The current balance of the account
     */
    private double balance;

    /**
    The account ID numder
     */
    private String uuid;

    /**
    The User object that owns this account
     */
    private User holder;

    /**
    The list of transactions for this account
     */
    private ArrayList<Transaction> transactions;

    /**
     *Create a new account
     * @param name the name for the account
     * @param holder the User object that holds this account
     * @param theBank the bank that issues the account
     */
    public Account(String name  , User holder , Bank theBank){

        //set the account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //init transactions
        this.transactions = new ArrayList<Transaction>();

        //add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);

    }

    /**
     * Return the account UUID
     * @return the uuid
     */
    public String getUUID() {
        return uuid;
    }
}
