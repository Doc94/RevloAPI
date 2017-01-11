package net.mrdoc.revloapi;

import net.mrdoc.revloapi.exception.RevloException;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Core {

    private static String APIKEY = "kTJSQMjs3R3kh3CIRZirIe89CfwbEAPHtcD_eO56LONw";

    /**
     * TEST API
     * @param args not used ;3
     */
    public static void main(String[] args) {
        try {
            RevloAPI api = new RevloAPI(getAPIKEY());
            //api.getRewards();
            //api.getRedemptions();
            api.setDEBUGMODE(true);
            api.getFan("thedoc94");
            api.giveBonus("thedoc94",1000);
            //api.getFan("nullsupernull");
        } catch (RevloException e) {
            e.printStackTrace();
        }
    }

    public static void setAPIKEY(String key) {
        APIKEY = key;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

}
