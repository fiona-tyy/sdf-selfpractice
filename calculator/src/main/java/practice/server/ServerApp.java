package practice.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        
        int port = 1234; // default port
    
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening in on port: " + port);

        while(true){
            Socket socket = server.accept();

            NetworkIO netIO = new NetworkIO(socket);
            Calculator calculator = new Calculator();
            
            while(true){
                String dataFromClient = netIO.readInput().toLowerCase();

                if (dataFromClient.startsWith("add")){
                    List<Integer> numberList = calculator.getNumberList(dataFromClient);
                    int result = calculator.add(numberList);
                    netIO.writeOutput("" + result);
    
                } else if (dataFromClient.startsWith("subtract")){
                    List<Integer> numberList = calculator.getNumberList(dataFromClient);
                    int result = calculator.subtract(numberList);
                    netIO.writeOutput("" + result);
    
                } else if (dataFromClient.startsWith("multiply")){
                    List<Integer> numberList = calculator.getNumberList(dataFromClient);
                    int result = calculator.multiply(numberList);
                    netIO.writeOutput("" + result);
    
                } else if (dataFromClient.equalsIgnoreCase("quit")){
                    netIO.writeOutput("Byebye..");
                    server.close();
                    System.exit(0);
                    break;
                } else {
                    netIO.writeOutput("Invalid command");   
                }
            }

            
        }
    }
    
}
