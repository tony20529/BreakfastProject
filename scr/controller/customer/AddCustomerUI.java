package controller.customer;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Customer;
import service.impl.CustomerServiceImpl;
import util.RegularTool;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomerUI extends LoginUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;
	private JTextField age;
	private JTextField mobile;
	private static CustomerServiceImpl customerserviceimpl=new CustomerServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerUI frame = new AddCustomerUI();
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
	public AddCustomerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
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
		
		JTextArea address = new JTextArea();
		scrollPane.setViewportView(address);
		
		JComboBox gender = new JComboBox();
		gender.setBackground(new Color(255, 255, 255));
		gender.addItem("男");
		gender.addItem("女");
		gender.setBounds(138, 369, 96, 23);
		contentPane.add(gender);
		
		name = new JTextField();
		name.setBounds(138, 169, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(138, 236, 96, 21);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(138, 303, 96, 21);
		contentPane.add(password);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(138, 437, 96, 21);
		contentPane.add(age);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(138, 504, 178, 21);
		contentPane.add(mobile);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameinput=username.getText();
				String nameinput=name.getText();
				String passwordinput=password.getText();
				String genderinput=gender.getSelectedItem().toString();
				String addressinput=address.getText();
				String ageinput=age.getText();
				String mobileinput=mobile.getText();
				if(RegularTool.AddName(nameinput)) {JOptionPane.showMessageDialog(null,"名字請輸入2-6個中文字或1-10個英文字母","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddUsername(usernameinput)) {JOptionPane.showMessageDialog(null,"帳號請輸入6-10個英文或數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddPassword(passwordinput)){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddAge(ageinput)){JOptionPane.showMessageDialog(null,"請輸入真實年齡","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddMobile(mobileinput)) {JOptionPane.showMessageDialog(null,"請輸入真實手機號碼","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(RegularTool.AddAddress(addressinput)){JOptionPane.showMessageDialog(null,"請輸入完整聯絡地址","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(!customerserviceimpl.isUsernameBeenUse(usernameinput)){JOptionPane.showMessageDialog(null,"帳號已經被申請過了","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else{	
						passwordinput=Tool.encrypt(passwordinput);
						Customer customer=new Customer(customerserviceimpl.customerNumber(),Tool.getDate(),nameinput,usernameinput,passwordinput,genderinput,ageinput,mobileinput,addressinput);
						customerserviceimpl.add(customer);
						JOptionPane.showMessageDialog(null,"註冊成功，請重新登入","超級城堡",JOptionPane.PLAIN_MESSAGE);
						dispose();	
					}
			}
		});
		btnNewButton.setBounds(138, 628, 87, 23);
		contentPane.add(btnNewButton);
	}
}
