package multiThreadedFileTransferTCP;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;
    public ServerThread(Socket s) {
        this.s=s;
    }
    @Override
    public void run(){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            //BufferedWriter bw=new BufferedWriter(new FileWriter("multiThreadedFileTransferTCP/copyfile.txt"));

            int count=0;
            File file=new File("multiThreadedFileTransferTCP/copyfile("+count+").txt");
            while(file.exists()){
                count++;
                file=new File("multiThreadedFileTransferTCP/copyfile("+count+").txt");
            }

            BufferedWriter bw=new BufferedWriter(new FileWriter(file));

            String line;
           while((line=br.readLine())!=null){
               bw.write(line);
               bw.newLine();
               bw.flush();
           }

           BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
           bwServer.write("uploaded successfully");
           bwServer.newLine();
           bwServer.flush();
           s.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
