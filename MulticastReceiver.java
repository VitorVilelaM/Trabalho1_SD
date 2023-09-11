package sd_code3;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class MulticastReceiver {

    public static void main(String args[]) {
        //Define um socket para multcast
        MulticastSocket s = null;
        try {
            //define um ip multicast para o grupo
            InetAddress mcastaddr = InetAddress.getByName("228.5.6.7");
            //associa um par endereço multicast + porta para a comunicação em grupo
            InetSocketAddress group = new InetSocketAddress(mcastaddr, 6789);
            //define uma interface de rede a ser usada na comunicação multcast
            NetworkInterface netIf = NetworkInterface.getByName("");
            //instacia o socket multicast
            s = new MulticastSocket(6789);
            //junta-se a um grupo multcast
            s.joinGroup(group, netIf);
            //cria estruturas para o recebimento de mensagens
            byte[] buf = new byte[1000];
            DatagramPacket messageIn = new DatagramPacket(buf, buf.length);
            s.receive(messageIn);
            System.out.println(":)" + new String(messageIn.getData(), 0, messageIn.getLength()));
            //Deixando o grupo...
            s.leaveGroup(group, netIf);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
