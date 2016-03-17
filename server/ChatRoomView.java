package server;

import java.io.*;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
public class ChatRoomView extends JFrame {

    JLabel statusbar;
    JPanel panel;
    ChatRoomController c;
    JTextArea chatMessages;
    JTextField typeMessageBox;

    public ChatRoomView(ChatRoomController cc) {
    	c = cc;
        initUI();
    }

    public final void initUI() {

        panel = new JPanel();
        statusbar = new JLabel("Welcome!");


        panel.setLayout(null);

        // Initialize buttons
        JButton host = new JButton("Host a Chat");
        JButton join = new JButton("Join a Chat");

        
        // Set button borders
        host.setBounds(40, 30, 150, 25);
        join.setBounds(40, 80, 150, 25);

  
        // Add action listeners to the buttons
        host.addActionListener(new ActionListener(){
   	
			@Override
			public void actionPerformed(ActionEvent e) {
				c.ButtonListenerHost();			
			}
        });
        join.addActionListener(new ActionListener(){
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				c.ButtonListenerJoin();			
			}
        });

        // Add buttons to panel
        panel.add(host);
        panel.add(join);
       

        // Add panel to JFrame
        add(panel);
        add(statusbar, BorderLayout.SOUTH);

        setTitle("Advanced Programming Chat");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public void HostView(ChatRoomController b){
    	
    	panel.removeAll();
    	panel.updateUI();
    

    	JTextArea port = new JTextArea("Port Number");
    	port.setBounds(40, 30, 150, 25);
    
    	
    	JTextArea username = new JTextArea("User Name");    	
    	username.setBounds(40, 60, 150, 25);	
  
       	
    	JButton start = new JButton("Start Chat");
    	start.setBounds(40, 150, 150, 25);
        start.addActionListener(new ActionListener(){
           	
			@Override
			public void actionPerformed(ActionEvent e) {
				String realPort = port.getText();
				b.port = Integer.parseInt(realPort);
				b.username = username.getText();
				b.ButtonListenerStart();	
				statusbar.setText("Started Chat");
			}
        });
    	
        // Add buttons to panel
        panel.add(start);
        panel.add(port);
        panel.add(username);       

        // Add panel to JFrame
        add(panel);
        add(statusbar, BorderLayout.SOUTH);

        setTitle("Advanced Programming Chat");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    	
    }
    
    public void JoinView(ChatRoomController b){
    	//textbox port number
    	//textbox host
    	//textbox username
    	
    	panel.removeAll();
    	panel.updateUI();
    	
    	JTextArea port = new JTextArea("Port Number");
    	port.setBounds(40, 30, 150, 25);
    
    	JTextArea host = new JTextArea("Host Number");
    	host.setBounds(40, 70, 150, 25);
    	
    	JTextArea username = new JTextArea("User Name");    	
    	username.setBounds(40, 110, 150, 25);	
    	
    	JButton join = new JButton("Join Chat");
    	join.setBounds(40, 160, 150, 25);   
        join.addActionListener(new ActionListener(){
           	
			@Override
			public void actionPerformed(ActionEvent e) {
				String realPort = port.getText();
				b.port = Integer.parseInt(realPort);
				b.username = username.getText();
				b.host = host.getText();
				b.ButtonListenerJoinC();	
				statusbar.setText("Joined Chat");
			}
        });
    	
    	
        // Add buttons to panel
        panel.add(join);
        panel.add(port);
        panel.add(username);  
        panel.add(host);

        // Add panel to JFrame
        add(panel);
        add(statusbar, BorderLayout.SOUTH);

        setTitle("Advanced Programming Chat");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    	
    }
    
    public ChatRoomView() {
    	//chatRoom();
        
    }
    
    public void chatRoom(ChatRoomController b) {
    	
    	panel.removeAll();
    	panel.updateUI();
    	
    	//panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
    	
    	
    	
    	chatMessages = new JTextArea();
    	chatMessages.setForeground(Color.BLACK);
    	JScrollPane scrollPane = new JScrollPane(chatMessages); 
    	
    	chatMessages.setEditable(false);
    	 GridBagConstraints c = new GridBagConstraints();
    	 c.insets = new Insets(20,20,20,20);
         c.gridwidth = GridBagConstraints.REMAINDER;
  
         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1;
         c.weighty = 1;
         panel.add(scrollPane, c);
         
         typeMessageBox = new JTextField();
         c.gridx = 0;
         c.weightx = .8;
         c.weighty = 0;
         c.gridwidth = 700;
         panel.add(typeMessageBox, c);
         
         Action action = new AbstractAction(){
        	 @Override
        	 public void actionPerformed(ActionEvent e){
        		 b.getSendButtonListener();
        	 }
         };
         
         JButton sendMessage = new JButton("Send");
         sendMessage.addActionListener(action);
         typeMessageBox.addActionListener(action);
         c.gridx = GridBagConstraints.RELATIVE;
         c.weightx = 0;
         panel.add(sendMessage, c);
         
    	add(panel);
    	
    	
        setTitle("Advanced Programming IM Chatroom");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    }
    
    void newMessage(String message) {
    	chatMessages.append(message);
    }
    
    void sendMessage() {
    	String message = typeMessageBox.getText();
    	InputStream toSocket = new ByteArrayInputStream(message.getBytes());
    	System.setIn(toSocket);
    	typeMessageBox.setText("");

    }
}

    
