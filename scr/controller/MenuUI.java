package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import controller.customer.UpdateCustomerUI;
import model.Customer;
import model.Employee;
import model.Porder;
import model.Product;
import service.impl.EmployeeServiceImpl;
import service.impl.PorderServiceImpl;
import service.impl.ProductServiceImpl;
import util.RegularTool;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static ProductServiceImpl productserviceimpl=new ProductServiceImpl();
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private static EmployeeServiceImpl employeeserviceimpl=new EmployeeServiceImpl();
	public  Customer customer=(Customer)Tool.read("customer.txt");
	public  Employee employee=(Employee)Tool.read("employee.txt");
	public static int totalSelectedAmount = 0; 
	private JTable table_1;
	private JLabel sum;
	private JTextField pay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
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
	public MenuUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("超級城堡MENU");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setBounds(246, 29, 310, 66);
		contentPane.add(lblNewLabel);
		
		List<Product> products=productserviceimpl.readMenu();
		String[] columnNames = {"產品編號", "產品名稱", "產品價格"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		
         
		
		for (Product product : products) {
            Object[] rowData = {product.getNumber(), product.getName(), product.getPrice()};
            tableModel.addRow(rowData);
        }
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 146, 428, 263);
		contentPane.add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel clock = new JLabel(Tool.getTime());
		clock.setForeground(new Color(34, 139, 34));
		clock.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 16));
		clock.setBounds(549, 0, 237, 45);
		contentPane.add(clock);
		
		JLabel lblNewLabel_1 = new JLabel("歡迎"+customer.getName()+"點餐");
		lblNewLabel_1.setBounds(10, 5, 237, 45);
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblNewLabel_1);
		
		String[] columnNames1 = {"產品名稱", "產品數量", "應付金額"};
		DefaultTableModel targetModel = new DefaultTableModel(0, columnNames1.length){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
	    targetModel.setColumnIdentifiers(columnNames1);
	    
		
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(473, 146, 254, 263);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(targetModel);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("加入購物車");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
	            if (selectedRow == -1) {
	            	JOptionPane.showMessageDialog(null,"請先選擇要加購的餐點","超級城堡",JOptionPane.PLAIN_MESSAGE);
	                return;
	                }
	                JLabel nameLabel = new JLabel();
	                nameLabel.setText(customer.getName());
	                String[] options = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		            JComboBox<String> amountComboBox = new JComboBox<>(options);
		            JPanel panel = new JPanel(new GridLayout(2, 2));
		            panel.add(new JLabel("顧客姓名: "));
		            panel.add(nameLabel);
		            panel.add(new JLabel("數量"));
		            panel.add(amountComboBox);
		            int result = JOptionPane.showConfirmDialog(null, panel, "餐點數量",
	                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		            if (result == JOptionPane.OK_OPTION) {
		            	
		            	int amount=Integer.parseInt(amountComboBox.getSelectedItem().toString());
		            	int[] selectedRows = table.getSelectedRows();
		            	if(amount==0) {}
		            	else {
		            		for (int row : selectedRows) {
		            			String productName = (String) table.getValueAt(row, 1);
		            			int productPrice = Integer.parseInt(table.getValueAt(row, 2).toString());
		            			int totalAmount = (int)amount * productPrice;
		            			boolean found = false;
		            			for (int i = 0; i < targetModel.getRowCount(); i++) {
		            				String existingProductName = (String) targetModel.getValueAt(i, 0);
		            				if (existingProductName.equals(productName)) {
		            					int existingAmount = (int) targetModel.getValueAt(i, 1);
		            					int existingTotalAmount = Integer.parseInt(targetModel.getValueAt(i, 2).toString());
		            					targetModel.setValueAt(existingAmount + amount, i, 1);
		            					targetModel.setValueAt(existingTotalAmount + totalAmount, i, 2);
		            					found = true;
		            					break;
		            				}
		            			}
		            			if (!found ) {
		            				Object[] rowData = {productName, amount, totalAmount};
		            				targetModel.addRow(rowData);
		            			}
		            			totalSelectedAmount += totalAmount;
		            		}
		            		JOptionPane.showMessageDialog(null,"加購完成","超級城堡",JOptionPane.PLAIN_MESSAGE);
		            	}
		            	
		            		sum.setText(customer.getName()+"的總金額是"+totalSelectedAmount+"元");
	                    
		              
		            }
		            
	            
			}
		});
		btnNewButton.setBounds(10, 430, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(customer.getName()+"的購物車");
		lblNewLabel_2.setForeground(new Color(75, 0, 130));
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_2.setBounds(545, 101, 175, 35);
		contentPane.add(lblNewLabel_2);
		
		sum = new JLabel(customer.getName()+"的訂單總金額是"+totalSelectedAmount+"元");
		sum.setForeground(new Color(75, 0, 130));
		sum.setFont(new Font("宋体", Font.BOLD, 14));
		sum.setBounds(473, 409, 254, 35);
		contentPane.add(sum);
		
		JLabel lblNewLabel_3 = new JLabel("支付金額:");
		lblNewLabel_3.setForeground(new Color(75, 0, 130));
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(473, 440, 98, 29);
		contentPane.add(lblNewLabel_3);
		
		pay = new JTextField("0");
		pay.setBounds(545, 445, 96, 21);
		contentPane.add(pay);
		pay.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(473, 479, 254, 114);
		contentPane.add(scrollPane_2);
		
		JTextArea output = new JTextArea();
		scrollPane_2.setViewportView(output);
		output.setEditable(false);
		
		
		JButton btnNewButton_1 = new JButton("結帳");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(employee == null || employee.getNumber() == null || employee.getNumber().isEmpty()) {employee=employeeserviceimpl.findByNumber("E00001"); return ;}
				if(RegularTool.AddInt(pay.getText()) || Integer.parseInt(pay.getText())<0){JOptionPane.showMessageDialog(null,"支付金額，請都輸入數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else if(Integer.parseInt(pay.getText()) < totalSelectedAmount) {JOptionPane.showMessageDialog(null,"您的支付金額不夠支付本訂單","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else {
					String show=customer.getName()+"的訂單\n---------------------------\n";
					for (int i = 0; i < targetModel.getRowCount(); i++) {
						String ProductName = (String) targetModel.getValueAt(i, 0);
						Product p=productserviceimpl.findByName(ProductName);
						int Amount = (int) targetModel.getValueAt(i, 1);
						productserviceimpl.updateInventory(p.getInventory()-Amount, p.getNumber());
						show+=ProductName+"\t"+ Amount+"個\n";
						 Porder o=new Porder(porderserviceimpl.porderNumber(),customer.getNumber(),p.getNumber(),Amount,employee.getNumber(),Tool.getTime1());
						 porderserviceimpl.add(o);
						 Tool.save(o, "porder.txt");
						}
					int count=Integer.parseInt(pay.getText())-totalSelectedAmount;
					show+="---------------------------\n"+customer.getName()+"總金額是"+totalSelectedAmount+"元\n"+"付款金額是"+pay.getText()+"元\n找零:"+count+"元\n---------------------------\n找給客戶\n";
					int[] denominations = {1000, 500, 100, 50, 10, 5, 1};
			        String[] denominationNames = {"一千圓鈔", "五百圓鈔", "一百圓鈔", "五十圓硬幣", "十圓硬幣", "五圓硬幣", "一圓硬幣"};

			        for (int i = 0; i < denominations.length; i++) {
			            int counto = count / denominations[i];
			            if (count >= 100 && counto>0) {
			                show+=denominationNames[i] + "：" + counto + " 張\n";
							count %= denominations[i];
			            }
			            else if (counto>0){
			            	show+=denominationNames[i] + "：" + counto + " 個\n";
							count %= denominations[i];
			            }
			            
			        }
			        output.setText(show);
			        JOptionPane.showMessageDialog(null,"交易完成，請等待訂單號碼，您的訂邊編號:"+porderserviceimpl.porderNumber(),"超級城堡",JOptionPane.PLAIN_MESSAGE);
			        while (targetModel.getRowCount() > 0) {
			            targetModel.removeRow(0);
			        }
					
					
					
				}
				
			}
		});
		btnNewButton_1.setBounds(651, 444, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("輸出WORD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(output.getText().isEmpty()) {JOptionPane.showMessageDialog(null,"沒有訂單生成，無法列印","超級城堡",JOptionPane.PLAIN_MESSAGE);}
				else {
					XWPFDocument document = new XWPFDocument();
			        String text = output.getText();
			        String[] lines = text.split("\n");
			        for (String line : lines) {
			            XWPFParagraph paragraph = document.createParagraph();
			            paragraph.setAlignment(ParagraphAlignment.LEFT);
			            XWPFRun run = paragraph.createRun();
			            run.setFontFamily("宋體");
			            run.setFontSize(12);
			            run.setText(line);
			        }

			        try (FileOutputStream out = new FileOutputStream("order.docx")) {
			            document.write(out);
			            JOptionPane.showMessageDialog(null,"訂單WORD存檔完成！","超級城堡",JOptionPane.PLAIN_MESSAGE);
			        } catch (IOException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null,"訂單WORD存檔失敗：" + ex.getMessage(),"超級城堡",JOptionPane.PLAIN_MESSAGE);
			        }
				}
			}
		});
		btnNewButton_2.setBounds(10, 463, 127, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("個資編輯");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomerUI updatecustomer=new UpdateCustomerUI();
				updatecustomer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(10, 496, 127, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("登出");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setBounds(10, 529, 127, 23);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("退出");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2_1_1_1.setBounds(10, 562, 127, 23);
		contentPane.add(btnNewButton_2_1_1_1);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MenuUI.class.getResource("/Resource/a1.jpg")));
		lblNewLabel_4.setBounds(0, 0, 786, 601);
		contentPane.add(lblNewLabel_4);
	}
}
