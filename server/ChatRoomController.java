package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;

public class ChatRoomController {
		public int port;
		public String host;
		public String username;
		public ChatRoomView view;
		
		public ChatRoomController(){
			view = new ChatRoomView(this);
		}
		
		public ChatRoomController(ChatRoomView view){
		    view = view;
	
		} 
		public void ButtonListenerHost(){
			view.HostView(this);
		}
	    public void ButtonListenerStart(){
		       System.out.println(username);
	            new Thread(new Runnable() {
	            	public void run() {
	            		try {
	                		server.Server chat = new server.Server(port);
	            		} catch (IOException e) {
	            			e.printStackTrace();
	            		}
	            	}
	            }).start();
	    		
	            new Thread(new Runnable() {
	            	public void run() {
	            		Client host = new Client ("localhost", port, username);
	            	}
	            }).start();
			
		}    
	    
		public void ButtonListenerJoin(){
	        view.JoinView(this);		
	    }
		
		public void ButtonListenerJoinC(){
		
			//System.out.println("host " + host + " port " + port + " username " + username);
			Client client = new Client(host, port, username);
			
		}
	
	}	


