package Client;

import Chat.ChatController;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Connection connection = new Connection();
        Socket conexao = connection.ConnectionServer();

        while (true) {
            if (conexao != null) {
                ChatController chat = new ChatController();
                chat.Client(conexao);
            }
        }
    }

}
