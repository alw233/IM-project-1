package client;
import chatroom.*;

import java.io.*;
import java.net.*;

public class Client {
	public Socket clientSocket;
	public static String hostName;
	public static int portNumber;
	public Client(Socket connection)
	{
		clientSocket = connection;
	}	
		
	
	
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        hostName = args[0];
        portNumber = Integer.parseInt(args[1]);
        
        runClient();
        
        
    }
       
    public static void runClient() throws IOException{
    	Thread sendMessage = new Thread (new Runnable(){
    		public void run(){
    			try {  	
	                Socket echoSocket = new Socket(hostName, portNumber);
	                PrintWriter out =
	                    new PrintWriter(echoSocket.getOutputStream(), true);
	                BufferedReader in =
	                    new BufferedReader(
	                        new InputStreamReader(echoSocket.getInputStream()));
	                BufferedReader stdIn = new BufferedReader(    
	                        new InputStreamReader(System.in));
	                String userInput;
	                while ((userInput = stdIn.readLine()) != null) {
	                    out.println(userInput);
	                    System.out.println("echo from server: " + in.readLine());
	                }
	                String inputLine;
					while ((inputLine = in.readLine()) != null) {							
							out.println(inputLine);
							System.out.println("Client: " + inputLine);							
					}
	            
	            } catch (UnknownHostException e) {
	                System.err.println("Don't know about host " + hostName);
	                System.exit(1);
	            } catch (IOException e) {
	                System.err.println("Couldn't get I/O for the connection to " +
	                    hostName);
	                System.exit(1);
	            } 
    		}
    	
    	});sendMessage.start();
    	
    }
}
//    	Thread recieveMessage = new Thread(new Runnable(){
//    		public void run(){
//    			try {
//					while (model.clientSockets.size() == 1)
//					{
//						System.out.println("here 2");
//						try {
//							Thread.sleep(100);
//						} catch (InterruptedException e)
//						{
//							//nothing?
//						}
//					}
//				
//				       PrintWriter out =
//				                new PrintWriter(model.clientSockets.get(1).clientSocket.getOutputStream(), true);                   
//				       BufferedReader in = new BufferedReader(
//				                new InputStreamReader(model.clientSockets.get(1).clientSocket.getInputStream()));
//				       String inputLine;
//				       while ((inputLine = in.readLine()) != null) {
//				    	   out.println(inputLine);
//				           System.out.println("Client: " + inputLine);
//				       }
//					}
//				 catch (IOException e)
//				{
//					System.out.println(e);
//				}	
//    		}
//    	});
//    		
//    	}

