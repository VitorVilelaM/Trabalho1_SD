package Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * // * @author vitor
 */
public class Input extends Thread {
    
    public Input(){}
    
    @Override
    public void run(){
        while(true){
            System.out.println("INPUT");
        }
    }
    
    /*
    public void Input(Socket conexao) throws IOException {
        DataInputStream fluxoEntrada = new DataInputStream(conexao.getInputStream());
        while (true) {
            String mensagem = fluxoEntrada.readUTF();
            System.out.println("" + mensagem);
        }
    }
     */
}
