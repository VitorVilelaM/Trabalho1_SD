package Client;

import Login.Login;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author vitor
 */
public class Connection {

    public Connection(){}

    public void ConnectionServer() {
        int porta = 1234;
        String ip = "localhost";

        Scanner sc = new Scanner(System.in);

        try {
            Socket conexao = new Socket(ip, porta);
            Login.Client(conexao);
            System.out.println("Voltei");
            
        } catch (Exception e) {
            System.out.println("Servidor nao esta no ar...");
        }
    }
}
