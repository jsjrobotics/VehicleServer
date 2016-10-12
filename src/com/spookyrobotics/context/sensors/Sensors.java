package com.spookyrobotics.context.sensors;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Sensors {
    private List<SensorDescription> sensors = new ArrayList();

    public void add(SensorDescription s){
        sensors.add(s);
    }

    public JSONArray toJson(){
        JSONArray sensorJson = new JSONArray();
        for (SensorDescription s : sensors){
            sensorJson.put(s.toJson());
        }
        return sensorJson;
    }
}
