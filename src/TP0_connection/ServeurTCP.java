package TP0_connection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {

    public static void main(String[] args) {

        System.out.println("--- Serveur ---");

        // Enregistrement du service sur le port 6000
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6000);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("--- Serveur à l'écoute sur le port 6000");

        Socket socket = null;

        try {
            socket = serverSocket.accept();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("--- la connexion est établie ! ---");


        //preparation des flux entrée/sortie

        InputStream input = null;

        try {
            input = socket.getInputStream();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        BufferedReader entree = new BufferedReader(new InputStreamReader(input));

        OutputStream output = null;

        try {
            output = socket.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        PrintWriter sortie = new PrintWriter(output);

        // Echange de donnees

        sortie.println("je suis le serveur !");
        sortie.flush();

        try {
            System.out.println(entree.readLine());
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        sortie.close();

        try {
            entree.close();
        }catch (IOException e1){
            e1.printStackTrace();
        }

        try {
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
