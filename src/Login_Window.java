import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Login_Window implements ActionListener{
	JButton exitb,loginb,register;
	JPasswordField passwordt,passwordtr;
	JTextField usernamet,usernametr;
	JButton registerb;
	JFrame window;
	JFrame registerwin;
	
	public void windowlayout() {
		window=new JFrame();
		window.setLayout(null);
	
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,500,450);
		p.setBackground(Color.white);
		window.add(p);
		ImageIcon icon=new ImageIcon("E:/javaproject/Restaurant_Billing_System/Icons/restaurant.png");
		JLabel l=new JLabel(icon);
		l.setBounds(0,0,500,150);
		p.add(l);
		

		JLabel login=new JLabel("Member Login");
		login.setForeground(Color.black);
		login.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		login.setBounds(10,170,180,25);
		p.add(login);
		
		JLabel username=new JLabel("Username");
		username.setForeground(Color.blue);
		username.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		username.setBounds(10,210,180,25);
		p.add(username);
		
		usernamet=new JTextField();
		usernamet.setBounds(200,210,180,25);
		p.add(usernamet);
		
		JLabel password=new JLabel("Password");
		password.setForeground(Color.blue);
		password.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		password.setBounds(10,245,180,25);
		p.add(password);
		
		passwordt=new JPasswordField();
		passwordt.setBounds(200,245,180,25);
		p.add(passwordt);
		
		loginb=new JButton("Login");
		loginb.setBackground(Color.green);
		loginb.setBounds(20,300,80,25);
		p.add(loginb);
		loginb.addActionListener(this);
		
		exitb=new JButton("Exit");
		exitb.setBackground(Color.red);
		exitb.setForeground(Color.white);
		exitb.setBounds(120,300,80,25);
		p.add(exitb);
		exitb.addActionListener(this);
		
		register=new JButton("Register new Account");
		register.setBackground(Color.blue);
		register.setForeground(Color.white);
		register.setBounds(15,350,180,25);
		p.add(register);
		register.addActionListener(this);
		
		window.setSize(500,450);
		window.setLocation(400,100);
		window.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void registerWindow() {
		registerwin=new JFrame();
		registerwin.setLayout(null);
		
		JLabel username=new JLabel("Username");
		username.setForeground(Color.blue);
		username.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		username.setBounds(10,10,100,25);
		registerwin.add(username);
		
		usernametr=new JTextField();
		usernametr.setBounds(110,10,180,25);
		registerwin.add(usernametr);
		
		JLabel password=new JLabel("Password");
		password.setForeground(Color.blue);
		password.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		password.setBounds(10,45,180,25);
		registerwin.add(password);
		
		passwordtr=new JPasswordField();
		passwordtr.setBounds(110,45,180,25);
		registerwin.add(passwordtr);
		
		registerb=new JButton("Register");
		registerb.setBounds(100,120,100,25);
		registerb.setBackground(Color.green);
		registerwin.add(registerb);
		registerb.addActionListener(this);
		
		registerwin.setSize(350,200);
		registerwin.setLocation(300,100);
		registerwin.setDefaultCloseOperation(registerwin.DISPOSE_ON_CLOSE);
		registerwin.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==register) 
		{
			registerWindow();
		}
		if(e.getSource()==exitb) {
			window.dispose();
		}
		if(e.getSource()==loginb) 
		{
			Boolean registercheck;
			SqlCode sql=new SqlCode();
			registercheck=sql.userlogin(usernamet.getText(),passwordt.getText());
			if(registercheck==true) {
				window.dispose();
				MainWindow mainwin=new MainWindow();
				mainwin.mainwinlayout();
			}
			else {
				JOptionPane.showMessageDialog(window, "Invalid username or password");
			}
		}
		
		if(e.getSource()==registerb) 
		{
			Boolean check;
			String name=usernametr.getText();
			String password=passwordtr.getText();
			SqlCode sql=new SqlCode();
			check=sql.registeraccount(name,password);
			if(check==true) {
				JOptionPane.showMessageDialog(window, "Account Created");
				registerwin.dispose();
			}
			else {
				JOptionPane.showMessageDialog(registerwin, "Acoount not created");
			}
		}
	}
	
	
}
