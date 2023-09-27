package Login;

import Data.Input;
import Data.Output;
import Server.Users;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Login {

    public Login() {
    }
    
    // Transformar em Threads

    public static void Client(Socket conexaoS) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        Output outClient = new Output(conexaoS);
        Input inpClient = new Input(conexaoS);
        
        outClient.OutputLoginClient();
        System.out.println(inpClient.InputLogin());
    }

    public static Users Server(Socket conexaoC) throws IOException {
        Input inpServer = new Input(conexaoC);
        Output outServer = new Output(conexaoC);
        
        String nameL = inpServer.InputLogin();
        Users newUser = new Users(nameL, conexaoC);
        
        outServer.OutputLoginServer();
        return newUser;
    }
}
