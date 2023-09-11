package sd_code2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        /* Registra servico na porta 1234 e aguarda por conexoes */
        ServerSocket servidor = new ServerSocket(1234);
        System.out.println("Aguardando por conexoes");

        Socket conexao = servidor.accept();
        System.out.println("Cliente conectou " + conexao);

        DataInputStream fluxoEntrada = new DataInputStream(conexao.getInputStream());
        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());

        Scanner sc = new Scanner(System.in);
        
        while (true) {
                        
            /* SERVER */
            String mensagem = fluxoEntrada.readUTF();
            System.out.println("Alexandre> " + mensagem);
            
            /* CLIENT */
            System.out.println("");
            String msg = sc.nextLine();
            fluxoSaida.writeUTF(msg);

            fluxoSaida.flush();
            String msgClient = fluxoEntrada.readUTF();
        }
    }
}
