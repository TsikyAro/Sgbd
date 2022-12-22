package sgbd;
import java.io.*;
import java.net.*;
import java.util.*;
import java.math.*;
import affiche.Vocabulaire;

public class Server{
    static int i = 0;
    public static void main(String[]args)throws Exception{
        
        try {
            /*vocabulaire*/
            Vocabulaire voica = new Vocabulaire();
            ServerSocket server = new ServerSocket(6666);
            Socket socket;
            socket = server.accept();
            while (true)
            {
                // Accept the incoming request
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                while(dis.readUTF()!= null){
                    // System.out.println(dis.readUTF());
                    String str=(String)dis.readUTF();   
                    // System.out.println("message:"+str);
                    message("Message : "+str);
                    String reps = voica.vocab(str);
                    dos.writeUTF(reps);
                    dos.flush();
                }
    
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static void message(String haha)throws Exception
    {
        for(int i = 0; i < haha.length(); i++)
        {
            int randomn = (int)Math.floor(Math.random()*200);
            Thread.sleep(randomn);
            System.out.print(haha.charAt(i));
        }
        System.out.println("");
    }
}