package com.spookyrobotics.context;

import com.spookyrobotics.server.UrlConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class Status {
    private String mName = "DefaultName";
    public JSONObject toJson(){
        JSONObject result = new JSONObject();
        try {
            result.put(UrlConstants.NAME, mName);
            result.put(UrlConstants.BATTERY_PERCENTAGE, "100");
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
