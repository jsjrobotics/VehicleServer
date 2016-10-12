package com.spookyrobotics;

import com.spookyrobotics.server.UrlConstants;
import com.spookyrobotics.context.Status;
import com.spookyrobotics.context.effectors.Effectors;
import com.spookyrobotics.context.sensors.Sensors;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class Context {
    private Sensors mSensors = new Sensors();
    private Effectors mEffectors = new Effectors();
    private Status mStatus = new Status();

    public void setup(int pin) {
        File sysPin = new File("/sys/class/gpio/gpio" + String.valueOf(pin) + "/value");
        if (!sysPin.exists()){
            if (execute(exportStringCommand(pin))) {
                if (execute(setOutputCommand(pin))) {
                    execute(setHighCommand(pin));
                }
            }
        }
    }

    public boolean execute(String command) {
        try {
            Runtime.getRuntime().exec(command);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String exportStringCommand(int pin){
        return "echo \"" + String.valueOf(pin) + "\" > /sys/class/gpio/export;";
    }

    public String setOutputCommand(int pin){
        return "echo \"out\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/direction";
    }

    public String setHighCommand(int pin){
        return  "echo \"1\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/value;";
    }

    public String setLowCommand(int pin){
        return  "echo \"0\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/value;";
    }

    public String toJson() {
        JSONObject result = new JSONObject();
        try {
            result.put(UrlConstants.STATUS, mStatus.toJson());
            result.put(UrlConstants.EFFECTORS, mEffectors.toJson());
            result.put(UrlConstants.SENSORS, mSensors.toJson());
            return result.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
