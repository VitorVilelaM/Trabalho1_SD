package Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * // * @author vitor
 */
public class Input extends Thread {

    public Input() {
    }

    public String Input(Socket conexao) throws IOException {
        DataInputStream fluxoEntrada = new DataInputStream(conexao.getInputStream());
        String mensagem = fluxoEntrada.readUTF();
        return mensagem;
    }

}
