
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow implements ActionListener{
	String[] foods=null;
	int[] price=null;
	int j=50;
	Button btnstart;
	int total=0;
	JCheckBox buttons,buttons1,buttons2,buttons3,buttons4,buttons5,buttons6;
	JCheckBox buttonsd,buttons1d,buttons2d,buttons3d,buttons4d,buttons5d,buttons6d;
	int[] priceofdrinks=null;
	String[] drinks=null;
	JButton totalbutton;
	JTextArea area;
	JRadioButton r1,r2;
	JFrame mainwin;
	
	public void mainwinlayout() {
		mainwin=new JFrame();
		mainwin.setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setBounds(0,0,500,300);
		mainwin.add(panel);
		
		JLabel fooditem=new JLabel("Food Items Name");
		fooditem.setBounds(30,10,180,25);
		panel.add(fooditem);
		
		ButtonGroup group=new ButtonGroup();
		SqlCode sql=new SqlCode();
		foods=sql.fooditems();
		price=sql.pricename();
		int number=foods.length;
		
		for(int i=0;i<price.length;i++) {
			
			String a=String.valueOf(price[i]);
			JLabel labels=new JLabel(a);
			labels.setBounds(140,j,120,25);
			panel.add(labels);
			j+=35;
			
		}
//		ButtonsListeners listener=new ButtonsListeners();
		buttons=new JCheckBox(foods[0]);
		buttons.setBounds(10,50,120,25);
		panel.add(buttons);
		buttons.addActionListener(this);
		
		buttons1=new JCheckBox(foods[1]);
		buttons1.setBounds(10,85,120,25);
		panel.add(buttons1);
		buttons1.addActionListener(this);
		
		buttons2=new JCheckBox(foods[2]);
		buttons2.setBounds(10,120,120,25);
		panel.add(buttons2);
		buttons2.addActionListener(this);
		
		buttons3=new JCheckBox(foods[3]);
		buttons3.setBounds(10,155,120,25);
		panel.add(buttons3);
		buttons3.addActionListener(this);
		
		buttons4=new JCheckBox(foods[4]);
		buttons4.setBounds(10,190,120,25);
		panel.add(buttons4);
		buttons4.addActionListener(this);
		
		buttons5=new JCheckBox(foods[5]);
		buttons5.setBounds(10,225,120,25);
		panel.add(buttons5);
		buttons5.addActionListener(this);
		
		buttons6=new JCheckBox(foods[6]);
		buttons6.setBounds(10,260,120,25);
		panel.add(buttons6);
		buttons6.addActionListener(this);
		
		
		JLabel drinkitem=new JLabel("Drinks Items Name");
		drinkitem.setBounds(240,10,180,25);
		panel.add(drinkitem);
		
		SqlCode sql1=new SqlCode();
		priceofdrinks=sql.priceofdrinks();
		drinks=sql1.drinkitems();
		int number1=priceofdrinks.length;
		int k=50;
		for(int i=0;i<priceofdrinks.length;i++) {
			
			String b=String.valueOf(priceofdrinks[i]);
			JLabel labels1=new JLabel(b);
			labels1.setBounds(360,k,120,25);
			panel.add(labels1);
			k+=35;
			
		}
		
		buttonsd=new JCheckBox(drinks[0]);
		buttonsd.setBounds(220,50,130,25);
		panel.add(buttonsd);
		buttonsd.addActionListener(this);
		
		buttons1d=new JCheckBox(drinks[1]);
		buttons1d.setBounds(220,85,120,25);
		panel.add(buttons1d);
		buttons1d.addActionListener(this);
		
		buttons2d=new JCheckBox(drinks[2]);
		buttons2d.setBounds(220,120,120,25);
		panel.add(buttons2d);
		buttons2d.addActionListener(this);
		
		buttons3d=new JCheckBox(drinks[3]);
		buttons3d.setBounds(220,155,120,25);
		panel.add(buttons3d);
		buttons3d.addActionListener(this);
		
		buttons4d=new JCheckBox(drinks[4]);
		buttons4d.setBounds(220,190,120,25);
		panel.add(buttons4d);
		buttons4d.addActionListener(this);
		
		buttons5d=new JCheckBox(drinks[5]);
		buttons5d.setBounds(220,225,120,25);
		panel.add(buttons5d);
		buttons5d.addActionListener(this);
		
		buttons6d=new JCheckBox(drinks[6]);
		buttons6d.setBounds(220,260,120,25);
		panel.add(buttons6d);
		buttons6d.addActionListener(this);
		
		totalbutton=new JButton("Total");
		totalbutton.setBounds(20,340,80,25);
		mainwin.add(totalbutton);
		totalbutton.addActionListener(this);
		
		area=new JTextArea();
		area.setBounds(120,340,80,30);
		area.setEditable(false);
		mainwin.add(area);
		
		ButtonGroup groups=new ButtonGroup();
		
		r1=new JRadioButton("Paid");
		r1.setBounds(50,380,80,30);
		mainwin.add(r1);
		
		r2=new JRadioButton("Not Paid");
		r2.setBounds(140,380,80,30);
		mainwin.add(r2);
		groups.add(r1);
		groups.add(r2);
		
		
		
		mainwin.setSize(500,500);
		mainwin.setLocation(150,50);
		mainwin.setDefaultCloseOperation(mainwin.EXIT_ON_CLOSE);
		mainwin.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(buttons.isSelected()) {
			System.out.println("good");
			total=total+price[0];
		}
		
		if(buttons1.isSelected()) {
			total=total+price[1];
		}
		if(buttons2.isSelected()) {
			total=total+price[2];
		}
		if(buttons3.isSelected()) {
			total=total+price[3];
		}
		if(buttons4.isSelected()) {
			total=total+price[4];
		}
		if(buttons5.isSelected()) {
			total=total+price[5];
		}
		if(buttons6.isSelected()) {
			total=total+price[6];
		}
		if(buttonsd.isSelected()) {
			total=total+priceofdrinks[0];
		}
		if(buttons1d.isSelected()) {
			total=total+priceofdrinks[1];
		}
		if(buttons2d.isSelected()) {
			total=total+priceofdrinks[2];
		}
		if(buttons3d.isSelected()) {
			total=total+priceofdrinks[3];
		}
		if(buttons4d.isSelected()) {
			total=total+priceofdrinks[4];
		}
		if(buttons5d.isSelected()) {
			total=total+priceofdrinks[5];
		}
		if(buttons6d.isSelected()) {
			total=total+priceofdrinks[6];
			if(r1.isSelected()) {
				JOptionPane.showMessageDialog(mainwin, "Paid");
				
			}
			else if(r2.isSelected()) {
				JOptionPane.showMessageDialog(mainwin,"Not Paid");
			}
		}
		if(e.getSource()==totalbutton) {
			String sum=String.valueOf(total);
			area.setText(sum);
		}
		
	}
}
