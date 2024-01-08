package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        // Crear un socket UDP
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost"); // Cambiar a la dirección IP del servidor si es necesario

        byte[] sendData;

        // Enviar 10.000 mensajes
        for (int i = 0; i < 10000; i++) {
            String sentence = "Mensaje número " + i;
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
        }

        // Enviar mensaje de finalización
        String finalMessage = "FIN";
        sendData = finalMessage.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        System.out.println("Cliente finalizado.");
        clientSocket.close();
    }
}
