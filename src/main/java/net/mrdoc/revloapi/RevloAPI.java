package net.mrdoc.revloapi;

import net.mrdoc.revloapi.classes.Fan;
import net.mrdoc.revloapi.classes.Redemption;
import net.mrdoc.revloapi.classes.Reward;
import net.mrdoc.revloapi.exception.RevloException;
import net.mrdoc.revloapi.utils.RevloUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Doc on 10-01-2017.
 * This class is based in BuyCraftAPI from hugmanrique
 * @author Doc
 */
public class RevloAPI {

    final private static String BASEURL = "https://api.revlo.co/1/";

    final private static DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    private boolean DEBUGMODE = false;

    private final String KEY;

    /**
     * Create the instance for the REVLO API
     * @param key Revlo KEY (You can get this in https://www.revlo.co/settings/api )
     * @throws RevloException if the API key is not valid
     */
    public RevloAPI(String key) throws RevloException {
        if(key == null) {
            throw new RevloException("The API Key is not valid");
        } else if(key.length() == 0) {
            throw new RevloException("The API Key its empty");
        }
        KEY = key;
    }

    /**
     * Set DEBUGMODE in this instance
     * <br>
     * Default is set in FALSE
     * @param debug enabled or disables DEBUGMODE
     */
    public void setDEBUGMODE(boolean debug) {
        this.DEBUGMODE = debug;
    }

    /**
     * Get all rewards avaible in you account
     * @return Return a Set of Reward
     * @throws RevloException Error in conecction or Error of APIKey
     */
    public Set<Reward> getRewards() throws RevloException {
        Set<Reward> rewards = new HashSet<Reward>();

        JSONObject jsonResponse = RevloUtils.GETRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"rewards",KEY);

        int cantPages = jsonResponse.getInt("page_size"); //get total data

        System.out.println("PAGES = " + cantPages);

        for(int pos = 1; pos <= cantPages; pos++) {
            Set<Reward> pageRewards = getRewards(pos);
            if(pageRewards.isEmpty()) {
                return rewards;
            }
            rewards.addAll(getRewards(pos));
        }

        return rewards;
    }

    /**
     * Get all rewards avaible in you account
     * @param page Page to read items
     * @return Return a Set of Reward
     * @throws RevloException Error in conecction or Error of APIKey
     */
    public Set<Reward> getRewards(int page) throws RevloException {

        if(page == 0) {
            page = 1;
        }

        Set<Reward> rewards = new HashSet<Reward>();

        JSONObject jsonResponse = RevloUtils.GETRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"rewards?page="+page,KEY);

        int cant = jsonResponse.getInt("total"); //get total data

        if(cant == 0) { //if total elements return 0 then return the empty set
            return rewards;
        }

        JSONArray jsonRewards = jsonResponse.getJSONArray("rewards"); //get array of elements

        if(jsonRewards.length() == 0) {
            return rewards;
        }

        for(int pos = 0; pos < cant; pos++) {
            JSONObject jsonReward = jsonRewards.getJSONObject(pos);

            Reward reward = new Reward(
                    jsonReward.getInt("reward_id"),
                    jsonReward.getString("title"),
                    jsonReward.getString("description"),
                    jsonReward.getString("img_url"),
                    jsonReward.getString("bot_command"),
                    LocalDateTime.parse(jsonReward.getString("created_at"), DATEFORMATTER),
                    jsonReward.getInt("points"),
                    jsonReward.getBoolean("enabled"),
                    jsonReward.getBoolean("sub_only")
            );

            rewards.add(reward);
        }

        return rewards;
    }

    /**
     * Get all Redemptions avaible in you account
     * @return Return a Set of Redemptions
     * @throws RevloException Error in conecction or Error of APIKey
     */
    public Set<Redemption> getRedemptions() throws RevloException {
        Set<Redemption> redemptions = new HashSet<Redemption>();

        JSONObject jsonResponse = RevloUtils.GETRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"redemptions",KEY);

        int cantPages = jsonResponse.getInt("page_size"); //get total data

        for(int pos = 1; pos <= cantPages; pos++) {
            Set<Redemption> pageRedemptions = getRedemptions(pos);
            if(pageRedemptions.isEmpty()) {
                return redemptions;
            }
            redemptions.addAll(getRedemptions(pos));
        }

        return redemptions;
    }

    /**
     * Get all Redemptions avaible in you account
     * @param page Page to rad contend
     * @return Return a Set of Redemptions
     * @throws RevloException Error in conecction or Error of APIKey
     */
    public Set<Redemption> getRedemptions(int page) throws RevloException {

        Set<Redemption> redemptions = new HashSet<Redemption>();

        JSONObject jsonResponse = RevloUtils.GETRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"redemptions?page="+page,KEY);

        int cant = jsonResponse.getInt("total"); //get total data

        if(cant == 0) { //if total elements return 0 then return the empty set
            return redemptions;
        }

        JSONArray jsonRedemptions = jsonResponse.getJSONArray("redemptions"); //get array of elements

        if(jsonRedemptions.length() == 0) {
            return redemptions;
        }

        for(int pos = 0; pos < cant; pos++) {
            JSONObject jsonRedemption = jsonRedemptions.getJSONObject(pos);

            Reward rewardToRedemp = null;

            for(Reward reward : getRewards()) {
                if(reward.getID() == jsonRedemption.getInt("reward_id")) {
                    rewardToRedemp = reward;
                    break;
                }
            }

            HashMap<String,String> redemptionInputs = new HashMap<>();

            JSONObject jsonArrayInputs = jsonRedemption.getJSONObject("user_input");

            for(String keyInput : jsonArrayInputs.keySet()) {
                redemptionInputs.put(keyInput,jsonArrayInputs.getString(keyInput));
            }

            Redemption redemption = new Redemption(
                    rewardToRedemp,
                    jsonRedemption.getInt("redemption_id"),
                    LocalDateTime.parse(jsonRedemption.getString("created_at"), DATEFORMATTER),
                    jsonRedemption.getString("username"),
                    redemptionInputs,
                    jsonRedemption.getBoolean("refunded"),
                    jsonRedemption.getBoolean("completed")
            );

            System.out.println("DEBUG REMP: " + redemption.getUSERNAME());

            redemptions.add(redemption);
        }

        return redemptions;
    }

    /**
     * Get a fan for your revlo
     * @param twitchname Username for the fan
     * @return Fan Class
     * @throws RevloException If the connection is failed or username is invalid
     */
    public Fan getFan(String twitchname) throws RevloException{
        JSONObject jsonResponse = RevloUtils.GETRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"fans/"+twitchname+"/points",KEY);

        JSONObject jsonFan = jsonResponse.getJSONObject("loyalty");

        Fan fan = new Fan(
                jsonFan.getString("fan"),
                jsonFan.getInt("total_points"),
                jsonFan.getInt("current_points"),
                LocalDateTime.parse(jsonFan.getString("updated_at"), DATEFORMATTER)
        );

        System.out.println("CURRENT: " + fan.getCURRENT_POINTS());

        return fan;

    }

    /**
     * Give a bonus to a Fan
     * @param twichname username of the fan to give the bonus
     * @param amount amount of the bonus (between -1000000 and 1000000)
     * @throws RevloException If the connection is failed or amount is invalid
     */
    public Fan giveBonus(String twichname,int amount) throws RevloException{
        if(amount == 0 || amount < -1000000 || amount > 1000000) {
            throw new RevloException("Failed: The amount valid for a bonis is between -1000000 and 1000000 (Zero is a not valid amount)");
        }

        JSONObject bonusParameters = new JSONObject();
        bonusParameters.put("amount",amount);

        JSONObject jsonResponse = RevloUtils.POSTRequestJSON(DEBUGMODE,RevloAPI.BASEURL,"fans/"+twichname+"",bonusParameters,KEY);

        JSONObject jsonFan = jsonResponse.getJSONObject("loyalty");

        Fan fan = new Fan(
                jsonFan.getString("fan"),
                jsonFan.getInt("total_points"),
                jsonFan.getInt("current_points"),
                LocalDateTime.parse(jsonFan.getString("updated_at"), DATEFORMATTER)
        );

        System.out.println("CURRENT: " + fan.getCURRENT_POINTS());

        return fan;

    }


}
