package multiThreadedFileTransferTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        Socket s = ss.accept();

        while(true) {
            new Thread(new ServerThread(s)).start();
        }
    }
}
