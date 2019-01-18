/*************************************************************
 * Nicholas Mercurio & Jay Lansiquot
 * EchoServer.java
 * SYST44288 - Operating Systems Design & Systems Programming
 * 10/8/2018
**************************************************************/

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		
		ServerSocket serverSock = null;
		try {
			serverSock = new ServerSocket(6013); // Creates Socket instance using port 6013 and loopback address

			Socket clientSock = null;
			System.out.println("Waiting for connection...");
			
			// Waits for a connection from another instance
			clientSock = serverSock.accept();

			System.out.println("Connection successful!");
			System.out.println("Waiting for input from client...");

			// Gets input from other instance
			PrintWriter output = new PrintWriter(clientSock.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));	

			String line;

			while((line = input.readLine()) != null) {
				System.out.println("Server: " + line);
				output.println(line);
	
				// Kills connection once exit is entered
				if(line.equals("exit")) {
					break;
				}
			}
	
			// Closes all instances
			output.close();
			input.close();
			clientSock.close();
			serverSock.close();
		}catch(IOException ioe) {
			System.out.println("Communication Error!");
			System.err.println(ioe);
			System.exit(1);
		}
	}
}
