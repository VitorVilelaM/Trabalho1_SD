package Server;

import java.io.IOException;

/**
 *
 * @author vitor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Connections connection = new Connections();
        connection.start();
        
        while(true){         
            connection.showUsers();
        }
    }

}
