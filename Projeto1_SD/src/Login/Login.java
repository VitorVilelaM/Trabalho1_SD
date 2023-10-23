package Login;

import Data.Input;
import Data.Output;
import Server.Connections;
import Server.Users;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */
public class Login {

    public Login() {
    }

    private static boolean login = true;

    public static boolean Client(Socket conexaoS) throws IOException {

        Output outClient = new Output(conexaoS);
        Input inpClient = new Input(conexaoS);

        outClient.OutputLoginClient();
        System.out.println(inpClient.InputLogin());

        return login;
    }

    public static Users Server(Socket conexaoC, Connections server) throws IOException {
        Input inpServer = new Input(conexaoC);
        Output outServer = new Output(conexaoC);

        boolean user = true;

        String nameL = inpServer.InputLogin();
        Users newUser = null;

        for (Users usr : server.getUsers()) {
            if (usr.getName().equals(nameL)) {
                user = false;
                newUser = null;
                outServer.OutputLoginServer("Usuario ja existente!");
                login = true;
            }
        }

        if (user) {
            newUser = new Users(nameL, conexaoC);
            outServer.OutputLoginServer("Sucesso no login!");
            login = false;
        }

        return newUser;
    }
}
