package net.mrdoc.revloapi;

import net.mrdoc.revloapi.classes.Reward;
import net.mrdoc.revloapi.exception.RevloException;
import net.mrdoc.revloapi.utils.RevloUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Doc on 10-01-2017.
 * This class is based in BuyCraftAPI from hugmanrique
 * @author Doc
 */
public class RevloAPI {

    final private static String BASEURL = "https://api.revlo.co/1/";

    final private static DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    private final String URL = "";
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
     * Get all rewards avaible in you account
     * @return Return a Set of Reward
     * @throws RevloException Error in conecction or Error of APIKey
     */
    public Set<Reward> getRewards() throws RevloException {

        Set<Reward> rewards = new HashSet<Reward>();

        JSONObject jsonResponse = RevloUtils.generateRequestJSON(RevloAPI.BASEURL,"rewards",Core.getAPIKEY());

        int cant = jsonResponse.getInt("total"); //get total data

        if(cant == 0) { //if total elements return 0 then return the empty set
            return rewards;
        }

        JSONArray jsonRewards = jsonResponse.getJSONArray("rewards"); //get array of elements

        for(int pos = 0; pos < cant; pos++) {
            JSONObject jsonReward = jsonRewards.getJSONObject(pos);

            Reward reward = new Reward(jsonReward.getInt("reward_id"),
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




}
