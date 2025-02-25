package controller.product;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.LoginUI;
import controller.ManageUI;
import model.Product;
import service.impl.ProductServiceImpl;
import util.RegularTool;
import util.Tool;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ProductUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Product tableModel;
	private static ProductServiceImpl productserviceimpl=new ProductServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUI frame = new ProductUI();
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
	public ProductUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 584, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("產品管理");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblNewLabel.setBounds(205, 10, 329, 74);
		panel.add(lblNewLabel);
		
		JLabel clock = new JLabel(Tool.getTime());
		clock.setForeground(new Color(30, 144, 255));
		clock.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		clock.setBounds(337, 78, 247, 31);
		panel.add(clock);
		
		JButton btnNewButton_5 = new JButton("返回");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageUI manage=new ManageUI();
				manage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(10, 10, 87, 23);
		panel.add(btnNewButton_5);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(0, 113, 584, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("產品列表");
		lblNewLabel_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(26, 10, 221, 45);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("輸出Excel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 創建一個新的工作簿
		        Workbook workbook = new XSSFWorkbook();

		        // 創建一個工作表
		        Sheet sheet = workbook.createSheet("產品列表");

		        // 創建字體樣式
		        org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
		        headerFont.setFontName("宋體");
		        headerFont.setFontHeightInPoints((short) 14);
		        headerFont.setBold(true);
		        headerFont.setColor(IndexedColors.WHITE.getIndex());

		        // 創建標題樣式
		        CellStyle headerStyle = workbook.createCellStyle();
		        headerStyle.setFont(headerFont);
		        headerStyle.setAlignment(HorizontalAlignment.CENTER);
		        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		        headerStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		        headerStyle.setBorderTop(BorderStyle.THIN);
		        headerStyle.setBorderBottom(BorderStyle.THIN);
		        headerStyle.setBorderLeft(BorderStyle.THIN);
		        headerStyle.setBorderRight(BorderStyle.THIN);

		        // 創建數據字體樣式
		        org.apache.poi.ss.usermodel.Font dataFont = workbook.createFont();
		        dataFont.setFontName("宋體");
		        dataFont.setFontHeightInPoints((short) 12);

		        // 創建數據樣式
		        CellStyle dataStyle = workbook.createCellStyle();
		        dataStyle.setFont(dataFont);
		        dataStyle.setAlignment(HorizontalAlignment.CENTER);
		        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		        dataStyle.setBorderTop(BorderStyle.THIN);
		        dataStyle.setBorderBottom(BorderStyle.THIN);
		        dataStyle.setBorderLeft(BorderStyle.THIN);
		        dataStyle.setBorderRight(BorderStyle.THIN);

		        // 創建標題
		        Row headerRow = sheet.createRow(0);
		        String[] headers = {"產品ID", "產品編號", "產品名稱","產品價格", "庫存數量","安全庫存數量","更新日期"};
		        for (int i = 0; i < headers.length; i++) {
		            Cell cell = headerRow.createCell(i);
		            cell.setCellValue(headers[i]);
		            cell.setCellStyle(headerStyle);
		        }
		        
		        String[][] data = productserviceimpl.AllEx();
		        for (int i = 0; i < data.length; i++) {
		            Row dataRow = sheet.createRow(i + 1);
		            for (int j = 0; j < data[i].length; j++) {
		                Cell cell = dataRow.createCell(j);
		                cell.setCellValue(data[i][j]);
		                cell.setCellStyle(dataStyle);
		            }
		        }

		        // 自動調整列寬
		        for (int i = 0; i < headers.length; i++) {
		            sheet.autoSizeColumn(i);
		        }
		            
		        // 保存文件
		        try (FileOutputStream fileOut = new FileOutputStream("product.xlsx")) {
		            workbook.write(fileOut);
		            JOptionPane.showMessageDialog(null,"Excel 文件創建並排版成功！","超級城堡",JOptionPane.PLAIN_MESSAGE);
		        
		        } catch (FileNotFoundException k) {
					// TODO Auto-generated catch block
					k.printStackTrace();
				} catch (IOException k) {
					// TODO Auto-generated catch block
					k.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(452, 27, 122, 23);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 178, 584, 265);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		List<Product>products=new ArrayList();
		products=productserviceimpl.readAll();
		
		tableModel = new Product(products);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 584, 265);
		panel_2.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 
		 JButton btnNewButton = new JButton("編輯");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table.getSelectedRow();
		            if (selectedRow == -1) {
		            	JOptionPane.showMessageDialog(null,"請先選擇要編輯的產品資料","超級城堡",JOptionPane.PLAIN_MESSAGE);
		                return;
		            }
		            int id = (int) tableModel.getValueAt(selectedRow, 0);
		            String number = (String) tableModel.getValueAt(selectedRow, 1);
		            String name = (String) tableModel.getValueAt(selectedRow, 2);
		            int price= (int) tableModel.getValueAt(selectedRow, 3);
		            int inventory = (int) tableModel.getValueAt(selectedRow, 4);
		            int safeinventory = (int) tableModel.getValueAt(selectedRow, 5);
		            String intodate= (String) tableModel.getValueAt(selectedRow, 6);
		            
		            JLabel idLabel = new JLabel();
		            idLabel.setText(Integer.toString(id));
		            JLabel numberLabel = new JLabel();
		            numberLabel.setText(number);
		            JTextField nameLabel = new  JTextField(name);
		            JTextField priceLabel = new  JTextField(Integer.toString(price));
		            JTextField inventoryLabel = new  JTextField(Integer.toString(inventory));
		            JLabel safeinventoryLabel = new  JLabel();
		            safeinventoryLabel.setText(Integer.toString(safeinventory));
		            JLabel intodateLabel = new  JLabel();
		            intodateLabel.setText(Tool.getDate());
		            JPanel panel = new JPanel(new GridLayout(7, 2));
		            
		            panel.add(new JLabel("產品ID: "));
		            panel.add(idLabel);
		            panel.add(new JLabel("產品編號: "));
		            panel.add(numberLabel);
		            panel.add(new JLabel("產品名稱: "));
		            panel.add(nameLabel);
		            panel.add(new JLabel("產品價格: "));
		            panel.add(priceLabel);
		            panel.add(new JLabel("庫存數量: "));
		            panel.add(inventoryLabel);
		            panel.add(new JLabel("安全庫存數量:"));
		            panel.add(safeinventoryLabel);
		            panel.add(new JLabel("更新日期: "));
		            panel.add(intodateLabel);
		            
		            int result = JOptionPane.showConfirmDialog(null, panel, "更新產品資訊",
	                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		            if (result == JOptionPane.OK_OPTION) {
		            	if(RegularTool.AddInt(priceLabel.getText()) || RegularTool.AddInt(inventoryLabel.getText()) || Integer.parseInt(priceLabel.getText())<=0 || Integer.parseInt(inventoryLabel.getText())<=0 ) {JOptionPane.showMessageDialog(null,"產品價格、產品庫存，請都輸入數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
		            	else {
		            		String newname=nameLabel.getText();
		            		int newprice=Integer.parseInt(priceLabel.getText());
		            		int newinventory=Integer.parseInt(inventoryLabel.getText());
		            		Product p=new Product(id,number,newname,newprice,newinventory,safeinventory,Tool.getDate());
		            		Tool.save(p, "product.txt");
		            		productserviceimpl.update(p);
							table.setModel(new Product(new ArrayList<>()));
							tableModel = new Product(productserviceimpl.readAll());
							table.setModel(tableModel); 
							JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);
							if(newinventory<=safeinventory) {JOptionPane.showMessageDialog(null,"請注意庫存","超級城堡",JOptionPane.PLAIN_MESSAGE);}
		            	}
		            }
				}
			});
		btnNewButton.setBounds(26, 463, 87, 23);
		contentPane.add(btnNewButton);
		            
		 
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
	            if (selectedRow == -1) {
	            	JOptionPane.showMessageDialog(null,"請先選擇要刪除的產品","超級城堡",JOptionPane.PLAIN_MESSAGE);
	                return;
	            }
	            int id = (int) tableModel.getValueAt(selectedRow, 0);
	            String number = (String) tableModel.getValueAt(selectedRow, 1);
	            String name = (String) tableModel.getValueAt(selectedRow, 2);
	            int price= (int) tableModel.getValueAt(selectedRow, 3);
	            int inventory = (int) tableModel.getValueAt(selectedRow, 4);
	            int safeinventory = (int) tableModel.getValueAt(selectedRow, 5);
	            String intodate= (String) tableModel.getValueAt(selectedRow, 6);
	            
	            int confirm = JOptionPane.showConfirmDialog(null, "確定要刪除這筆產品資訊嗎？", "超級城堡", JOptionPane.YES_NO_OPTION);
	            if (confirm == JOptionPane.NO_OPTION) {
	                return;
	            }
	            productserviceimpl.delete(id);
	            
	            table.setModel(new Product(new ArrayList<>()));
				tableModel = new Product(productserviceimpl.readAll());
				table.setModel(tableModel);
				JOptionPane.showMessageDialog(null,"id為"+id+"的產品已被刪除","超級城堡",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(176, 463, 87, 23);
		contentPane.add(btnNewButton_1);
		 
		JButton btnNewButton_2 = new JButton("新增");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            JTextField nameLabel = new  JTextField();
	            JTextField priceLabel = new  JTextField();
	            JTextField inventoryLabel = new  JTextField();
	            JTextField safeinventoryLabel = new  JTextField();
	            JLabel intodateLabel = new  JLabel();
	            intodateLabel.setText(Tool.getDate());
	            JPanel panel = new JPanel(new GridLayout(5, 2));
	            
	            panel.add(new JLabel("產品名稱: "));
	            panel.add(nameLabel);
	            panel.add(new JLabel("產品價格: "));
	            panel.add(priceLabel);
	            panel.add(new JLabel("庫存數量: "));
	            panel.add(inventoryLabel);
	            panel.add(new JLabel("安全庫存數量:"));
	            panel.add(safeinventoryLabel);
	            panel.add(new JLabel("更新日期: "));
	            panel.add(intodateLabel);
	            
	            int result = JOptionPane.showConfirmDialog(null, panel, "新增產品資訊",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	            
	            if (result == JOptionPane.OK_OPTION) {
			           	if(RegularTool.AddInt(priceLabel.getText()) || RegularTool.AddInt(inventoryLabel.getText()) || RegularTool.AddInt(safeinventoryLabel.getText()) || Integer.parseInt(priceLabel.getText())<=0 || Integer.parseInt(inventoryLabel.getText())<=0 || Integer.parseInt(safeinventoryLabel.getText())<=0) {JOptionPane.showMessageDialog(null,"產品價格、產品庫存、產品安全庫存，請都輸入數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
			           	else {
			           			String newname=nameLabel.getText();
			           			int newprice=Integer.parseInt(priceLabel.getText());
			           			int newinventory=Integer.parseInt(inventoryLabel.getText());
			            		int newsafeinventory=Integer.parseInt(safeinventoryLabel.getText());
			            		Product p=new Product(productserviceimpl.productNumber(),newname,newprice,newinventory,newsafeinventory,Tool.getDate());
			            		productserviceimpl.add(p);
			            		Tool.save(p, "product.txt");
								table.setModel(new Product(new ArrayList<>()));
								tableModel = new Product(productserviceimpl.readAll());
								table.setModel(tableModel); 
								JOptionPane.showMessageDialog(null,"新增完成","超級城堡",JOptionPane.PLAIN_MESSAGE);
								if(newinventory<=newsafeinventory) {JOptionPane.showMessageDialog(null,"請注意庫存","超級城堡",JOptionPane.PLAIN_MESSAGE);}
								
								}
					}
	            	    
			}
		});
		btnNewButton_2.setBounds(326, 463, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(476, 463, 87, 23);
		contentPane.add(btnNewButton_3);
		
		
		
		
	}
}
