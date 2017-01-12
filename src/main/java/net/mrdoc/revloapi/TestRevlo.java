package net.mrdoc.revloapi;

import net.mrdoc.revloapi.classes.Reward;
import net.mrdoc.revloapi.exception.RevloException;

import java.util.ArrayList;
import java.util.Set;

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
            Set<Reward> setRewards = api.getRewards();

            //Pass to List for use (or you can use the Set class and use the stream())
            ArrayList<Reward> rewards = new ArrayList<>(setRewards);

            if(!rewards.isEmpty()) { //you can get a empty list
                Reward reward = rewards.get(0); //get the first element
                System.out.println("==== REWARD INFO =====");
                System.out.println("Title: " + reward.getTITLE());
                System.out.println("Description: " + reward.getDESCRIPTION());
                System.out.println("URL IMG: " + reward.getIMG_URL());
                System.out.println("ID: " + reward.getID());
                System.out.println("Created at: " + reward.getCREATED_AT().toString());
                System.out.println("BOT Command: " + reward.getBOT_COMMAND());
                System.out.println("Cost: " + reward.getPOINTS());

            }

        } catch (RevloException e) {
            e.printStackTrace();
        }
    }

}
