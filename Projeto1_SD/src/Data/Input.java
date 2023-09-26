package Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * // * @author vitor
 */
public class Input extends Thread {

    private Socket conexao;
    private DataInputStream fluxoEntrada;
    private boolean loop;

    public Input(Socket conexao) throws IOException {
        this.conexao = conexao;
        this.fluxoEntrada = new DataInputStream(conexao.getInputStream());
        this.loop = true;
    }

    @Override
    public void run() {
        while (this.loop) {
            try {
                String mensagem = fluxoEntrada.readUTF();
                System.out.println(mensagem);
            } catch (IOException ex) {
                this.loop = false;
            }
        }
    }
    
    public String InputLogin() throws IOException {
        String mensagem = fluxoEntrada.readUTF();
        return mensagem;
    }

}
