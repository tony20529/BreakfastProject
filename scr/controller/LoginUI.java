package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.customer.AddCustomerUI;
import model.Customer;
import model.Employee;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("超級城堡");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 36));
		lblNewLabel.setBounds(133, 20, 195, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(97, 102, 72, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(97, 142, 72, 30);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(155, 105, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(155, 145, 96, 21);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameInput = username.getText();
		        String passwordInput = null;
		        try {
		        	passwordInput = Tool.encrypt(password.getText());
		            Customer customer=new CustomerServiceImpl().Login(usernameInput, passwordInput);
		            if(customer !=null) {
		            	try {
		            	Tool.save(customer, "customer.txt");
		            	JOptionPane.showMessageDialog(null,"歡迎"+customer.getName()+"登入成功","超級城堡",JOptionPane.PLAIN_MESSAGE);
		            	MenuUI menu=new MenuUI();
		            	menu.setVisible(true);
		            	dispose();
		            	
		            	}catch (Exception saveException) {
		                    JOptionPane.showMessageDialog(null, "保存用戶訊息失敗： " + saveException.getMessage(), "超級城堡", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        else {JOptionPane.showMessageDialog(null,"帳號或密碼有錯誤","超級城堡",JOptionPane.PLAIN_MESSAGE);}
		        	}
		        catch (Exception encryptException) {
		            JOptionPane.showMessageDialog(null, "密碼加密失敗: " + encryptException.getMessage(), "超級城堡", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnNewButton.setBounds(130, 182, 70, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("資料庫連接");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDbCUI dcb=new LoginDbCUI();
				dcb.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(322, 10, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("後台登入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameInput = username.getText();
		        String passwordInput = null;
		        try {
		        	passwordInput = Tool.encrypt(password.getText());
		            Employee employee=new EmployeeServiceImpl().Login(usernameInput, passwordInput);
		            if(employee !=null) {
		            	try {
		            	Tool.save(employee, "employee.txt");
		            	JOptionPane.showMessageDialog(null,"歡迎"+employee.getName()+"登入成功","超級城堡",JOptionPane.PLAIN_MESSAGE);
		            	ManageUI manage=new ManageUI();
						manage.setVisible(true);
						dispose();
		            	
		            	}catch (Exception saveException) {
		                    JOptionPane.showMessageDialog(null, "保存用戶訊息失敗： " + saveException.getMessage(), "超級城堡", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        else {JOptionPane.showMessageDialog(null,"帳號或密碼有錯誤","超級城堡",JOptionPane.PLAIN_MESSAGE);}
		        	}
		        catch (Exception encryptException) {
		            JOptionPane.showMessageDialog(null, "密碼加密失敗: " + encryptException.getMessage(), "超級城堡", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnNewButton_2.setBounds(290, 182, 96, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("註冊");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerUI addcustomer=new AddCustomerUI();
				addcustomer.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(211, 182, 70, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel clock = new JLabel(Tool.getTime());
		clock.setForeground(new Color(0, 100, 0));
		clock.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		clock.setBounds(221, 223, 205, 30);
		contentPane.add(clock);
		class ClockRunnable implements Runnable
		{@Override
		public void run() {
		while (true) {
			clock.setText(Tool.getTime()) ;
			try
			{Thread.sleep(1000);}
			catch(InterruptedException e)
			{e.printStackTrace ();}}}}
		
				
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				new Thread(new ClockRunnable()).start();
			}
		});
	}
}

