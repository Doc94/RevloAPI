package net.mrdoc.revloapi.classes;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Created by Doc on 11-01-2017.
 *
 * @author Doc
 */
public class Redemption {

    final private Reward REWARD;
    final private int REDEMPTION_ID;
    final private LocalDateTime CREATED_AT;
    final private boolean REFUNDED;
    final private boolean COMPLETED;
    final private HashMap<String,String> USERINPUT; //WIP
    final private String USERNAME;

    public Redemption(Reward reward, int id, LocalDateTime createdat, String username, HashMap<String,String> userinputs, boolean refunded, boolean completed) {
        this.REWARD = reward;
        this.REDEMPTION_ID = id;
        this.CREATED_AT = createdat;
        this.USERINPUT = userinputs;
        this.USERNAME = username;
        this.REFUNDED = refunded;
        this.COMPLETED = completed;
    }


    /**
     * Get the reward class for this Redemtion
     * @return Return a reward class
     */
    public Reward getREWARD() {
        return REWARD;
    }

    /**
     * Get the ID for the redemption
     * @return Return a int with the ID
     */
    public int getREDEMPTION_ID() {
        return REDEMPTION_ID;
    }

    /**
     * Get the time when created the redemption
     * @return Return a LocalDateTime with the time
     */
    public LocalDateTime getCREATED_AT() {
        return CREATED_AT;
    }

    /**
     * Get if the redemption has been refunded
     * @return Return TRUE if the redemption has been refunded or FALSE if the redemption not has been refunded
     */
    public boolean isREFUNDED() {
        return REFUNDED;
    }

    /**
     * Get if the redemption has been completed
     * <br>
     * Completed: The redemption has checkout and not posible effect refund
     * @return Return a boolean if the item has been completed
     */
    public boolean isCOMPLETED() {
        return COMPLETED;
    }

    /**
     * Get the inputs for user
     * <br>
     * Key is a type of input and Valiue is a value for input
     * @return HashMap with inputs
     */
    public HashMap<String, String> getUSERINPUTS() {
        return USERINPUT;
    }

    /**
     * Get the username of the member what this redemption
     * <br>
     * The username is the twitchname/twitchusername
     * @return Return a string with the username
     */
    public String getUSERNAME() {
        return USERNAME;
    }
}
