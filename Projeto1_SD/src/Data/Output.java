package Data;

import Server.Users;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 202011020022
 */
public class Output extends Thread {

    private Socket conexao;
    private DataOutputStream fluxoSaida;
    Scanner sc = new Scanner(System.in);

    public Output(Socket conexao) throws IOException {
        this.conexao = conexao;
        fluxoSaida = new DataOutputStream(conexao.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            String msg = sc.nextLine();
            try {
                fluxoSaida.writeUTF(msg);
            } catch (IOException ex) {
                System.out.println("Erro na comunicação com o servidor!");
            }
        }
    }

    public void OutputLoginClient() throws IOException {
        System.out.print("Informe seu nome para Login: ");
        String msg = sc.nextLine();
        fluxoSaida.writeUTF(msg);
    }

    public void OutputLoginServer() throws IOException {
        String msg = "Sucesso no login!";
        fluxoSaida.writeUTF(msg);
    }
    
}
