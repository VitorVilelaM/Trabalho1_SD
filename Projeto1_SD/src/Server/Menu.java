package Server;

import Data.Input;
import Data.Output;
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

    public Menu(Input inp, Output out, Connections ser) {
        this.outClient = out;
        this.inpClient = inp;
        this.server = ser;
    }

    public void run() {
        outClient.setMsg("--- MENU --- \n 1- Ver pessoas online \n 2 - \n 3 - Sair ");
        outClient.send();
        
        try {
            inpClient.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg = inpClient.getMsg();
        System.out.println("Cliente: " + msg);
        
    }
}
