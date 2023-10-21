package Chat;

import Server.Users;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class ChatController extends Thread {

    String msgSend, msgReceive;
    private Users usr1, usr2;
    Scanner sc = new Scanner(System.in);

    public ChatController(Users sender, Users receiver) {
        this.usr1 = sender;
        this.usr2 = receiver;
    }

    @Override
    public void run() {
        while (true) {
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
            usr2.getOutput().setMsg(usr1.getName() + ": " + msgSend);
            usr2.getOutput().send();

            usr1.getInput().setMsg("");
        }
    }

    public void receive() {
    }

}
