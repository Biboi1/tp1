/*
* LISSE Guillaume
*/

package TP0;

import java.io.IOException;
import java.net.*;

public class EnvoyerUDP {

    public static void main(String[] args) {

        System.out.println("Expediteur UDP"); // on créer un datagramPacket pour l'envoie

        DatagramPacket paquet;
        InetAddress adresseDest = null; // adresse destinataire
        int port = 2000;

        try{
            adresseDest = InetAddress.getByName("127.0.0.1"); // ajout de l'adresse destinataire
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
            System.exit(1);
        }

        byte[] donnees= "Bonjour tout le monde !".getBytes(); //converti le string en bytes

        paquet = new DatagramPacket(donnees, donnees.length, adresseDest, port); // créer un nouveau paquet

        System.out.println("le paquet a été créer");

        // création d'un socket pour expédier le paquet créer

        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(); // création d'un nouveau socket
        }catch (SocketException e){
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("socket a été créer");

        // on va envoyer le paquet

        try{
            socket.send(paquet); // send permet de l'envoyer
        }catch (IOException e1){
            e1.printStackTrace();
            System.exit(1);
        }

        System.out.println("le paquet a été envoyé");

        // fermeture du socket

        socket.close();
        System.out.println("socket fermé");
    }
}
