package sd_code1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UnionCodes {

    public static void main(String args[]) throws SocketException {
        DatagramSocket serverSocket = null;
        DatagramSocket clientSocket = new DatagramSocket();
        try {
            serverSocket = new DatagramSocket(6789);
            InetAddress serverAddress = InetAddress.getByName("10.14.104.202");
            int serverPort = 6789;

            //Preparando o buffer de recebimento da mensagem
            while (true) {
                byte[] buffer = new byte[1000];
                DatagramPacket receivePackage = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(receivePackage); 
                String msg = new String(receivePackage.getData());
                System.out.println(msg);
                
                Scanner sc = new Scanner(System.in);
                String msgClient = sc.nextLine();
                byte[] m = msgClient.getBytes();
                
                DatagramPacket pkt = new DatagramPacket(m, m.length, serverAddress, serverPort);
                clientSocket.send(pkt);
                
                //Prepara o pacote de dados a ser enviado
                DatagramPacket reply = new DatagramPacket(msg.getBytes(), receivePackage.getLength(), receivePackage.getAddress(), receivePackage.getPort());
                serverSocket.send(reply);

                //Preparando o buffer de recebimento da mensagem
                byte[] bufferClient = new byte[1000];
                DatagramPacket replyClient = new DatagramPacket(bufferClient, bufferClient.length);
                
                //Aguarda pelo recebimento da mensagem
                clientSocket.receive(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                clientSocket.close();
            }
        }
    }
}
