package UDPCommunicationProgram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
    UDP receive data
    Since receive side does not know when the sender will stop sending data,
    I use infinite loop to receive data
 */

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(12345);

        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            ds.receive(dp);

            System.out.println("The data we received is: " + new String(dp.getData(), 0, dp.getLength()));
        }
    }
}
