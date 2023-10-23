package Server;

import Data.*;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vitor
 */
public class Users {
    
    private String name;
    private Socket conexao;
    private Input input;
    private Output output;
    
    public Users(String name, Socket conexao) throws IOException{
        this.name = name;
        this.conexao = conexao;
        
        this.input = new Input(conexao);
        this.output = new Output(conexao);
        
        input.start();
        output.start();       
    }

    public String getName() {
        return name;
    }

    public void setConexao(Socket conexao) {
        this.conexao = conexao;
    }

    public Socket getConexao() {
        return conexao;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }
}
