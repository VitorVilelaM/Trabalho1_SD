package sd_code3;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class MulticastSender {

    public static void main(String args[]) {
        MulticastSocket s = null;
        try {
            String msg = "Hello";
            InetAddress mcastaddr = InetAddress.getByName("228.5.6.7");
            InetSocketAddress group = new InetSocketAddress(mcastaddr, 6789);
            NetworkInterface netIf = NetworkInterface.getByName("");
            s = new MulticastSocket(6789);
            s.joinGroup(group, netIf);
            byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket hi = new DatagramPacket(msgBytes, msgBytes.length, group);
            s.send(hi);
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
