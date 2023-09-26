package Client;

import Chat.ChatController;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */

public class Main {

    public static void main(String[] args){
        Connection connection = new Connection();
        Socket conexao = connection.ConnectionServer();
        
        while (true) {
            
        }
    }

}
