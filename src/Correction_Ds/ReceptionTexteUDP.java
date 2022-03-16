package Correction_Ds;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceptionTexteUDP {
    public static void recevoirTexteUDP(int portEcoute) {
        DatagramPacket paquet=null;
        DatagramSocket socket=null;
        byte buffer[]=null;
        String texte=null;
        try {
            buffer=new byte[1000];
            paquet= new DatagramPacket(buffer,buffer.length,portEcoute);
            socket =new DatagramSocket(portEcoute);
            socket.receive(paquet);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
    }
    public static void main(String[] args) { recevoirTexteUDP(8000) ; }
}