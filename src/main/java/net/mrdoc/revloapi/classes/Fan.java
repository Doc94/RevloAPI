package net.mrdoc.revloapi.classes;

import java.util.Date;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Fan { //{"loyalty":{"fan":"pokemaniac","total_points":0,"current_points":100,"updated_at":"2016-09-14T16:02:00.000Z"}}

    final private String NAME;
    final private int TOTAL_POINTS;
    final private int CURRENT_POINTS;
    final private Date UPDATED_AT;

    public Fan(String name, int totalpoints, int currentpoints, Date updateat) {
        this.NAME = name;
        this.TOTAL_POINTS = totalpoints;
        this.CURRENT_POINTS = currentpoints;
        this.UPDATED_AT = updateat;
    }


    public String getNAME() {
        return NAME;
    }

    public int getTOTAL_POINTS() {
        return TOTAL_POINTS;
    }

    public int getCURRENT_POINTS() {
        return CURRENT_POINTS;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }
}
