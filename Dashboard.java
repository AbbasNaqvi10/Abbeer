/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{
	
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
        setSize(1950,1000);
        setLocation(0,0);
        
        setLayout(null);
        setForeground(Color.CYAN);
        setLayout(null); 
        

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/p3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel AirlineManagementSystem = new JLabel(" WELCOME TO ASM ");
	AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
	AirlineManagementSystem.setBounds(750, 60, 1000, 85);
	NewLabel.add(AirlineManagementSystem);
		
	
        JButton btnNewEmployee = new JButton("ADD EMPLOYEE");
		btnNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                 new AddEmployee().setVisible(true);
				
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewEmployee.setBounds(900, 200, 200, 30);
                btnNewEmployee.setBackground(Color.BLACK);
                btnNewEmployee.setForeground(Color.WHITE);
		add(btnNewEmployee);
		
		 JButton btnNewRoom = new JButton("ADD ROOM");
		btnNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                 new AddRoom().setVisible(true);
				
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewRoom.setBounds(900, 250, 200, 30);
                btnNewRoom.setBackground(Color.BLACK);
                btnNewRoom.setForeground(Color.WHITE);
		add(btnNewRoom);

		JButton btnReception = new JButton("RECEPTION");
		btnReception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                new Reception().setVisible(true);
				
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnReception.setBounds(900, 300, 200, 30);
                btnReception.setBackground(Color.BLACK);
                btnReception.setForeground(Color.WHITE);
		add(btnReception);

    }
}
