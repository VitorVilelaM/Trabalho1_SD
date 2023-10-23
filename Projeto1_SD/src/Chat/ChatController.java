package Chat;

import Server.Connections;
import Server.Menu;
import Server.Users;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class ChatController extends Thread {

    private String msgSend, msgReceive, chat = "";
    private Users usr1, usr2;
    private boolean repeat = true;
    private Scanner sc = new Scanner(System.in);
    private Menu menu;
    private Connections server;
    
    
    public ChatController(Users sender, Users receiver, Connections ser) {
        this.usr1 = sender;
        this.usr2 = receiver;
        this.server = ser;
    }

    @Override
    public void run() {
        while (this.repeat) {
            try {
                send();
            } catch (Exception ex) {
                break;
            }
        }
    }

    public void send() throws IOException {
        msgSend = usr1.getInput().getMsg();

        if (!(msgSend.isEmpty())) {

            if (msgSend.equals("MENU")) {
                this.repeat = false;
                menu = new Menu(usr1, server);
                menu.start();
            } else {
                chat += usr1.getName() + ": " + msgSend + "\n";
                usr2.getOutput().setMsg(chat);
                usr2.getOutput().send();
            }

            usr1.getInput().setMsg("");
        }
    }

    public void receive() {
    }

}
