package practice.client;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import practice.server.NetworkIO;

public class ClientApp {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        String host = "localhost";
        int port = 12345;

        if (args.length > 0) {
            host = args[0].split(":")[0];
            port = Integer.parseInt(args[0].split(":")[1]);
        }

        Socket socket = new Socket(host, port);

        NetworkIO netIO = new NetworkIO(socket);
        Console cons = System.console();
        String userInput = "";

        while(!userInput.equalsIgnoreCase("quit")){
            userInput = cons.readLine("Enter input >> ");
            netIO.writeOutput(userInput);

            String replyFromServer = netIO.readInput();

            // Enter what to do with reply from server
            System.out.println(replyFromServer);
        }
        
    }
}
