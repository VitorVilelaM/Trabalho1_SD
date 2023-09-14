package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
// * @author vitor
 */
public class InputMsg {
    
    public void Input(Socket conexao) throws IOException {
        DataInputStream fluxoEntrada = new DataInputStream(conexao.getInputStream());
        while (true) {
            String mensagem = fluxoEntrada.readUTF();
            System.out.println("" + mensagem);
        }
    }
}
