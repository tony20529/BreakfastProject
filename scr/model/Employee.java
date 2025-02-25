package model;

import java.io.Serializable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Employee extends AbstractTableModel implements Serializable{
	private Integer id;
	private String number;
	private String intodate;
	private String name;
	private String idcard;
	private String password;
	private String gender;
	private String age;
	private String birthday;
	private String mobile;
	private String education;
	private String address;
	private Integer sum;
	private Integer sellsum;
	private final String[] columnNames = {"員工ID", "員工編號", "員工到職日期","員工姓名", "員工身分證","員工密碼","員工性別", "員工年齡","員工生日", "員工電話","員工學歷","員工地址"};
	private List<Employee>employees;
	
	public Employee(Integer id, String number, String intodate, String name, String idcard, String password,
			String gender, String age, String birthday, String mobile, String education, String address) {
		super();
		this.id = id;
		this.number = number;
		this.intodate = intodate;
		this.name = name;
		this.idcard = idcard;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.mobile = mobile;
		this.education = education;
		this.address = address;
	}
	
	public Employee(String number, String intodate, String name, String idcard, String password, String gender,
			String age, String birthday, String mobile, String education, String address) {
		super();
		this.number = number;
		this.intodate = intodate;
		this.name = name;
		this.idcard = idcard;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.mobile = mobile;
		this.education = education;
		this.address = address;
	}
	
	

	public Employee(String number, String name, Integer sellsum, Integer sum) {
		super();
		this.number = number;
		this.name = name;
		this.sum = sum;
		this.sellsum = sellsum;
	}

	public Employee(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	public Employee() {
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getSellsum() {
		return sellsum;
	}

	public void setSellsum(Integer sellsum) {
		this.sellsum = sellsum;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	public String getColumnName(int column) {  
        return columnNames[column];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee employee=employees.get(rowIndex);
		switch (columnIndex) {
        case 0: return employee.getId();
        case 1: return employee.getNumber();
        case 2: return employee.getIntodate();
        case 3: return employee.getName();
        case 4: return employee.getIdcard();
        case 5: return employee.getPassword();
        case 6: return employee.getGender();
        case 7: return employee.getAge();
        case 8: return employee.getBirthday();
        case 9: return employee.getMobile();
        case 10: return employee.getEducation();
        case 11: return employee.getAddress();
        default: return null;
        }
	}
	
	
	
	

}
