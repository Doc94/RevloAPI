package net.mrdoc.revloapi;

import net.mrdoc.revloapi.exception.RevloException;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class TestRevlo {

    /**
     * TEST API
     * @param args not used ;3
     */
    public static void main(String[] args) {
        try {
            RevloAPI api = new RevloAPI("MySweetAPIKey");
            //api.getRewards();
            //api.getRedemptions();
            api.setDEBUGMODE(true);
            api.getFan("thedoc94s");
            api.giveBonus("thedoc94s",1000);
            //api.getFan("nullsupernull");
        } catch (RevloException e) {
            e.printStackTrace();
        }
    }

}
