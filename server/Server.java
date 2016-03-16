package server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
	public ServerSocket serverSocket;
	public ArrayList<Client> clientSockets;
	Client newClient;
	
	public Server(Integer portNumber) throws IOException
	{
		serverSocket = new ServerSocket(portNumber);
		clientSockets = new ArrayList<Client>();
		
		runChatRoom();
	}
	
	public void addClient() throws IOException {
		
		newClient = new Client(serverSocket.accept());
		clientSockets.add(newClient);
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
			new PrintWriter(clientSockets.get(i).clientSocket.getOutputStream(), true).println(inputLine);
		}
		System.out.println("Client: " + inputLine);

	}
	
	public void runChatRoom() throws IOException {
		startChatRoom();

						
		new Thread(new Runnable() {
			public void run() {

					while (clientSockets.size() == 0)
					{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e)
						{
							//nothing?
						}
					}
					System.out.println("starting thread 2");
					try {
						while (true)
						{
							for (int i = 0; i < clientSockets.size(); i++)
							{
								receiveMessage(clientSockets.get(i));
							}
						}
					} catch (IOException e)
					{
						e.printStackTrace();
					}

			}
		}).start();
		
		try {
			System.out.println("starting thread 1");
			while (true)
			{
				addClient();
				System.out.println("One client added in.");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public void startChatRoom() {
		System.out.println("Initializing chat room....");
		System.out.println("Waiting for clients....");
	}
}