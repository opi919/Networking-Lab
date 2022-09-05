import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try{
            Socket s = new Socket("192.168.10.75",6666);
            System.out.println("Connected with server....");

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            while(true){
                try{
                    System.out.println("Enter a message for Server");
                    String msg = input.nextLine();

                    dout.writeUTF(msg);
                    dout.flush();

                    String serverMsg = (String)dis.readUTF();
                    System.out.println("SERVER: "+serverMsg);
                }catch(Exception e){
                    dout.close();
                    System.out.println(e);
                    s.close();
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}