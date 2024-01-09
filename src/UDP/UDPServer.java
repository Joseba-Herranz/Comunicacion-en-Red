package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];

        System.out.println("Servidor UDP esperando mensajes...");

        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Mensaje recibido: " + message);

            if (message.equals("FIN")) {
                break;
            }
        }

        System.out.println("Servidor finalizado.");
        serverSocket.close();
    }
}
