package Client;

import Data.Input;
import Data.Output;
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
        connection.start();
        
        while(true){}
    }

}
