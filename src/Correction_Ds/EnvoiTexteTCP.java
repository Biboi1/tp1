package Correction_Ds;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class EnvoiTexteTCP {
    public static void envoyerTexteTCP(String texte,InetAddress adresseDest,int portDest) {
        Socket socket=null;
        PrintWriter sortie=null;
        try {
                socket=new Socket(adresseDest,portDest);
                sortie=fluxSortant(socket);
                sortie.print(texte);
                sortie.flush();
                socket.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
    }
    static PrintWriter fluxSortant(Socket socket){
        OutputStream outputStream;
        PrintWriter fluxSortant=null;
        try{
            outputStream=socket.getOutputStream();
            fluxSortant=new PrintWriter(outputStream);

        }
        catch(IOException e ){
            System.err.println( "Problème lors de la création du flux sortant\n");
            System.exit(1);
        }
        return fluxSortant;
    }
    public static void main(String[] args) {
        String texte= "Salut !";
        InetAddress adresseDest=null;
        try {
            adresseDest=InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.err.println("Problème !");
            System.exit(1);
        }
        envoyerTexteTCP(texte,adresseDest,8000);
    }
}
