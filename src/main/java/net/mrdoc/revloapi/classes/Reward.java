package net.mrdoc.revloapi.classes;

import java.time.LocalDateTime;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Reward {
    final private int REWARD_ID;

    final private String REWARD_TITLE;
    final private String REWARD_DESCRIPTION;
    final private String IMG_URL;

    final private String BOT_COMMAND;

    final private LocalDateTime CREATED_AT;

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
    public Reward(int id, String title, String description, String imgurl, String botcommand, LocalDateTime createdat, int points, boolean enabled, boolean subonly) {
        this.REWARD_ID = id;
        this.REWARD_TITLE = title;
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

    /**
     * Get the title of the Reward
     * @return String with the title
     */
    public String getTITLE() {
        return REWARD_TITLE;
    }

    /**
     * Get the description of the Reward
     * @return String with description
     */
    public String getDESCRIPTION() {
        return REWARD_DESCRIPTION;
    }

    /**
     * Get the URL of the image/icon to display for this Reward
     * @return String with url of the image
     */
    public String getIMG_URL() {
        return IMG_URL;
    }

    /**
     * Get the command alias to be execute when this a user use the Reward
     * @return String with command
     */
    public String getBOT_COMMAND() {
        return BOT_COMMAND;
    }

    /**
     * Get the time when the Reward has been created
     * @return LocalDateTime with values
     */
    public LocalDateTime getCREATED_AT() {
        return CREATED_AT;
    }

    /**
     * Get the cost of this Reward
     * @return Integer with the cost
     */
    public int getPOINTS() {
        return POINTS;
    }

    /**
     * Get if this Reward is inabled
     * @return TRUE if this Reward is enabled or FALSE if not enabled
     */
    public boolean isENABLED() {
        return ENABLED;
    }

    /**
     * Get if this Reward is Only For Subs (Twitch Partner)
     * @return TRUE if this Reward is only for subs or FALSE if is for everyone
     */
    public boolean isSUB_ONLY() {
        return SUB_ONLY;
    }
}
