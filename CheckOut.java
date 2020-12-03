/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckOut extends JFrame{
	
	private JPanel contentPane;
	private JTextField t1;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/p6.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                Connection c=null;
                    PreparedStatement s=null;
                    ResultSet rs=null; 
                c1 = new Choice();
                try{
                 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  
            c =DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\HAIDER\\Documents\\HMS.accdb");
            String sql="select * from customer";
            s=c.prepareStatement(sql);
            rs=s.executeQuery();
            
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                l2.addActionListener(new ActionListener(){
                    Connection c=null;
                    PreparedStatement s=null;
                    ResultSet rs=null; 
                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  
            c =DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\HAIDER\\Documents\\HMS.accdb");  
                           
                            String number = c1.getSelectedItem();
                            String str="select * from customer where number = "+number;
                            s=c.prepareStatement(str);
                            rs=s.executeQuery();
                           
                            
                            if(rs.next()){
                                System.out.println("clicked");
                                t1.setText(rs.getString("roomnumber"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                

		
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    Connection c=null;
                    PreparedStatement s=null;
                    PreparedStatement s2=null;
                    ResultSet rs=null;
                    String number = c1.getSelectedItem().toString();
                                String s1 = t1.getText();
				String deleteSQL = "delete from customer where number= "+number;
                                String q2 = "update room set availability = 'Available' where roomnumber = "+s1;

	    		try{
	    			
                            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  
                            c =DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\HAIDER\\Documents\\HMS.accdb");
                            s=c.prepareStatement(deleteSQL);
                            s.executeUpdate();
                            s2=c.prepareStatement(q2);
                            s2.executeUpdate();
	    			
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
                                
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}   catch (ClassNotFoundException ex) {
                                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}