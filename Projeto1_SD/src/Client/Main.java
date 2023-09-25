package Client;

/**
 *
 * @author vitor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Connection connection = new Connection();
        
        connection.ConnectionServer();
        System.out.println("Voltei Main");
    }

}
