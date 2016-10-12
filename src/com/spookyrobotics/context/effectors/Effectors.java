package com.spookyrobotics.context.effectors;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Effectors {
    private List<EffectorDescription> effectors = new ArrayList();

    public void add(EffectorDescription e){
        effectors.add(e);
    }

    public JSONArray toJson(){
        JSONArray sensorJson = new JSONArray();
        for (EffectorDescription e : effectors){
            sensorJson.put(e.toJson());
        }
        return sensorJson;
    }
}
