package practice.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {

    private InputStream is;
    private BufferedInputStream bis;
    private DataInputStream dis;
    private OutputStream os;
    private BufferedOutputStream bos;
    private DataOutputStream dos;


    public NetworkIO(Socket socket) throws IOException{
        is = socket.getInputStream();
        bis = new BufferedInputStream(is);
        dis = new DataInputStream(bis);
        os = socket.getOutputStream();
        bos = new BufferedOutputStream(os);
        dos = new DataOutputStream(bos);

    }

    public String read() throws IOException{
        return dis.readUTF();
    }

    public void write(String s) throws IOException{
        dos.writeUTF(s);
        dos.flush();
    }

    public void close() throws IOException{
        dis.close();
        is.close();
        dos.close();
        os.close();
    }
}
