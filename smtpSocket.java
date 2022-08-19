import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class smtpSocket {
    private static DataOutputStream dos;

    public static void main(String[] args) throws Exception{
        String user = "s1910776142@ru.ac.bd";
        String pass = "";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com",465);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        dos = new DataOutputStream(sslSocket.getOutputStream());

        send("EHLO smtp.gmail.com\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("AUTH LOGIN\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send(username + "\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send(password + "\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("MAIL FROM:<s1910776142@ru.ac.bd>\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("RCPT TO:<asifzaman3180@gmail.com>\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("DATA\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("Subject: 3Y1S2021-1910776142\r\n");

        send("Asslamoalikom,\r\n");

        send("Name: Momen Khandoker\r\n");
        send("Roll: 1910776142\r\n");
        send("CSE,RU\r\n");

        send(".\r\n");
        System.out.println("SERVER: "+bufferedReader.readLine());

        send("QUIT\r\n");
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        Thread.sleep(1000);
        System.out.println("CLIENT: "+s);
    }
}
