package server;


import client.*;
import java.net.*;
import java.io.*;
import java.util.*;
import chatroom.*;

public class Server implements Runnable{
	//server class
	//x2
	Socket sSocket;
	Server(Socket socket){
		this.sSocket = socket;
	}
	
	
	public static void main(String[] args) throws IOException {
		int port;
		if (args.length != 1) {
			Scanner scanner = new Scanner(System.in);
            System.out.println("Enter port number: ");
            port = scanner.nextInt(); 
            scanner.close();
        }
		else
		{
	        port = Integer.parseInt(args[0]);
		}
		
		ServerSocket serverSocket  = new ServerSocket(port);
		while (true){			
			Socket socket = serverSocket.accept();
			new Thread(new Server(socket)).start();
		}		
	}
	
	public void run(){
		try{
				
				PrintWriter out =
					new PrintWriter(this.sSocket.getOutputStream(), true); 
				
				BufferedReader in = new BufferedReader(
					new InputStreamReader(this.sSocket.getInputStream()));
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
