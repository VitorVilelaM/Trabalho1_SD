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

    public static void Client(Socket conexaoS) throws IOException {
        Scanner sc = new Scanner(System.in);
        Output out = new Output(conexaoS);

        System.out.print("Informe seu nome para Login: ");
        out.OutputLogin();
    }

    public static Users Server(Socket conexaoC) throws IOException {
        Input inp = new Input(conexaoC);
        String nameL = inp.InputLogin();

        Users newUser = new Users(nameL, conexaoC);
        return newUser;
    }
}
