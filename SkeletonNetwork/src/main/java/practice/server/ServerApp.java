package practice.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        int port = 12345;

        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server listening at port " + port);

        while(true){
            Socket socket = server.accept();

            //Instatiate all helper classes here
            // e.g. NetworkIO
            // e.g File IO, TextProcessor
            NetworkIO netIO = new NetworkIO(socket);

            while(true){
                // Read input from client
                String dataFromClient = netIO.readInput();
                String outputToClient = "";

                // Enter what to do with the input received
                // e.g. if(dataFromClient.equals(xxx))
                // e.g. generate wordcount


                // write output to client
                netIO.writeOutput(outputToClient);

            }

        }





    }
    
}
