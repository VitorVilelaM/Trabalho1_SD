package Server;

import Data.Input;
import Data.Output;
import Login.Login;
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

    @Override
    public void run() {
        while (true) {
            Socket conexao;
            try {
                conexao = servidor.accept();
                Users newUser = Login.Server(conexao);

                users.add(newUser);
                System.out.println(newUser.getName() + " " + "Conectado" + " - Porta: " + conexao.getPort());
                listenUser(newUser);
                
            } catch (IOException ex) {
                System.out.println("Erro na conexão!");
                break;
            }
        }

    }
    
    private void listenUser(Users user) throws IOException {
        
       Menu menu = new Menu(user,this);
       menu.start();
    }
    
    public ArrayList<Users> getUsers() {
        return users;
    }

    public Connections() throws IOException {
        this.servidor = new ServerSocket(1234);
    }
}
