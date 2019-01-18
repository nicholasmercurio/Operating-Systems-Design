/*
 * Nicholas Mercurio & Jay Lansiquot
 * EchoClient.java
 * SYST 44288 - Assignment 3
 * Client program for echo server
 * REQUIRES EchoServer.java TO BE RUN FIRST
 * type 'exit' to end execution
 * Multiple instances of EchoClient can be run with a single instance of EchoServer
 */

import java.util.*;
import java.io.*;
import java.lang.*;
import java.net.*;

public class EchoClient {
	public static void main(String[] args) {

		String host = "127.0.0.1";
		int port = 6013;
		try (Socket socket = new Socket(host, port)) {
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner scanner = new Scanner(System.in);
		String line = null;
		
			while(!"exit".equalsIgnoreCase(line)) { //ensures that typing exit quits the application regardless of case
				line = scanner.nextLine();
				output.println(line);
				output.flush();
				System.out.println("Server replied: " + input.readLine());
			}
			scanner.close();
		} catch(IOException e) {
			System.err.println("Error sending output to server!");
			System.err.println(e);
		}
	}
}
