package Server;

import Chat.ChatController;
import java.io.IOException;

/**
 *
 * @author vitor
 */
public class Menu extends Thread {

    private Connections server;
    private Users user;
    private String msg;
    private String name;
    private ChatController chat;

    public Menu(Users user, Connections ser) {
        this.server = ser;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            menuStarter();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private void menuStarter() throws IOException {
        user.getOutput().setMsg("--- MENU --- \n 1- Ver pessoas online \n 2 - Grupos \n 3 - Sair ");
        user.getOutput().send();

        while (true) {
            msg = user.getInput().getMsg();
            if (msg.equals("1")) {
                returnUsers();
            } else if (msg.equals("2")) {

            } else if (msg.equals("3")) {
                removeUser();

            }
        }
    }

    private void removeUser() throws IOException {
        int i = 0;
        while (i < server.getUsers().size()) {
            if ((user.getName().equals(server.getUsers().get(i).getName()))) {
                server.getUsers().get(i).getConexao().close();
                server.getUsers().remove(i);
                break;
            }
            i++;
        }

    }

    private void menuUsers() throws IOException {
        int i = 0;

        boolean search, repeat;

        repeat = true;
        search = false;

        while (repeat) {
            name = user.getInput().getMsg();

            if (!(name.isEmpty())) {
                while (i < server.getUsers().size()) {
                    if ((name.equals(server.getUsers().get(i).getName()))) {
                        search = true;
                        break;
                    }
                    i++;
                }

                if (search) {
                    chat = new ChatController(user, server.getUsers().get(i), server);
                    chat.start();
                    user.getInput().setMsg("");

                } else if (name.toLowerCase().equals("sair")) {
                    menuStarter();
                } else {
                    user.getOutput().setMsg("Usuario nao se encontra online!");
                    user.getOutput().send();
                    returnUsers();
                }

                repeat = false;
            }

        }
    }

    private void returnUsers() throws IOException {
        user.getInput().setMsg("");

        String users = "";

        for (Users user : server.getUsers()) {
            if (user != this.user) {
                users += user.getName() + "\n";
            }
        }

        user.getOutput().setMsg("--- Usuários online ---" + "\n" + users);
        user.getOutput().send();

        user.getOutput().setMsg("Informe o nome de quem deseja conversar ou entao 'sair' para sair desse menu: ");
        user.getOutput().send();

        menuUsers();
    }
}
