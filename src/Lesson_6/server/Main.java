package Lesson_6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    private final Vector<ClientHandler> clients;

    public Main() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                synchronized (clients) {
                    clients.add(new ClientHandler(socket, this, clients.size()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public boolean removeClient(int id) {
        synchronized (clients) {
            try {
                clients.remove(id);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }
        System.out.println("Клиент отключился.");
        return true;
    }
}
