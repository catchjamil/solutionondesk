package com.gl.main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class CMISManagerUI extends JFrame implements ActionListener {

	
	String Id,Password,Url;
	Container con;
	JPanel panel=new JPanel();
	JLabel index=new JLabel("Enter the Login ID And Password");
	JLabel userid=new JLabel("Enter User ID:");
	JLabel password=new JLabel("Enter Password:");
	JLabel url=new JLabel("URL:");
	JTextField useridTxt=new JTextField();
	JTextField urlTxt=new JTextField();
	JPasswordField passwordTxt=new JPasswordField();
	JButton submit=new JButton("Submit");
	JButton exit=new JButton("Exit");
	
	public static void main(String[] args) {
		
		new CMISManagerUI();
	}
	
	
	public CMISManagerUI() {
		
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		setBounds(125, 50, 800, 600);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 760,540);
	    panel.setBorder(new TitledBorder("Login Page"));
	    panel.setBackground(Color.lightGray);
	    
	    panel.add(index);
	    panel.add(userid);
	    panel.add(password);
	    panel.add(url);
	    useridTxt.setText("admin");
	    passwordTxt.setText("admin");
	    urlTxt.setText("http://172.16.115.22:8080");
	    panel.add(useridTxt);
	    panel.add(passwordTxt);
	    panel.add(urlTxt);
	    panel.add(submit);
	    panel.add(exit);
	    
		Font font=new Font("Bookman Old Style",1,15);
	   
		
		index.setBounds(260, 30, 350, 30);

		url.setBounds(150, 90, 250, 30);
		urlTxt.setBounds(300, 90, 250, 30);
	    userid.setBounds(150, 125, 125, 30);
	    useridTxt.setBounds(300, 125, 125, 30);
	    password.setBounds(150, 160, 175, 30);
	    passwordTxt.setBounds(300, 160, 125, 30);
	    submit.setBounds(200, 250, 125, 50);
	    exit.setBounds(350, 250, 125, 50);
	    
	    index.setFont(new Font("Bookman Old Style",1,18));
	    userid.setFont(font);
	    useridTxt.setFont(font);
	    password.setFont(font);
	    url.setFont(font);
	    passwordTxt.setFont(font);
	    urlTxt.setFont(font);
	    submit.setFont(font);
	    exit.setFont(font);
	    
	    submit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    exit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    setVisible(true);
	    
	    
	    submit.addActionListener(this);
	    exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand()=="Submit")
		{
			
			CMISManager cmisManager = new CMISManager();

			try{
			cmisManager.setUserName(useridTxt.getText());
			cmisManager.setPassword(passwordTxt.getText());
			cmisManager.setAtomPubUrl(urlTxt.getText());
			cmisManager.setSession(cmisManager.prepareSession());
			new AdminConsole();
			setVisible(false);
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(this ,e.getMessage());
			}
		}
		
		if(event.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
	}
	
	

}
