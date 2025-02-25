package controller.employee;

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
import javax.swing.JPasswordField;
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
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.RegularTool;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class EmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static EmployeeServiceImpl employeeserviceimpl=new EmployeeServiceImpl();
	private JTable table;
	private Employee tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUI frame = new EmployeeUI();
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
	public EmployeeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 1284, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工管理");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblNewLabel.setBounds(605, 10, 329, 74);
		panel.add(lblNewLabel);
		
		JLabel clock = new JLabel(Tool.getTime());
		clock.setForeground(new Color(30, 144, 255));
		clock.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		clock.setBounds(1027, 81, 247, 31);
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
		panel_1.setBounds(0, 113, 1284, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("員工名單");
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
		        Sheet sheet = workbook.createSheet("員工名單");

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
		        String[] headers = {"員工ID", "員工編號", "員工到職日期","員工姓名", "員工身分證","員工密碼","員工性別", "員工年齡","員工生日", "員工電話","員工學歷","員工地址"};
		        for (int i = 0; i < headers.length; i++) {
		            Cell cell = headerRow.createCell(i);
		            cell.setCellValue(headers[i]);
		            cell.setCellStyle(headerStyle);
		        }
		        
		        String[][] data = employeeserviceimpl.AllEx();
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
		        try (FileOutputStream fileOut = new FileOutputStream("employee.xlsx")) {
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
		btnNewButton_4.setBounds(1152, 27, 122, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("員工報表");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 創建一個新的工作簿
		        Workbook workbook = new XSSFWorkbook();

		        // 創建一個工作表
		        Sheet sheet = workbook.createSheet("員工名單");

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
		        String[] headers = { "員工編號","員工姓名", "負責訂單數","總銷售額"};
		        for (int i = 0; i < headers.length; i++) {
		            Cell cell = headerRow.createCell(i);
		            cell.setCellValue(headers[i]);
		            cell.setCellStyle(headerStyle);
		        }
		        
		        String[][] data = employeeserviceimpl.EmployeeReportEx();
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
		        try (FileOutputStream fileOut = new FileOutputStream("employee_report.xlsx")) {
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
		btnNewButton_6.setBounds(1047, 27, 96, 23);
		panel_1.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 178, 1284, 265);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		List<Employee>employees=new ArrayList();
		employees=employeeserviceimpl.readAll();
		
		tableModel = new Employee(employees);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1284, 265);
		panel_2.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JButton btnNewButton = new JButton("編輯");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
	            if (selectedRow == -1) {
	            	JOptionPane.showMessageDialog(null,"請先選擇要編輯的員工資料","超級城堡",JOptionPane.PLAIN_MESSAGE);
	                return;
	            }
	            int id = (int) tableModel.getValueAt(selectedRow, 0);
	            String number = (String) tableModel.getValueAt(selectedRow, 1);
	            String intodate = (String) tableModel.getValueAt(selectedRow, 2);
	            String name = (String) tableModel.getValueAt(selectedRow, 3);
	            String idcard = (String) tableModel.getValueAt(selectedRow, 4);
	            String password = (String) tableModel.getValueAt(selectedRow, 5);
	            String gender= (String) tableModel.getValueAt(selectedRow, 6);
	            String age= (String) tableModel.getValueAt(selectedRow, 7);
	            String birthday= (String) tableModel.getValueAt(selectedRow, 8);
	            String mobile= (String) tableModel.getValueAt(selectedRow, 9);
	            String education= (String) tableModel.getValueAt(selectedRow, 10);
	            String address= (String) tableModel.getValueAt(selectedRow, 11);
	            
	            JLabel idLabel = new JLabel();
	            idLabel.setText(Integer.toString(id));
	            JLabel numberLabel = new JLabel();
	            numberLabel.setText(number);
	            JLabel intodateLabel = new JLabel();
	            intodateLabel.setText(intodate);
	            JTextField nameLabel = new  JTextField(name);
	            JTextField idcardLabel = new  JTextField(idcard);
	            JPasswordField passwordLable = new  JPasswordField(password);
	            String[] options = {"男", "女"};
	            JComboBox<String> genderComboBox = new JComboBox<>(options);
	            genderComboBox.setSelectedItem(String.valueOf(gender));
	            JTextField ageLabel = new  JTextField(age);
	            JTextField birthdayLabel = new  JTextField(birthday);
	            JTextField mobileLabel = new  JTextField(mobile);
	            JTextField educationLabel = new  JTextField(education);
	            JTextField addressLabel = new  JTextField(address);
	            JPanel panel = new JPanel(new GridLayout(12, 2));
	            
	            panel.add(new JLabel("員工ID: "));
	            panel.add(idLabel);
	            panel.add(new JLabel("員工編號: "));
	            panel.add(numberLabel);
	            panel.add(new JLabel("員工到職日期: "));
	            panel.add(intodateLabel);
	            panel.add(new JLabel("員工姓名: "));
	            panel.add(nameLabel);
	            panel.add(new JLabel("員工身分證: "));
	            panel.add(idcardLabel);
	            panel.add(new JLabel("員工密碼: "));
	            panel.add(passwordLable);
	            panel.add(new JLabel("員工性別"));
	            panel.add(genderComboBox);
	            panel.add(new JLabel("員工年齡: "));
	            panel.add(ageLabel);
	            panel.add(new JLabel("員工生日: "));
	            panel.add(birthdayLabel);
	            panel.add(new JLabel("員工電話: "));
	            panel.add(mobileLabel);
	            panel.add(new JLabel("員工學歷: "));
	            panel.add(educationLabel);
	            panel.add(new JLabel("員工地址: "));
	            panel.add(addressLabel);
	            
	            int result = JOptionPane.showConfirmDialog(null, panel, "修改員工資料",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	            
	            if (result == JOptionPane.OK_OPTION) {
	            	if(RegularTool.AddName(nameLabel.getText())) {JOptionPane.showMessageDialog(null,"名字請輸入2-6個中文字或1-10個英文字母","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddIdCard(idcardLabel.getText())) {JOptionPane.showMessageDialog(null,"請輸入真實身份證","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddAge(ageLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入真實年齡","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(!RegularTool.AddBirthday(birthdayLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入真實生日:民國幾年/幾月/幾日","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddMobile(mobileLabel.getText())) {JOptionPane.showMessageDialog(null,"請輸入真實手機號碼","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddAddress(addressLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入完整聯絡地址","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else{
						if(password.trim().equals(passwordLable.getText().trim())) {
							String newname=nameLabel.getText();
							String newidcard=idcardLabel.getText();
							String newgender=genderComboBox.getSelectedItem().toString();
							String newage=ageLabel.getText();
							String newbirthday=birthdayLabel.getText();
							String newmobile=mobileLabel.getText();
							String neweducation=educationLabel.getText();
							String newaddress=addressLabel.getText();
							
							Employee em=new Employee(id,number,intodate,newname,newidcard,password,newgender,newage,newbirthday,newmobile,neweducation,newaddress);
							employeeserviceimpl.update(em);
							table.setModel(new Employee(new ArrayList<>()));
							tableModel = new Employee(employeeserviceimpl.readAll());
							table.setModel(tableModel); 
							JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
							
							
							
						else {
							if(RegularTool.AddPassword(passwordLable.getText())){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
							else{
								String newname=nameLabel.getText();
								String newidcard=idcardLabel.getText();
								String newpassword=Tool.encrypt(passwordLable.getText());
								String newgender=genderComboBox.getSelectedItem().toString();
								String newage=ageLabel.getText();
								String newbirthday=birthdayLabel.getText();
								String newmobile=mobileLabel.getText();
								String neweducation=educationLabel.getText();
								String newaddress=addressLabel.getText();
								
								Employee em=new Employee(id,number,intodate,newname,newidcard,newpassword,newgender,newage,newbirthday,newmobile,neweducation,newaddress);
								employeeserviceimpl.update(em);
								table.setModel(new Employee(new ArrayList<>()));
								tableModel = new Employee(employeeserviceimpl.readAll());
								table.setModel(tableModel); 
								JOptionPane.showMessageDialog(null,"更新完成","超級城堡",JOptionPane.PLAIN_MESSAGE);}
								
							
							
						}
							
						}        
	                    
	            	}
	            
			}
		});
		btnNewButton.setBounds(100, 464, 184, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
	            if (selectedRow == -1) {
	            	JOptionPane.showMessageDialog(null,"請先選擇要刪除的員工資料","超級城堡",JOptionPane.PLAIN_MESSAGE);
	                return;
	            }
	            int id = (int) tableModel.getValueAt(selectedRow, 0);
	            String number = (String) tableModel.getValueAt(selectedRow, 1);
	            String intodate = (String) tableModel.getValueAt(selectedRow, 2);
	            String name = (String) tableModel.getValueAt(selectedRow, 3);
	            String idcard = (String) tableModel.getValueAt(selectedRow, 4);
	            String password = (String) tableModel.getValueAt(selectedRow, 5);
	            String gender= (String) tableModel.getValueAt(selectedRow, 6);
	            String age= (String) tableModel.getValueAt(selectedRow, 7);
	            String birthday= (String) tableModel.getValueAt(selectedRow, 8);
	            String mobile= (String) tableModel.getValueAt(selectedRow, 9);
	            String education= (String) tableModel.getValueAt(selectedRow, 10);
	            String address= (String) tableModel.getValueAt(selectedRow, 11);
	            int confirm = JOptionPane.showConfirmDialog(null, "確定要刪除這筆員工資料嗎？", "超級城堡", JOptionPane.YES_NO_OPTION);
	            if (confirm == JOptionPane.NO_OPTION) {
	                return;
	            }
	            employeeserviceimpl.delete(id);
	            table.setModel(new Employee(new ArrayList<>()));
				tableModel = new Employee(employeeserviceimpl.readAll());
				table.setModel(tableModel);
				JOptionPane.showMessageDialog(null,"id為"+id+"的員工已被刪除","超級城堡",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(400, 464, 184, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("新增");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            JTextField nameLabel = new  JTextField();
	            JTextField idcardLabel = new  JTextField();
	            JPasswordField passwordLable = new  JPasswordField();
	            String[] options = {"男", "女"};
	            JComboBox<String> genderComboBox = new JComboBox<>(options);
	            JTextField ageLabel = new  JTextField();
	            JTextField birthdayLabel = new  JTextField();
	            JTextField mobileLabel = new  JTextField();
	            JTextField educationLabel = new  JTextField();
	            JTextField addressLabel = new  JTextField();
	            JPanel panel = new JPanel(new GridLayout(9, 2));
	            
	            panel.add(new JLabel("員工姓名: "));
	            panel.add(nameLabel);
	            panel.add(new JLabel("員工身分證: "));
	            panel.add(idcardLabel);
	            panel.add(new JLabel("員工密碼: "));
	            panel.add(passwordLable);
	            panel.add(new JLabel("員工性別"));
	            panel.add(genderComboBox);
	            panel.add(new JLabel("員工年齡: "));
	            panel.add(ageLabel);
	            panel.add(new JLabel("員工生日: "));
	            panel.add(birthdayLabel);
	            panel.add(new JLabel("員工電話: "));
	            panel.add(mobileLabel);
	            panel.add(new JLabel("員工學歷: "));
	            panel.add(educationLabel);
	            panel.add(new JLabel("員工地址: "));
	            panel.add(addressLabel);
	            
	            int result = JOptionPane.showConfirmDialog(null, panel, "新增員工資料",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if (result == JOptionPane.OK_OPTION) {
	            	if(RegularTool.AddName(nameLabel.getText())) {JOptionPane.showMessageDialog(null,"名字請輸入2-6個中文字或1-10個英文字母","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddIdCard(idcardLabel.getText())) {JOptionPane.showMessageDialog(null,"請輸入真實身份證","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddPassword(passwordLable.getText())){JOptionPane.showMessageDialog(null,"密碼請輸入6-12個英文或數字,而且密碼中要包含大寫英文與小寫英文還有數字","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddAge(ageLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入真實年齡","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(!RegularTool.AddBirthday(birthdayLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入真實生日:民國幾年/幾月/幾日","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddMobile(mobileLabel.getText())) {JOptionPane.showMessageDialog(null,"請輸入真實手機號碼","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else if(RegularTool.AddAddress(addressLabel.getText())){JOptionPane.showMessageDialog(null,"請輸入完整聯絡地址","超級城堡",JOptionPane.PLAIN_MESSAGE);}
					else {
						String newname=nameLabel.getText();
						String newidcard=idcardLabel.getText();
						String newpassword=Tool.encrypt(passwordLable.getText());
						String newgender=genderComboBox.getSelectedItem().toString();
						String newage=ageLabel.getText();
						String newbirthday=birthdayLabel.getText();
						String newmobile=mobileLabel.getText();
						String neweducation=educationLabel.getText();
						String newaddress=addressLabel.getText();
						Employee em=new Employee(employeeserviceimpl.employeeNumber(),Tool.getDate(),newname,newidcard,newpassword,newgender,newage,newbirthday,newmobile,neweducation,newaddress);
						employeeserviceimpl.add(em);
						table.setModel(new Employee(new ArrayList<>()));
						tableModel = new Employee(employeeserviceimpl.readAll());
						table.setModel(tableModel); 
						JOptionPane.showMessageDialog(null,"新增完成","超級城堡",JOptionPane.PLAIN_MESSAGE);
					}
	            }
	            
			}
		});
		btnNewButton_2.setBounds(700, 464, 184, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(1000, 464, 184, 23);
		contentPane.add(btnNewButton_3);
	}
}
