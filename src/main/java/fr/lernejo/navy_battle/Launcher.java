package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Launcher {

    public static void main(String[] args) {
        int port = 8080; //default value
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number, defaulting to 8080");
                port = 8080;
            }
        }
        try {
            //create the server
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            //define the context paths and the associated handlers
            server.createContext("/", new RootHandler());
            server.createContext("/play", new PlayHandler());
            server.createContext("/placeShip", new PlaceShipHandler());
            server.createContext("/attack", new AttackHandler());
            server.createContext("/board", new BoardHandler());
            //start the server
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("Server running on port " + port);
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

