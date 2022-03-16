package Correction_Ds;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class EnvoiTexteUDP {
    public static void envoyerTexteUDP(String texte,InetAddress adresseDest,int portDest) {
        DatagramPacket paquet=null;
        DatagramSocket socket=null;
        byte data[]=null;
        try {
// A Compléter (Début)

// A Compléter (Fin)
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        String texte = "Bonjour !";
        InetAddress adresseDest = null;
        try {
            adresseDest = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
        envoyerTexteUDP(texte, adresseDest, 8000);
    }
}