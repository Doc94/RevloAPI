package net.mrdoc.revloapi.classes;

import java.util.Date;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Reward {
    final private int REWARD_ID;

    final private String TITLE;
    final private String REWARD_DESCRIPTION;
    final private String IMG_URL;

    final private String BOT_COMMAND;

    final private Date CREATED_AT;

    final private int POINTS;

    final private boolean ENABLED;

    final private boolean SUB_ONLY;

    /**
     * Create a reward item
     * @param id Unique ID for the reward
     * @param title Title of the reward
     * @param description Description of the reward
     * @param imgurl Image URL of the reward
     * @param botcommand CustomCommand to execute in this reward
     * @param createdat Create Date from the reward
     * @param points Cost of the reward
     * @param enabled Status of the reward
     * @param subonly This item is Only-Sub?
     */
    public Reward(int id, String title, String description, String imgurl, String botcommand, Date createdat, int points, boolean enabled, boolean subonly) {
        this.REWARD_ID = id;
        this.TITLE = title;
        this.REWARD_DESCRIPTION = description;
        this.IMG_URL = imgurl;
        this.BOT_COMMAND = botcommand;
        this.CREATED_AT = createdat;
        this.POINTS = points;
        this.ENABLED = enabled;
        this.SUB_ONLY = subonly;
    }

    /**
     * Get the ID from the reward
     * @return Integer ID from the reward
     */
    public int getID() {
        return REWARD_ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getDESCRIPTION() {
        return REWARD_DESCRIPTION;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public String getBOT_COMMAND() {
        return BOT_COMMAND;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public int getPOINTS() {
        return POINTS;
    }

    public boolean isENABLED() {
        return ENABLED;
    }

    public boolean isSUB_ONLY() {
        return SUB_ONLY;
    }
}
