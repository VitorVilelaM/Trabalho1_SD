package Chat;

import Data.Input;
import Data.Output;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */
public class ChatController {
    
    public ChatController(){}
    
    public void Client(Socket conexao) throws IOException{
        Input inp = new Input(conexao);
        Output out = new Output(conexao);
        out.run();
    }
    
    public void Server(){}
    
}
