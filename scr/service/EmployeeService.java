package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	//create
	void add(Employee employee);	
	
	//read
	Employee Login(String employeenumber,String password);
	String All();
	String[][] AllEx();
	String[][] EmployeeReportEx();
	List<Employee>readAll();
	Employee findById(int id);
	Employee findByNumber(String number);
	String employeeNumber();
	
	//update
	void update(Employee employee);
	//delete
	void delete(int id);
}
