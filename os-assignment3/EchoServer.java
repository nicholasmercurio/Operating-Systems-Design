/*
 * Nicholas Mercurio & Jay Lansiquot
 * EchoServer.java
 * SYST 44288 - Assignment 3
 * Server program for Echo Server application
 * EchoServer.java MUST BE RUN BEFORE RUNNING CLIENT
 * Server can only have a single instance, while client can have multiple
 */

import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;

public class EchoServer {
	public static void main(String[] args) {

		ServerSocket server = null;
		try {
			server = new ServerSocket(6013);
			server.setReuseAddress(true); // Allows for client's loopback address to be used for multiple instances
			while(true) { // used to keep accepting new connections
				System.out.println("Waiting for client connection...");
				Socket client = server.accept();
				System.out.println("New client connected " + client.getInetAddress().getHostAddress());
				ClientHandler clientSock = new ClientHandler(client);
				new Thread(clientSock).start(); // Creates new thread for multiple instances
			}
		}catch(IOException e) {
			System.err.println("Error connecting client!");
			System.err.println(e);
		}finally {
			if(server != null) {
				try {
					server.close();
				}catch(IOException e) {
					System.err.println("Error closing server!");
					System.err.println(e);
				}
			}
		}
	}

	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;

		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}

		@Override
		public void run() {
			PrintWriter output = null;
			BufferedReader input = null;
			try {
				// Allows for reading from client and writing
				output = new PrintWriter(clientSocket.getOutputStream(), true); 
				input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line;
				while((line = input.readLine()) != null) { //Loops while the inputted string is not null
					System.out.printf("Sent from client: %s\n", line);
					output.println(line);
				}
			}catch(IOException e) {
				System.err.println("Error recieving I/O from client!");
				System.err.println(e);
			}finally {
				try {
					if(output != null) {
						output.close();
					}
					if(input != null) {
						input.close();
					}
					clientSocket.close();
				}catch(IOException e) {
					System.err.println("Error closing I/O stream!");
					System.err.println(e);
				}
			}
		}
	}
}
