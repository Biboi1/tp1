package TP1;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DialogueUDP {

    private String nomDestinataire;
    private int portDestinataire;
    private InetAddress adresseDestinataire;
    private String nomSource;
    private DatagramSocket socketReception;
    static private Scanner scanner= new Scanner(System.in);


    public DialogueUDP(String monNomUtilisateur, int monPort, int portDestinataire, InetAddress adresseDestinataire) {
        this.nomSource=nomDestinataire;
        try{
            this.socketReception=new DatagramSocket(monPort);
        }
        catch (SocketException e) {
            e.printStackTrace();
            System.err.println("Impossible d'initialiser port :"+monPort);
            System.exit(1);
        }

        this.adresseDestinataire=adresseDestinataire;
        this.portDestinataire=portDestinataire;
    }
    public void envoiMessage(boolean premierEnvoi){
        String message=null;
        System.out.println(this.nomSource+">");
        if(premierEnvoi){
            message=nomSource;
        }else{
            message=scanner.nextLine();
        }
        DatagramPacket paquet=null;
        byte[] data=message.getBytes();
        paquet=new DatagramPacket(data,data.length,adresseDestinataire,portDestinataire);

        DatagramSocket socket=null;

        try{
            socketReception.send(paquet);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Impossible d'envoyer le datagramme Udp");
            System.exit(1);
        }

    }

    public void receptionMessage(boolean premierReception){
        byte[]data=new byte[1000];
        DatagramPacket paquet=null;
        paquet=new DatagramPacket(data,data.length);
        try{
            socketReception.receive(paquet);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problème lors de la Réception d'un Datagramme Udp");
            System.exit(1);
        }
        String message=null;
        message=new String(paquet.getData(),0,paquet.getLength());

        if(premierReception){
            this.nomDestinataire=message;
        }
        System.out.println(nomDestinataire+">"+message);


    }

    void dialogue(boolean premier){
        System.out.println("***Dialogue***");
        if(premier){
            envoiMessage(true);
            receptionMessage(true);
        }
        else{
            receptionMessage(true);
            envoiMessage(true);
        }
        while(true){
            if(premier){
                envoiMessage(false);
                receptionMessage(false);
            }
            else{
                receptionMessage(false);
                envoiMessage(false);
            }
        }
    }
    public static void main(String[]args){
        if (args.length!=5){
            System.err.println("Le programme nécessite plus de 5 argurment");
            System.exit(1);
        }
        System.out.println("Arguments :");
        for(int i=0;i<5;i++) {
            System.out.println(args[1]);
        }
        String monNom=args[0];
        int monPort =Integer.parseInt(args[1]);
        InetAddress adresseDest=null;

        try{
            adresseDest=InetAddress.getByName(args[2]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        int portDest=Integer.parseInt(args[3]);

        scanner.close();
    }

}
