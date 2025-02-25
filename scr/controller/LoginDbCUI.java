package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import util.DbConnection;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginDbCUI extends LoginUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private static String A;
	private static String B;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDbCUI frame = new LoginDbCUI();
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
	public LoginDbCUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("連接資料庫");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 26));
		lblNewLabel.setBounds(68, 0, 252, 64);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(91, 66, 96, 21);
		contentPane.add(user);
		user.setColumns(10);
		user.setText("root");
		
		password = new JPasswordField();
		password.setBounds(91, 99, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		password.setText("1234");
		
		lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(35, 69, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(35, 102, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=user.getText();
				B=password.getText();
				Customer customer=new Customer(A,B);
            	Tool.save(customer, "Dbc.txt");
            	 Connection conn = DbConnection.getDb();
                 if (conn != null) {
                     // 連接成功
                     JOptionPane.showMessageDialog(LoginDbCUI.this, "資料連接成功！");
                     dispose();
                     
                 } else {
                     // 連接失敗，錯誤提醒
                     JOptionPane.showMessageDialog(LoginDbCUI.this, "您資料庫尚未連接成功", "超級城堡", JOptionPane.PLAIN_MESSAGE);
                 }
                 
				
                
			}
		});
		btnNewButton.setBounds(197, 99, 85, 23);
		contentPane.add(btnNewButton);
	}
	public static String User() {return A;}
	public static String Password() {return B;}
}
