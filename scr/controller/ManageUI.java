package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.customer.CustomerUI;
import controller.employee.EmployeeUI;
import controller.porder.PorderUI;
import controller.product.ProductUI;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUI frame = new ManageUI();
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
	public ManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("顧客管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUI customer=new CustomerUI();
				customer.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(88, 101, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("員工管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeUI employee=new EmployeeUI();
				employee.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(88, 149, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("後台管理");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 40));
		lblNewLabel.setBounds(113, 10, 198, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("產品管理");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductUI product=new ProductUI();
				product.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(208, 101, 87, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("訂單管理");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PorderUI porder=new PorderUI();
				porder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(208, 149, 87, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel clock = new JLabel(Tool.getTime());
		clock.setForeground(new Color(25, 25, 112));
		clock.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		clock.setBounds(88, 197, 278, 54);
		contentPane.add(clock);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(337, 218, 87, 23);
		contentPane.add(btnNewButton_2);
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
