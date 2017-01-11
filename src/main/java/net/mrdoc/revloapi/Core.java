package net.mrdoc.revloapi;

import net.mrdoc.revloapi.exception.RevloException;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Core extends API {

    private static String APIKEY = "TgLgg09RRIsgQIFmklnWmyJJ2QjZc9SWPtVHwHrjBXY";

    public static void main(String[] args) {
        try {
            RevloAPI api = new RevloAPI(getAPIKEY());
            api.getRewards();
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
