package com.spookyrobotics;

import com.spookyrobotics.server.VehicleServer;
import org.eclipse.jetty.server.Server;

public class Main {

    public static void main(String[] args) throws Exception {
        Context context = new Context();

        if (true){
            System.out.println(context.toJson());
            return;
        }
        context.setup(2);
        context.setup(3);
        Server server = new Server(9000);
        server.setHandler(new VehicleServer(context));

        server.start();
        server.join();
    }


};
