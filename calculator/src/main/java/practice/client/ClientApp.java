package practice.client;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import practice.server.NetworkIO;

public class ClientApp {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String host = "localhost";
        int port = 1234; // default port

        if(args.length > 0){
            host = args[0].split(":")[0];
            port = Integer.parseInt(args[0].split(":")[1]);
        }

        Socket socket = new Socket(host, port);
        NetworkIO netIO = new NetworkIO(socket);
        
        Console cons = System.console();
        String command = ""; 

        while(!command.equalsIgnoreCase("quit")){
            command = cons.readLine("What do you want to do? ");
            netIO.writeOutput(command);

            String replyFromServer = netIO.readInput();
            System.out.println(replyFromServer);
        }
        
    }
    
}
