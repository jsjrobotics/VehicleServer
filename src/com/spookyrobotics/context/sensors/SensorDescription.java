package com.spookyrobotics.context.sensors;

import com.spookyrobotics.server.UrlConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorDescription {

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        try {
            result.put(UrlConstants.NAME, "defaultSensor");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
