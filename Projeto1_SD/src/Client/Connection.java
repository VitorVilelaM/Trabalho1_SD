package Client;

import Login.Login;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Connection {

    public Connection() {
    }

    public Socket ConnectionServer() {
        int porta = 1234;
        String ip = "localhost";

        Scanner sc = new Scanner(System.in);
        Socket conexao = null;
        try {
            conexao = new Socket(ip, porta);
            Login.Client(conexao);
        } catch (Exception e) {
            System.out.println("Servidor nao esta no ar...");
        }

        return conexao;
    }
}
