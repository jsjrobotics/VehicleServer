package com.spookyrobotics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class VehicleServer extends AbstractHandler
{
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
            ServletException
    {

        String query = request.getQueryString();
        String result = "<h1>Unrecognized</h1>";
        if (query.toLowerCase().contains("forwards")){
            Runtime.getRuntime().exec("/usr/bin/perl /home/pi/bin/drive.pl f");
            result = "<h1>Forwards</h1>";
        } else if (query.toLowerCase().contains("backwards")){
            Runtime.getRuntime().exec("/usr/bin/perl /home/pi/bin/drive.pl b");
            result = "<h1>Backwards</h1>";
        } else if (query.toLowerCase().contains("stop")){
            Runtime.getRuntime().exec("/usr/bin/perl /home/pi/bin/drive.pl s");
            result = "<h1>Stop</h1>";
        }
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write back response
        response.getWriter().println(result);

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

}