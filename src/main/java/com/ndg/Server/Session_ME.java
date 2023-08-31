package com.ndg.Server;

import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Session_ME {
    protected int id;
    protected Socket socket;
    protected DataOutputStream dataOutputStream;
    protected DataInputStream dataInputStream;
    protected static ArrayList<Session_ME> sessions;

    static {
        sessions = new ArrayList<>();
    }

    public Session_ME(@NotNull Socket socket, final int id) throws Exception {
        this.id = id;
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public static void joinServer(final Session_ME session) {
        if (!Session_ME.sessions.contains(session)) {
            Session_ME.sessions.add(session);
        }
    }
}
