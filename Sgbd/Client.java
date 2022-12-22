package sgbd;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{
    public static void main(String[]args){
        try{
            // ServerSocket server = new ServerSocket(6666);
            // ServerSocket server1 = new ServerSocket(8888);
            Scanner sc=new Scanner(System.in);
            Boolean huhu=true;
            Socket s=new Socket("localhost",6666);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

       		while(huhu==true){
				// System.out.println("");				
				String message=sc.nextLine();
                dout.writeUTF(""); 
                dout.writeUTF(message); 
                dout.flush();
                // dout.close();
                // s  = server.accept();
                String str=(String)dis.readUTF();
                if(str != null){
                    message("valiny : "+str);
                    // System.out.println("ok");
                }
                
                // s.close();
                // soc.close();
            }   

        }catch(Exception e){
            e.printStackTrace();
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