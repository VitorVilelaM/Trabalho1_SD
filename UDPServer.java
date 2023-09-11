package sd_code1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

    public static void main(String args[]) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(6789);
            //Preparando o buffer de recebimento da mensagem
            byte[] buffer = new byte[1000];
            while (true) {

                DatagramPacket receivePackage = new DatagramPacket(buffer, buffer.length);
                //Aguarda pelo recebimento da mensagem
                serverSocket.receive(receivePackage);
                //Extrai a mensagem do pacote
                String msg = new String(receivePackage.getData()).toUpperCase();
                System.out.println(msg);
                //Prepara o pacote de dados a ser enviado
                DatagramPacket reply = new DatagramPacket(msg.getBytes(), receivePackage.getLength(), receivePackage.getAddress(), receivePackage.getPort());
                serverSocket.send(reply);
                msg = "";
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
