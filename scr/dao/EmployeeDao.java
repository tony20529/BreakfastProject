package dao;

import java.util.List;

import model.Employee;



public interface EmployeeDao {
	//create-->void
	void add(Employee employee);
	
	
	//read-->List
	List<Employee> selectAll();
	List<Employee> selectEmployeeReport();
	List<Employee> selectEmployeeNumberAndPassword(String employeenumber,String password);
	List<Employee> selectById(int id);
	List<Employee> selectByNumber(String number);
	String newNumber();
	
	//update-->void
	void update(Employee employee);
	
	//delete-->void
	void delete(int id);

}
