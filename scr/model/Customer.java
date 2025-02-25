package model;


import java.io.Serializable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Customer extends AbstractTableModel implements Serializable{
	private Integer id;
	private String number;
	private String intodate;
	private String name;
	private String username;
	private String password;
	private String gender;
	private String age;
	private String mobile;
	private String address;
	private String dbuser;
	private String dbpassword;
	private Integer buysum;
	private Integer sum;
	private final String[] columnNames = {"顧客ID", "顧客編號", "顧客姓名", "顧客帳號", "顧客密碼","顧客性別", "顧客年齡","顧客電話","顧客地址"};
	private List<Customer> customers;
	
	public Customer(Integer id, String number, String intodate, String name, String username, String password,
			String gender, String age, String mobile, String address) {
		super();
		this.id = id;
		this.number = number;
		this.intodate = intodate;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}

	public Customer(String number, String intodate, String name, String username, String password, String gender,
			String age, String mobile, String address) {
		super();
		this.number = number;
		this.intodate = intodate;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}
	
	

	public Customer(String number, String name, Integer buysum, Integer sum) {
		super();
		this.number = number;
		this.name = name;
		this.buysum = buysum;
		this.sum = sum;
	}

	public Customer(String dbuser, String dbpassword) {
		super();
		this.dbuser = dbuser;
		this.dbpassword = dbpassword;
	}
	
	
	public Customer(List<Customer> customers) {
		super();
		this.customers = customers;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIntodate() {
		return intodate;
	}
	public void setIntodate(String intodate) {
		this.intodate = intodate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDbuser() {
		return dbuser;
	}

	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	public Integer getBuysum() {
		return buysum;
	}

	public void setBuysum(Integer buysum) {
		this.buysum = buysum;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return customers.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int column) {  
        return columnNames[column];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer=customers.get(rowIndex);
		switch (columnIndex) {
        case 0: return customer.getId();
        case 1: return customer.getNumber();
        case 2: return customer.getName();
        case 3: return customer.getUsername();
        case 4: return customer.getPassword();
        case 5: return customer.getGender();
        case 6: return customer.getAge();
        case 7: return customer.getMobile();
        case 8: return customer.getAddress();
        case 9: return customer.getIntodate();
        default: return null;
        }
	}
	
}	


