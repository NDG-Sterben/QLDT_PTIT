package com.ndg.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private static int id;
    private static boolean start;
    private static ServerSocket server;
    private static Server instance;

    protected Server() {
        start = true;
    }

    protected static Server getInstance() {
        if (Server.instance == null) {
            Server.instance = new Server();
        }
        return Server.instance;
    }

    public static void start(final int post) {
        System.out.println("Start socket post = " + post);
        try {
            Server.server = new ServerSocket(post);
            Server.id = 0;
            Server.start = true;
            getInstance().start();
            System.out.println("Start server Success!");
            while (Server.start) {
                try {
                    final Socket client = Server.server.accept();
                    final Session_ME conn = new Session_ME(client, Server.id++);
                    System.out.println("Client: " + conn.socket.getInetAddress().getHostAddress() + " id: "
                            + conn.id);
                    Session_ME.joinServer(conn);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Close server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
