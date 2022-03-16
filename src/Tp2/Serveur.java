package Tp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

    private ServerSocket serverSocket;

    public void enregistrementService(int port){
        System.out.println("*** Serveur en attente ***");
        try{
            serverSocket=new ServerSocket(port ,4);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.print("Impossible de créer le serveur Socket");
            System.exit(1);
        }
        System.out.println("A l'écoute du port"+port+"...");
    }
    private Socket nouvelleConnexion() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problème lors de l'attente");
        }
        System.out.println("Nouvelle connexion rélisée");
        return socket;
    }
    public static void main(String[]args) {
        if (args.length != 5) {
            System.err.println("Le programme nécessite plus de 5 argurment");
            System.exit(1);
        }
        int nomPort=Integer.parseInt(args[0]);
        System.out.println("Numéro de port a utiliser: "+nomPort);

        Serveur serveur = new Serveur();
        serveur.enregistrementService((nomPort));
    }
}
