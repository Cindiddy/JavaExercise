package UDPCommunicationProgram;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
    UDP send data, data will come from keyboard input
    Keep sending data until the input data is "bye"
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //create a socket object on the sender side
        DatagramSocket ds=new DatagramSocket();
        //Encapsulate the keyboard input data
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line= br.readLine())!=null){
            //if the input data is "bye", end the data sending
            if ( "bye".equals(line)){
                break;
            }
            //create and package data
            byte[] bys=line.getBytes();
            DatagramPacket dp=new DatagramPacket(bys,bys.length, InetAddress.getByName("xxx.xxx.xx.xx"),12345);
            //send data
            ds.send(dp);
        }
        ds.close();
    }
}
