package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        // Crear un socket UDP en el puerto 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];

        System.out.println("Servidor UDP esperando mensajes...");

        while (true) {
            // Recibir paquete del cliente
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Mensaje recibido: " + message);

            // Si el mensaje es "FIN", termina el bucle
            if (message.equals("FIN")) {
                break;
            }
        }

        System.out.println("Servidor finalizado.");
        serverSocket.close();
    }
}
