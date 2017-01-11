package net.mrdoc.revloapi;

import net.mrdoc.revloapi.exception.RevloException;

/**
 * Created by Doc on 10-01-2017.
 * This class is based in BuyCraftAPI from hugmanrique
 * @author Doc
 */
public class RevloAPI {

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




}
