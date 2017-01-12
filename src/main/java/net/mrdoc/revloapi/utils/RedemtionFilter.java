package net.mrdoc.revloapi.utils;

/**
 * Created by Doc on 12-01-2017.
 *
 * @author Doc
 */
public enum RedemtionFilter {

    /**
     * No Filter
     */
    NONE(""),
    /**
     * Redemtions Completed
     */
    COMPLETED("&completed=true"),
    /**
     * Redemtions no completed
     */
    INCOMPLETED("&completed=false"),
    /**
     * Redemtions refunded
     */
    REFUNDED("&refunded=true"),
    /**
     * Redemtions no refunded
     */
    NOREFUNDED("&refunded=false"),
    ;

    final private String PARAMETER;

    RedemtionFilter(String urlparam) {
        PARAMETER = urlparam;
    }

    /**
     * Get the extra param to url
     * @return String with param
     */
    public String getPARAMETER() { return PARAMETER; }
}
