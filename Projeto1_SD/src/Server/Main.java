package Server;

import java.io.IOException;

/**
 *
 * @author vitor
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Server rodando...");
        
       
        try {
            Connections connections = new Connections();
            connections.start();
            while (true) {
                
            }
        } catch (IOException ex) {
            System.out.println("Não foi possível criar o servidor!");
        }
    }

}
