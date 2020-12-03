/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.beans.*;


public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/p2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }

    public void actionPerformed(ActionEvent ae){
    
    String u = t1.getText();
    String v = t2.getText();
    Connection c=null;
    PreparedStatement s=null;
    ResultSet rs=null; 
    
        if(ae.getSource()==b1){
  

        try{  
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  
            c =DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\HAIDER\\Documents\\HMS.accdb"); 
            
    
             if(u.equals("ahmed") && v.equals("badar")){
                
                
                Dashboard dd = new Dashboard();
                dd.setVisible(true);
                setVisible(false);
            
                }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
            //}
           
        }catch(Exception e){ 
            System.out.println(e);
        }
        }
   
       else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    
    public static void main(String[] arg){
        new Login();
    }
}
