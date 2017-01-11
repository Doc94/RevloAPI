package net.mrdoc.revloapi.classes;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class Fan {

    final private String NAME;
    final private int TOTAL_POINTS;
    final private int CURRENT_POINTS;
    final private LocalDateTime UPDATED_AT;

    public Fan(String name, int totalpoints, int currentpoints, LocalDateTime updateat) {
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

    public LocalDateTime getUPDATED_AT() {
        return UPDATED_AT;
    }
}
