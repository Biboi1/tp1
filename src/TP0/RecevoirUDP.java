/*
* LISSE Guillaume
*/

package TP0;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class RecevoirUDP {

    public static void main(String[] args) {

        System.out.println("destinataire UDP");

        DatagramSocket socket = null;

        int port = 2000; // meme que envoyerUDP

        try{
            socket = new DatagramSocket(port);
        }catch (SocketException e){
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("socket attaché au port 2000");

        DatagramPacket paquet = null;
        byte[] buffer = new byte[1000];
        paquet = new DatagramPacket(buffer, buffer.length);


        //attente est reception d'un paquet UDP

        try{
            socket.receive(paquet);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        //affiche la chaine recu

        try{
            socket.receive(paquet);
        }catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // affiche ma chaine recu
        String donnees=new String(buffer,0,paquet.getLength());
        System.out.println("Données : "+donnees);

        // Fermeture du socket
        socket.close();
        System.out.println("Socket fermé");

    }

}
