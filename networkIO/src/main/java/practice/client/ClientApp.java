package practice.client;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;

import practice.server.NetworkIO;

public class ClientApp {
    
    public static void main(String[] args) throws IOException{
        String[] inputArr = args[0].split(":");
        String host = inputArr[0];
        int port = Integer.parseInt(inputArr[1]);

        while(true){
            // Create socket
            Socket sock = new Socket(host, port);
            NetworkIO netIO = new NetworkIO(sock);

            // Get user input from console
            Console cons = System.console();
            String userInput = cons.readLine("Send request to server? ");
            netIO.write(userInput);

            String responseFromServer = netIO.read();
            if (responseFromServer.length() > 0){
                System.out.println("Message received: " + responseFromServer);
            }
            netIO.close();
            sock.close();
            if (responseFromServer.equals("Connection closed")){
                System.exit(0);
            }
        }

    }
}
