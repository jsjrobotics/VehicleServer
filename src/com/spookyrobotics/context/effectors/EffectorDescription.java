package com.spookyrobotics.context.effectors;

import com.spookyrobotics.server.UrlConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectorDescription {
    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        try {
            result.put(UrlConstants.NAME, "defaultEffector");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
