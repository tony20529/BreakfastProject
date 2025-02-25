package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	public static void main(String[] args) {
		
	}
	
	private static EmployeeDaoImpl employeedaoimpl=new EmployeeDaoImpl();

	@Override
	public void add(Employee employee) {
		employeedaoimpl.add(employee);
	}

	@Override
	public Employee Login(String employeenumber, String password) {
		Employee employee=null;
		List<Employee>l=employeedaoimpl.selectEmployeeNumberAndPassword(employeenumber, password);
		if(l.size()!=0)
		{
			employee=l.get(0);
		}		
		
		return employee;
	}

	@Override
	public String All() {
		List<Employee>l=employeedaoimpl.selectAll();
		String show="";
		
		for(Employee p:l)
		{
			
			show=show+"員工ID:"+p.getId()+
					"\t員工編號:"+p.getNumber()+
					"\t員工到職日期:"+p.getIntodate()+
					"\t員工姓名:"+p.getName()+
					"\t員工身分證:"+p.getIdcard()+
					"\t員工密碼:"+p.getPassword()+
					"\t員工性別:"+p.getGender()+
					"\t員工年齡:"+p.getAge()+
					"\t員工生日:"+p.getBirthday()+
					"\t員工電話:"+p.getMobile()+
					"\t員工學歷:"+p.getEducation()+
					"\t員工地址:"+p.getAddress()+
					"\n";
		}
		
		
		return show;
	}
	
	@Override
	public String[][] AllEx(){
		List<Employee> l=employeedaoimpl.selectAll();
		int rowIndex = 0;
		String[][] show = new String[l.size()][12];
		for(Employee  p : l){
            show[rowIndex][0] = String.valueOf(p.getId());
            show[rowIndex][1] = p.getNumber();
            show[rowIndex][2] = p.getIntodate();
            show[rowIndex][3] = p.getName();
            show[rowIndex][4] = p.getIdcard();
            show[rowIndex][5] = p.getPassword();
            show[rowIndex][6] = p.getGender();
            show[rowIndex][7] = p.getAge();
            show[rowIndex][8] = p.getBirthday(); 
            show[rowIndex][9] = p.getMobile(); 
            show[rowIndex][10] = p.getEducation();
            show[rowIndex][11] = p.getAddress();
            rowIndex++;
        }
        return show;
		
	}
	
	@Override
	public String[][] EmployeeReportEx(){
		List<Employee> l=employeedaoimpl.selectEmployeeReport();
		int rowIndex = 0;
		String[][] show = new String[l.size()][4];
		for(Employee  p : l){
            show[rowIndex][0] = p.getNumber();
            show[rowIndex][1] = p.getName();
            show[rowIndex][2] = String.valueOf(p.getSellsum());
            show[rowIndex][3] = String.valueOf(p.getSum());
            rowIndex++;
        }
        return show;
		
	}

	@Override
	public List<Employee> readAll() {
		
		return employeedaoimpl.selectAll();
	}

	@Override
	public Employee findById(int id) {
		Employee employee=null;
		if(id>0) {
			List<Employee> l=employeedaoimpl.selectById(id);
			if(l.size()>0) {
				employee=l.get(0);
			}
		}
		return employee;
	}

	@Override
	public Employee findByNumber(String number) {
		Employee employee=null;
		List<Employee> l=employeedaoimpl.selectByNumber(number);
			if(l.size()>0) {
				employee=l.get(0);
			}
		
		return employee;
	}

	@Override
	public String employeeNumber() {
		String employeenumber;
		if(employeedaoimpl.newNumber()!=null) {
			String numberPart=employeedaoimpl.newNumber().substring(1);
			 int number = Integer.parseInt(numberPart);
			 number++;
			 String newNumberPart = String.format("%05d", number);
			 employeenumber="E" + newNumberPart;
		}
		else {
			employeenumber="E00001";
		}
		return employeenumber;
	}

	@Override
	public void update(Employee employee) {
		if(!employeedaoimpl.selectById(employee.getId()).isEmpty()) {employeedaoimpl.update(employee);}
		
	}

	@Override
	public void delete(int id) {
		if(!employeedaoimpl.selectById(id).isEmpty()){employeedaoimpl.delete(id);}
		
	}

}
