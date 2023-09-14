package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */

public class Connections extends Thread {

    private ServerSocket servidor;
    private ArrayList<Users> users = new ArrayList<>();
    private String login = "";
    
    
    @Override
    public void run() {
        while (true) {
            Socket conexao;
            try {
                conexao = servidor.accept();
                Users newUser = new Users(login, conexao);
                users.add(newUser);
                System.out.println("Conectado");
            } catch (IOException ex) {
                System.out.println("Erro na conexão!");
            }
        }

    }
    
    public void setLogin(String name){
        this.login = name;
    }
    
    public ArrayList<Users> getUsers() {
        return users;
    }

    public Connections() throws IOException {
        this.servidor = new ServerSocket(1234); 
    }
    
    public void showUsers(){
        for(Users user : users){
            System.out.println(user.getName());
        }
        System.out.println("");
    }
}
