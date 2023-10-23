package Data;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 202011020022
 */
public class Output extends Thread {

    private Socket conexao;
    private DataOutputStream fluxoSaida;
    private String msg = "";

    Scanner sc = new Scanner(System.in);

    public Output(Socket conexao) throws IOException {
        this.conexao = conexao;
        fluxoSaida = new DataOutputStream(conexao.getOutputStream());
    }

    public void send() throws IOException {
        fluxoSaida.writeUTF(msg);
        this.msg = "";
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.msg = sc.nextLine();
                fluxoSaida.writeUTF(msg);
            } catch (IOException ex) {
                System.out.println("Erro na comunicação com o servidor!");
                break;
            }
        }
    }

    public void setMsg(String men) {
        this.msg = men;
    }

    public void OutputLoginClient() throws IOException {
        System.out.print("Informe seu nome para Login: ");
        String msg = sc.nextLine();
        fluxoSaida.writeUTF(msg);
    }

    public void OutputLoginServer(String msg) throws IOException {
        fluxoSaida.writeUTF(msg);
    }

}
