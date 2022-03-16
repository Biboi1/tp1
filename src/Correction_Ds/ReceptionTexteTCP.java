package Correction_Ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class ReceptionTexteTCP {
    public static void recevoirTexteTCP(int portEcoute) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        String texte=null;
        BufferedReader entree=null;
        try {

                serverSocket=new ServerSocket(portEcoute);
                socket=serverSocket.accept();
                entree=fluxEntrant(socket);
                texte=entree.readLine();
                socket.close();
                serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
    }
    private static BufferedReader fluxEntrant(Socket socket){
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader fluxEntrant=null;
        try{
            inputStream=socket.getInputStream();
            inputStreamReader = new InputStreamReader (inputStream);
            fluxEntrant=new BufferedReader(inputStreamReader);
        }catch(IOException e ){
            System.err.println( "Problème lors de la création du flux entrant\n");
            System.exit(1);
        }
        return fluxEntrant;
    }
    public static void main(String[] args) {
        recevoirTexteTCP(8000);
    }
}
