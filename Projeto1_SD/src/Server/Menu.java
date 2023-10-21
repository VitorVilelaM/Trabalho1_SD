package Server;

import Data.Input;
import Data.Output;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class Menu extends Thread {

    private Output outClient;
    private Input inpClient;
    private Connections server;
    boolean fimOP = true;
    private String msg;

    public Menu(Input inp, Output out, Connections ser) {
        this.outClient = out;
        this.inpClient = inp;
        this.server = ser;
    }

    public void run() {
        outClient.setMsg("--- MENU --- \n 1- Ver pessoas online \n 2 - \n 3 - Sair ");
        outClient.send();

        while (true) {
            msg = inpClient.getMsg();
            if (msg.equals("1")) {
                System.out.println("Cliente: " + msg);
                inpClient.setMsg("");
                returnUsers();
            } else if (msg.equals("2")) {
            } else if (msg.equals("3")) {
            }
        }

    }

    public void returnUsers() {
        String users = "";

        for (Users user : server.getUsers()) {
            users += user.getName() + "\n";
        }

        outClient.setMsg("--- Usuários online ---" + "\n" + users);
        outClient.send();

        outClient.setMsg("Informe o nome de quem deseja conversar ou entao 'sair' para sair desse menu: " + users);
        outClient.send();
        
        while (!(inpClient.getMsg().isEmpty())) {
            String name = inpClient.getMsg();
            System.out.println(name);
        }
    }
}
