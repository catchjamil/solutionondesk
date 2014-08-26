package com.gl.main;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.poi.hslf.model.TextBox;


public class AdminConsole extends JFrame implements ActionListener {

	
	String query;
	Container con;
	JPanel panel=new JPanel();
	JLabel index=new JLabel("Report");
	JLabel queryLbl=new JLabel("Query:");
	JLabel aspectLbl=new JLabel("Aspect Name:");
	JTextField aspectTxt=new JTextField();
	TextArea queryTxt=new TextArea(5,70);
	TextArea messageBox = new TextArea(35,120);
	JButton submit=new JButton("Submit");
	JButton exit=new JButton("Exit");
	CheckboxGroup cg1 =new CheckboxGroup();
	Checkbox objectID =    new Checkbox("Object ID", cg1, true);
	Checkbox cmisQuery = new Checkbox("Report", cg1, false);
	Checkbox addAspect =    new Checkbox("Add Aspect", cg1, false);
	Checkbox deleteAspect = new Checkbox("Delete Aspect", cg1, false);
	Checkbox listAspect = new Checkbox("Aspect List", cg1, false);
	 
	public static void main(String[] args) {
		new AdminConsole();
	}
	
	
	public AdminConsole() {
		
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Report");
		setBounds(125, 50, 800, 600);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 760,540);
	    panel.setBorder(new TitledBorder("Admin Page"));
	    panel.setBackground(Color.WHITE);
	    
	    CheckboxGroup cg1=new CheckboxGroup();
	    panel.add(objectID);
	    panel.add(cmisQuery);
	    panel.add(addAspect);
	    panel.add(deleteAspect);
	    panel.add(listAspect);
	    panel.add(index);
	    panel.add(queryLbl);
	    panel.add(aspectLbl);
	    panel.add(queryTxt);
	    panel.add(aspectTxt);
	    panel.add(submit);
	    panel.add(exit);
	    
		Font font=new Font("Bookman Old Style",1,15);
	   
		objectID.setBounds(100, 40, 75, 30);
		cmisQuery.setBounds(200, 40, 100, 30);
		addAspect.setBounds(300, 40, 100, 30);
		deleteAspect.setBounds(400, 40, 100, 30);
		listAspect.setBounds(500, 40, 100, 30);
		
	    queryLbl.setBounds(150, 90, 150, 30);
	    
	    queryTxt.setBounds(150, 120, 550, 110);
	    aspectLbl.setBounds(150, 250, 150, 30);
	    aspectTxt.setBounds(250, 250, 400, 25);
	    submit.setBounds(200, 450, 125, 50);
	    exit.setBounds(350, 450, 125, 50);
	    
	    index.setFont(new Font("Bookman Old Style",1,18));
	    
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

			Session session = CMISManager.getSession();
			try{
			String value = queryTxt.getText();
			String aspectName = aspectTxt.getText();
			messageBox.setBackground(Color.WHITE);
			messageBox.setEditable(false);
			String message = null;
			if(objectID.getState() ==true){
				 message = cmisManager.documentActions(session,value,aspectName,"objectPath");
				messageBox.setText(message);
				JOptionPane.showMessageDialog(this ,messageBox);
			}else if(cmisQuery.getState() == true){
				 message = cmisManager.generateReport(session,value);
				 messageBox = new TextArea(5,70);
				message = "Report is generated at "+message;
				messageBox.setText(message);
				JOptionPane.showMessageDialog(this ,messageBox);
				
			}else if(addAspect.getState() == true){
				 message = cmisManager.documentActions(session,value,aspectName,"add");
				messageBox.setText(message);
				JOptionPane.showMessageDialog(this ,messageBox);

			}else if(deleteAspect.getState() == true){
				message = cmisManager.documentActions(session,value,aspectName,"remove");
				messageBox.setText(message);
				JOptionPane.showMessageDialog(this ,messageBox);
				
			}else if(listAspect.getState() == true){
				 message = cmisManager.documentActions(session,value,aspectName,"listAspects");
				
				 messageBox = new TextArea(35,70);
				 messageBox.setText(message);
				JOptionPane.showMessageDialog(this ,messageBox);
			}
			
			
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
