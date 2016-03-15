package chatroom;

import java.io.*;

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
		this.model.addClient();
		/*Thread client = new Thread(new Runnable() {
			public void run() {
				try {
					model.addClient();
				} catch (IOException exception)
				{
					exception.printStackTrace();
				}
			}
		});
		client.start();*/
		
        PrintWriter out =
                new PrintWriter(model.clientSockets.get(0).getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(model.clientSockets.get(0).getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                System.out.println("client says: " + inputLine);
            }
	}
}
