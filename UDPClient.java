package sd_code1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

    public static void main(String args[]) {
        // args fornece o conteúdo da mensagem e o nome de host do servidor
        DatagramSocket clientSocket = null;
        try {
            //Criando um socket e preenchendo o cabeçalho do pacote
            clientSocket = new DatagramSocket();
            String msg = "Olá! Tudo bem?";
           
            byte[] m = msg.getBytes();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            //Monta o pacote a ser enviado
            DatagramPacket pkt = new DatagramPacket(m, m.length, serverAddress, serverPort);
            clientSocket.send(pkt);
            //Preparando o buffer de recebimento da mensagem
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            //Aguarda pelo recebimento da mensagem
            clientSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }

}
