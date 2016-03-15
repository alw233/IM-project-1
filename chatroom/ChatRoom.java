package chatroom;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatRoom {
	ServerSocket serverSocket;
	ArrayList<Socket> clientSockets;
	Socket client;
	
	public ChatRoom(int portNumber) throws IOException
	{
		serverSocket = new ServerSocket(portNumber);
		clientSockets = new ArrayList<Socket>();
	}
	
	public void addClient() throws IOException {
		client = serverSocket.accept();
		clientSockets.add(client);
	}
	
}
