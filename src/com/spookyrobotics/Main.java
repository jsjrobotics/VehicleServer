package com.spookyrobotics;

import org.eclipse.jetty.server.Server;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        setup(2);
        setup(3);
        Server server = new Server(9000);
        server.setHandler(new VehicleServer());

        server.start();
        server.join();
    }

    private static void setup(int pin) {
        File sysPin = new File("/sys/class/gpio/gpio" + String.valueOf(pin) + "/value");
        if (!sysPin.exists()){
            if (execute(exportStringCommand(pin))) {
                if (execute(setOutputCommand(pin))) {
                    execute(setHighCommand(pin));
                }
            }
        }
    }

    private static boolean execute(String command) {
        try {
            Runtime.getRuntime().exec(command);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String exportStringCommand(int pin){
        return "echo \"" + String.valueOf(pin) + "\" > /sys/class/gpio/export;";
    }

    private static String setOutputCommand(int pin){
        return "echo \"out\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/direction";
    }

    private static String setHighCommand(int pin){
        return  "echo \"1\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/value;";
    }

    private static String setLowCommand(int pin){
        return  "echo \"0\" > /sys/class/gpio/gpio" + String.valueOf(pin) + "/value;";
    }
};
