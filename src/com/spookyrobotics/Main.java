package com.spookyrobotics;

import org.eclipse.jetty.server.Server;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        server.setHandler(new VehicleServer());

        server.start();
        server.join();
    }
}
