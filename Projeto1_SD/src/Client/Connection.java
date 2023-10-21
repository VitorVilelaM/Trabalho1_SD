package Client;

import Data.Input;
import Data.Output;
import Login.Login;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class Connection extends Thread {

    private Socket conexao = null;

    public Connection() {
    }

    public Socket ConnectionServer() {
        int porta = 1234;
        String ip = "localhost";

        Scanner sc = new Scanner(System.in);

        try {
            this.conexao = new Socket(ip, porta);
            Login.Client(conexao);

        } catch (Exception e) {
            System.out.println("Servidor nao esta no ar...");
        }

        return conexao;
    }

    @Override
    public void run() {
         
        try {
            Output outServer = new Output(conexao);
            Input inpServer = new Input(conexao);

            inpServer.start();
            outServer.start();

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
