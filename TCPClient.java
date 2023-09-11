package sd_code2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        int porta = 1234;
        String ip = "localhost";
        /* Estabele conexao com o servidor */
        Socket conexao = new Socket(ip, porta);
        /* Estabelece fluxos de entrada e saida */
        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());
        DataInputStream fluxoEntrada = new DataInputStream(conexao.getInputStream());

        while (true) {

        }
    }
}
