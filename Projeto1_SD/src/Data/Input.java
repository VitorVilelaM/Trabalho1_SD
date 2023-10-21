package Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */
public class Input extends Thread {

    private Socket conexao;
    private DataInputStream fluxoEntrada;
    private boolean loop;

    private String msg = "";

    public Input(Socket conexao) throws IOException {
        this.conexao = conexao;
        this.fluxoEntrada = new DataInputStream(conexao.getInputStream());
        this.loop = true;
    }

    public DataInputStream getFluxoEntrada() {
        return fluxoEntrada;
    }

    @Override
    public void run() {
        while (this.loop) {
            readMsg();
        }
    }

    public synchronized void readMsg() {
        try {
            msg = fluxoEntrada.readUTF();
            System.out.println(msg);
            
            if(!(msg.isEmpty())){
                notifyAll();
            }
        } catch (IOException ex) {
            this.loop = false;
        }
    }

    public void getConexao() {
        System.out.println(conexao.getPort());
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getMsg() {
        return this.msg;
    }

    public String InputLogin() throws IOException {
        String mensagem = fluxoEntrada.readUTF();
        return mensagem;
    }

}
