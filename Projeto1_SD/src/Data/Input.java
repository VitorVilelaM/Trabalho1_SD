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

    public Input(Socket conexao) throws IOException {
        this.conexao = conexao;
        this.fluxoEntrada = new DataInputStream(conexao.getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                String mensagem = fluxoEntrada.readUTF();
                System.out.println(mensagem);
            } catch (IOException ex) {
                System.out.println("Erro na comunicação com o servidor!");
            }
        }
    }

    public void startChat(Socket client){
        
    }
    
    public String InputLogin() throws IOException {
        String mensagem = fluxoEntrada.readUTF();
        return mensagem;
    }

}
