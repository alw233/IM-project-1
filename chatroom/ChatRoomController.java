package chatroom;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoomController {
	private ChatRoom model;
	private ChatRoomView view;
	
	public ChatRoomController(ChatRoom model, ChatRoomView view) throws IOException {
		this.model = model;
		this.view = view;
		runChatRoom();
	}
	
	public void runChatRoom() throws IOException {
		this.view.startChatRoom();

		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("starting thread 1");
					while (true)
					{
						model.addClient();
					}
				} catch (IOException e) {
					System.out.println(e);
				}

			}
		}).start();
				
		System.out.println("about to start thread 2");
		
		Thread message = new Thread(new Runnable() {
				public void run() {
					try {
						while (model.clientSockets.size() == 0)
						{
							try {
								Thread.sleep(100);
							} catch (InterruptedException e)
							{
								//nothing?
							}
						}
						System.out.println("starting thread 2");
				        PrintWriter out =
				                new PrintWriter(model.clientSockets.get(0).clientSocket.getOutputStream(), true);                   
				       BufferedReader in = new BufferedReader(
				                new InputStreamReader(model.clientSockets.get(0).clientSocket.getInputStream()));
				       String inputLine;
				       while ((inputLine = in.readLine()) != null) {
				    	   out.println(inputLine);
				           System.out.println("Client: " + inputLine);
				       }
					} catch (IOException e)
					{
						System.out.println(e);
					}
				}
			});
		message.start();



	}
}
