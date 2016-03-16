package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
	Socket socket;
		  SocketThread(Server server, Socket socket ) {
		    this.socket = socket;
		  }
		
		  public void run(){
				try{
						
						PrintWriter out =
							new PrintWriter(this.socket.getOutputStream(), true); 
						
						BufferedReader in = new BufferedReader(
							new InputStreamReader(this.socket.getInputStream()));
						BufferedReader stdIn =
							new BufferedReader(
								new InputStreamReader(System.in));
						String inputLine;
						while ((inputLine = in.readLine()) != null) {							
								out.println(inputLine);
								System.out.println("Client: " + inputLine);							
						}
						String userInput;
			            while ((userInput = stdIn.readLine()) != null) {
			                   out.println(userInput);
			                   System.out.println("echo from server: " + in.readLine());
			            }

					}
					catch (IOException e)
					{
						System.out.println(e);
					}
			}
}