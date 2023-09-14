package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Connections extends Thread {

    private ArrayList<Socket> users = new ArrayList<>();

    public ArrayList<Socket> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Socket> users) {
        this.users = users;
    }

    public void startConnection(ServerSocket servidor) {
        while (true) {
            try {
                Socket conexao = servidor.accept();
                users.add(conexao);

            } catch (IOException ex) {
                System.out.println("Nao foi possivel estabelecer conexão!");
            }
        }
    }
}
