package server;

import java.io.*;
import chatroom.*;
import java.util.Scanner;

public class Server {
	//server class
	//x2
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
		
		chatroom.ChatRoom chat = new ChatRoom(port);
		chatroom.ChatRoomView chatView = new ChatRoomView();
		chatroom.ChatRoomController controller =
				new ChatRoomController(chat, chatView);

	}
}
