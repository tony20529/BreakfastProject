package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static Connection conn=DbConnection.getDb();
	
	@Override
	public void add(Employee employee) {
		String sql="insert into employee(employeeno,employeeintodate,employeename,employeeidcard,employeepassword,employeegender,employeeage,employeebirthday,employeemobile,employeeeducation,employeeaddress) "
				+"values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, employee.getNumber());
			preparedstatement.setString(2, employee.getIntodate());
			preparedstatement.setString(3, employee.getName());
			preparedstatement.setString(4, employee.getIdcard());
			preparedstatement.setString(5, employee.getPassword());
			preparedstatement.setString(6, employee.getGender());
			preparedstatement.setString(7, employee.getAge());
			preparedstatement.setString(8, employee.getBirthday());
			preparedstatement.setString(9, employee.getMobile());
			preparedstatement.setString(10, employee.getEducation());
			preparedstatement.setString(11, employee.getAddress());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> selectAll() {
		String sql="select * from employee";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Employee employee=new Employee();
				employee.setId(resultset.getInt("idemployee"));
				employee.setNumber(resultset.getString("employeeno"));
				employee.setIntodate(resultset.getString("employeeintodate"));
				employee.setName(resultset.getString("employeename"));
				employee.setIdcard(resultset.getString("employeeidcard"));
				employee.setPassword(resultset.getString("employeepassword"));
				employee.setGender(resultset.getString("employeegender"));
				employee.setAge(resultset.getString("employeeage"));
				employee.setBirthday(resultset.getString("employeebirthday"));
				employee.setMobile(resultset.getString("employeemobile"));
				employee.setEducation(resultset.getString("employeeeducation"));
				employee.setAddress(resultset.getString("employeeaddress"));
				l.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}
	
	@Override
	public List<Employee> selectEmployeeReport(){
		String sql="select * from employee_report";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Employee employee=new Employee();
				employee.setNumber(resultset.getString("員工編號"));
				employee.setName(resultset.getString("員工姓名"));
				employee.setSellsum(resultset.getInt("負責訂單數"));
				employee.setSum(resultset.getInt("總銷售額"));
				l.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}
	
	@Override
	public List<Employee> selectEmployeeNumberAndPassword(String employeenumber,String password){
		String sql="select * from employee where employeeno=? and employeepassword=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, employeenumber);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Employee employee=new Employee();
				employee.setId(resultset.getInt("idemployee"));
				employee.setNumber(resultset.getString("employeeno"));
				employee.setIntodate(resultset.getString("employeeintodate"));
				employee.setName(resultset.getString("employeename"));
				employee.setIdcard(resultset.getString("employeeidcard"));
				employee.setPassword(resultset.getString("employeepassword"));
				employee.setGender(resultset.getString("employeegender"));
				employee.setAge(resultset.getString("employeeage"));
				employee.setBirthday(resultset.getString("employeebirthday"));
				employee.setMobile(resultset.getString("employeemobile"));
				employee.setEducation(resultset.getString("employeeeducation"));
				employee.setAddress(resultset.getString("employeeaddress"));
				l.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Employee> selectById(int id) {
		String sql="select * from employee where idemployee=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Employee employee=new Employee();
				employee.setId(resultset.getInt("idemployee"));
				employee.setNumber(resultset.getString("employeeno"));
				employee.setIntodate(resultset.getString("employeeintodate"));
				employee.setName(resultset.getString("employeename"));
				employee.setIdcard(resultset.getString("employeeidcard"));
				employee.setPassword(resultset.getString("employeepassword"));
				employee.setGender(resultset.getString("employeegender"));
				employee.setAge(resultset.getString("employeeage"));
				employee.setBirthday(resultset.getString("employeebirthday"));
				employee.setMobile(resultset.getString("employeemobile"));
				employee.setEducation(resultset.getString("employeeeducation"));
				employee.setAddress(resultset.getString("employeeaddress"));
				l.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Employee> selectByNumber(String number){
		String sql="select * from employee where employeeno=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, number);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Employee employee=new Employee();
				employee.setId(resultset.getInt("idemployee"));
				employee.setNumber(resultset.getString("employeeno"));
				employee.setIntodate(resultset.getString("employeeintodate"));
				employee.setName(resultset.getString("employeename"));
				employee.setIdcard(resultset.getString("employeeidcard"));
				employee.setPassword(resultset.getString("employeepassword"));
				employee.setGender(resultset.getString("employeegender"));
				employee.setAge(resultset.getString("employeeage"));
				employee.setBirthday(resultset.getString("employeebirthday"));
				employee.setMobile(resultset.getString("employeemobile"));
				employee.setEducation(resultset.getString("employeeeducation"));
				employee.setAddress(resultset.getString("employeeaddress"));
				l.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public String newNumber() {
		String sql="select MAX(employeeno) from employee";
		String maxEmployeeId = null;
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {maxEmployeeId = resultset.getString(1);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return maxEmployeeId;
	}

	@Override
	public void update(Employee employee) {
		String sql="update employee set employeeno=?,employeeintodate=?,employeename=?,employeeidcard=?,employeepassword=?,employeegender=?,employeeage=?,employeebirthday=?,employeemobile=?,employeeeducation=?,employeeaddress=? where idemployee=?";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, employee.getNumber());
			preparedstatement.setString(2, employee.getIntodate());
			preparedstatement.setString(3, employee.getName());
			preparedstatement.setString(4, employee.getIdcard());
			preparedstatement.setString(5, employee.getPassword());
			preparedstatement.setString(6, employee.getGender());
			preparedstatement.setString(7, employee.getAge());
			preparedstatement.setString(8, employee.getBirthday());
			preparedstatement.setString(9, employee.getMobile());
			preparedstatement.setString(10, employee.getEducation());
			preparedstatement.setString(11, employee.getAddress());
			preparedstatement.setInt(12, employee.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from employee where idemployee=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
