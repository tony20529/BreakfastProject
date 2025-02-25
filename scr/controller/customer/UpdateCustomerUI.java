package controller.customer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.MenuUI;
import model.Customer;
import service.impl.CustomerServiceImpl;
import util.RegularTool;
import util.Tool;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdateCustomerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;
	private JTextField age;
	private JTextField mobile;
	public static Customer customer=(Customer)Tool.read("customer.txt");
	private static CustomerServiceImpl customerserviceimpl=new CustomerServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomerUI frame = new UpdateCustomerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateCustomerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("基本資料");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 40));
		lblNewLabel.setBounds(128, 27, 183, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 161, 80, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(63, 228, 80, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(63, 295, 80, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("性別:");
		lblNewLabel_1_3.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(63, 362, 80, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("年齡:");
		lblNewLabel_1_4.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(63, 429, 80, 34);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("電話:");
		lblNewLabel_1_5.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(63, 496, 80, 34);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("地址:");
		lblNewLabel_1_6.setFont(new Font("標楷體", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(63, 563, 80, 34);
		contentPane.add(lblNewLabel_1_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 568, 286, 52);
		contentPane.add(scrollPane);
		
		JTextArea address = new JTextArea(customer.getAddress());
		scrollPane.setViewportView(address);
		
		JComboBox gender = new JComboBox();
		gender.setBackground(new Color(255, 255, 255));
		gender.addItem("男");
		gender.addItem("女");
		gender.setBounds(138, 369, 96, 23);
		contentPane.add(gender);
		gender.setSelectedItem(customer.getGender());
		
		name = new JTextField(customer.getName());
		name.setBounds(138, 169, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField(customer.getUsername());
		username.setColumns(10);
		username.setBounds(138, 236, 96, 21);
		contentPane.add(username);
		
		password = new JPasswordField(customer.getPassword());
		password.setColumns(10);
		password.setBounds(138, 303, 96, 21);
		contentPane.add(password);
		
		age = new JTextField(customer.getAge());
		age.setColumns(10);
		age.setBounds(138, 437, 96, 21);
		contentPane.add(age);
		
		mobile = new JTextField(customer.getMobile());
		mobile.setColumns(10);
		mobile.setBounds(138, 504, 178, 21);
		contentPane.add(mobile);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	if(RegularTool.AddName(name.getText())) {JOptionPane.showMessageDialog(null,"名字請輸入2-6個中文字或1-10個英文字母","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddUsername(username.getText())) {JOptionPane.showMessageDialog(null,"帳號請輸入6-10個英文或數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddAge(age.getText())){JOptionPane.showMessageDialog(null,"請輸入真實年齡","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddMobile(mobile.getText())) {JOptionPane.showMessageDialog(null,"請輸入真實手機號碼","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddAddress(address.getText())){JOptionPane.showMessageDialog(null,"請輸入完整聯絡地址","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else {
					if(customer.getPassword().trim().equals(password.getText().trim())) {
						String newname=name.getText();
						String newusername=username.getText();
						String newgender=gender.getSelectedItem().toString();
						String newage=age.getText();
						String newmobile=mobile.getText();
						String newaddress=address.getText();
						if(newusername.equals(customer.getUsername())) {
							Customer c=new Customer(customer.getId(),customer.getNumber(),customer.getIntodate(),newname,newusername,customer.getPassword(),newgender,newage,newmobile,newaddress);
							customerserviceimpl.update(c); 
							Tool.save(c, "customer.txt");
							JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
						else {
							if(!customerserviceimpl.isUsernameBeenUse(newusername)){JOptionPane.showMessageDialog(null,"帳號已經被申請過了","超級城堡",JOptionPane.PLAIN_MESSAGE);}
							else {
								Customer c=new Customer(customer.getId(),customer.getNumber(),customer.getIntodate(),newname,newusername,customer.getPassword(),newgender,newage,newmobile,newaddress);
								customerserviceimpl.update(c); 
								Tool.save(c, "customer.txt");
								JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
							}
						}
						
					else {
						if(RegularTool.AddPassword(password.getText())){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
						else{
							String newname=name.getText();
							String newusername=username.getText();
							String newpassword=Tool.encrypt(password.getText());
							String newgender=gender.getSelectedItem().toString();
							String newage=age.getText();
							String newmobile=mobile.getText();
							String newaddress=address.getText();
							if(newusername.equals(customer.getUsername())) {
								Customer c=new Customer(customer.getId(),customer.getNumber(),customer.getIntodate(),newname,newusername,newpassword,newgender,newage,newmobile,newaddress);
								customerserviceimpl.update(c);
								Tool.save(c, "customer.txt");
								JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
							else {
								if(!customerserviceimpl.isUsernameBeenUse(newusername)){JOptionPane.showMessageDialog(null,"帳號已經被申請過了","超級城堡",JOptionPane.PLAIN_MESSAGE);}
								else {
									Customer c=new Customer(customer.getId(),customer.getNumber(),customer.getIntodate(),newname,newusername,newpassword,newgender,newage,newmobile,newaddress);
									customerserviceimpl.update(c); 
									Tool.save(c, "customer.txt");
									JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
								} 
						}
					}
				}
			}
		});
		btnNewButton.setBounds(134, 630, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUI menu=new MenuUI();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 10, 87, 23);
		contentPane.add(btnNewButton_1);
	}
}
