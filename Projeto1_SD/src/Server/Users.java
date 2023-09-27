package Server;

import java.net.Socket;

/**
 *
 * @author vitor
 */
public class Users {
    private String name;
    private Socket conexao;
    
    public Users(String name, Socket conexao){
        this.name = name;
        this.conexao = conexao;
    }

    public String getName() {
        return name;
    }

    public Socket getConexao() {
        return conexao;
    }
}
