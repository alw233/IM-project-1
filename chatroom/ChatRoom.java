package chatroom;

import client.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatRoom {
	public ServerSocket serverSocket;
	public ArrayList<Client> clientSockets;
	Client newClient;
	
	public ChatRoom(int portNumber) throws IOException
	{
		serverSocket = new ServerSocket(portNumber);
		clientSockets = new ArrayList<Client>();
	}
	
	public void addClient() throws IOException {
		
		newClient = new Client(serverSocket.accept());
		clientSockets.add(newClient);
	}
	
}
