package Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 202011020022
 */
public class OutputMsg {
        public void Output(Socket conexao) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());
        while (true) {
            String msg = sc.nextLine();
            fluxoSaida.writeUTF(msg);
        }
    }
}
