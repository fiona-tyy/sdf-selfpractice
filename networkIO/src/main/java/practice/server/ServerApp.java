package practice.server;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    
    public static void main(String[] args) throws IOException {
        int port = 12345; //default port if no args specified
        Socket sock;
        NetworkIO netIO;
        if (args.length > 0){
            port = Integer.parseInt(args [0]);
        }

        // Instantiate server socket
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at " + port);

        while(true){
            // Server accepts connection from client
            sock = server.accept();

            // Instantiate a networkIO
            netIO = new NetworkIO(sock);
    
            while (true){

                try{
                    // Read input from client
                    String dataFromClient = netIO.read();

                    // Write output to client
                    System.out.println("Sending message to client");
                    
                    if (dataFromClient.equalsIgnoreCase("send-over")){
                        netIO.write("This is a message from server to client");
    
                    } else if (dataFromClient.equalsIgnoreCase("quit")){
                        System.out.println("Server exiting..");
                        netIO.write("Connection closed");
                        server.close();
                        System.exit(0);
                        break;
                    }else {
                        netIO.write("Invalid command!");
                    }
                } catch (EOFException e){
                    System.out.println("End of message to client");
                    break;
                } 
            }
        
        }

    }
}
