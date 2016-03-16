package server;


import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatRoom {
	public ServerSocket serverSocket;
	public ArrayList<Socket> clientSockets;
	Socket newSocket;
	
	public ChatRoom(int portNumber) throws IOException
	{
		serverSocket = new ServerSocket(portNumber);
		clientSockets = new ArrayList<Socket>();
	}
	
	public void addClient() throws IOException {
		
		newSocket = serverSocket.accept();
		clientSockets.add(newSocket);
	}
	
	public void receiveMessage(Client c) throws IOException {
		BufferedReader in = new BufferedReader(
	                new InputStreamReader(c.clientSocket.getInputStream()));
		if (in.ready()) {
			sendMessage(in.readLine());
		}
	}
	
	public void sendMessage(String inputLine) throws IOException {
                 
		System.out.println("in send message");

		for (int i = 0; i < clientSockets.size(); i++)
		{
			new PrintWriter(clientSockets.get(i).getOutputStream(), true).println(inputLine);
		}
		System.out.println("Client: " + inputLine);

	}
	
}

