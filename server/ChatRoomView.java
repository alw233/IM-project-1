package server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatRoomView extends JFrame {

    JLabel statusbar;
    JPanel panel;
    ChatRoomController c;

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
    
    public void HostView(ChatRoomController c){
    	
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
				c.port = Integer.parseInt(realPort);
				c.username = username.getText();
				c.ButtonListenerStart();	
				statusbar.setText("Starting Chat");
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
    
    public void JoinView(ChatRoomController c){
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
				c.host = host.getText();
				c.port = Integer.parseInt(realPort);
				c.username = username.getText();
				statusbar.setText("Joining Chat");
				c.ButtonListenerJoinC();	
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
    

    
}