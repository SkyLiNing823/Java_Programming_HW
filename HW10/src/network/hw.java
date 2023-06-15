package network;
import java.net.Socket;
import java.net.InetSocketAddress;

public class hw {
	static void isPortAvailable(int port) {
	    try {
	        Socket socket = new Socket();
	        socket.connect(new InetSocketAddress("localhost", port), 100);
	        System.out.println("port "+port+" is available.");
	        socket.close();
	    } catch (Exception e) {
	    System.out.println("port "+port+" is occupied.");
	    }
	}
	
	public static void main(String[] args) {
		for(int port = 1; port <= 65535; port++)
		{
			isPortAvailable(port);
		}
	}
	
}
