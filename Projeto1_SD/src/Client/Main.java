package Client;

import Data.Input;
import Data.Output;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Connection connection = new Connection();
        Socket conexao = connection.ConnectionServer();

        Output outServer = new Output(conexao);
        Input inpServer = new Input(conexao);

        inpServer.start();
        outServer.start();

        while (true) {
        }
    }

}
