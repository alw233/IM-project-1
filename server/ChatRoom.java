package server;

import java.io.*;

import java.util.Scanner;


public class ChatRoom {

	public static void main(String[] args) throws IOException {
		
		
		ChatRoomController controller = new ChatRoomController();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Start a chatroom or join one (s/j)");
//		String choice = scanner.next();
//		
//		if (choice.equals("s")) {
//            System.out.print("Enter port number: ");
//            final Integer port = scanner.nextInt(); 
//            
//            System.out.print("Pick a username: ");
//            final String userName = scanner.next();
//            
//            new Thread(new Runnable() {
//            	public void run() {
//            		try {
//                		server.Server chat = new server.Server(port);
//            		} catch (IOException e) {
//            			e.printStackTrace();
//            		}
//            	}
//            }).start();
//    		
//            new Thread(new Runnable() {
//            	public void run() {
//            		Client host = new Client ("localhost", port, userName);
//            	}
//            }).start();
//		}
//		else if (choice.equals("j"))
//		{
//			System.out.print("Enter host name: ");
//			String hostName = scanner.next();
//			System.out.print("Enter port number: ");
//			Integer port = scanner.nextInt();
//			System.out.print("Pick a username: ");
//			String userName = scanner.next();
//			Client client = new Client(hostName, port, userName);
//		}
//		else
//		{
//			System.out.println("Invalid choice");
//		}
	}
}