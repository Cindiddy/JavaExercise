package multiThreadedFileTransferTCP;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        Socket s =new Socket("xxx.xxx.xx.xx",10000);

        BufferedReader br=new BufferedReader(new FileReader("multiThreadedFileTransferTCP/file.txt"));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

       String line;
       while((line=br.readLine())!=null){
           bw.write(line);
           bw.newLine();
           bw.flush();
       }

       s.shutdownOutput();

       BufferedReader brClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();
        System.out.println("The feedback from server is: "+data);

        s.close();
        br.close();
    }
}
