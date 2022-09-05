import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started");

            Socket s = ss.accept();
            System.out.println("Client connected. Please wait for client's message :)");

            DataInputStream dis =  new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            while(true){
                try{
                    String clientMsg = (String)dis.readUTF();
                    System.out.println("CLIENT: "+clientMsg);

                    System.out.println("Reply to Client");
                    String msg = input.nextLine();
                    dout.writeUTF(msg);
                    dout.flush();
                }catch(Exception e){
                    dout.close();
                    s.close();
                    System.out.println(e);
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        
    }
}