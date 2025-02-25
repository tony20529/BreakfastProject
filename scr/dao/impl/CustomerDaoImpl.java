package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import model.Customer;
import util.DbConnection;

public class CustomerDaoImpl implements  CustomerDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static Connection conn=DbConnection.getDb();
	
	@Override
	public void add(Customer customer) {
		String sql="insert into customer(customno,customerintodate,customername,customerusername,customerpassword,customergender,customerage,customermobile,customeraddress) "
				+"values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, customer.getNumber());
			preparedstatement.setString(2, customer.getIntodate());
			preparedstatement.setString(3, customer.getName());
			preparedstatement.setString(4, customer.getUsername());
			preparedstatement.setString(5, customer.getPassword());
			preparedstatement.setString(6, customer.getGender());
			preparedstatement.setString(7, customer.getAge());
			preparedstatement.setString(8, customer.getMobile());
			preparedstatement.setString(9, customer.getAddress());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Customer> selectAll() {
		String sql="select * from customer";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Customer customer=new Customer();
				customer.setId(resultset.getInt("idcustomer"));
				customer.setNumber(resultset.getString("customno"));
				customer.setIntodate(resultset.getString("customerintodate"));
				customer.setName(resultset.getString("customername"));
				customer.setUsername(resultset.getString("customerusername"));
				customer.setPassword(resultset.getString("customerpassword"));
				customer.setGender(resultset.getString("customergender"));
				customer.setAge(resultset.getString("customerage"));
				customer.setMobile(resultset.getString("customermobile"));
				customer.setAddress(resultset.getString("customeraddress"));
				l.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
		
	}
	
	@Override
	public List<Customer> selectCustomerReport() {
		String sql="select * from customer_report";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Customer customer=new Customer();
				customer.setNumber(resultset.getString("顧客編號"));
				customer.setName(resultset.getString("顧客姓名"));
				customer.setBuysum(resultset.getInt("購買訂單數"));
				customer.setSum(resultset.getInt("總消費額"));
				
				l.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
		
	}
	
	@Override
	public List<Customer> selectUsernameAndPassword(String username,String password){
		String sql="select * from customer where customerusername=? and customerpassword=?";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Customer customer=new Customer();
				customer.setId(resultset.getInt("idcustomer"));
				customer.setNumber(resultset.getString("customno"));
				customer.setIntodate(resultset.getString("customerintodate"));
				customer.setName(resultset.getString("customername"));
				customer.setUsername(resultset.getString("customerusername"));
				customer.setPassword(resultset.getString("customerpassword"));
				customer.setGender(resultset.getString("customergender"));
				customer.setAge(resultset.getString("customerage"));
				customer.setMobile(resultset.getString("customermobile"));
				customer.setAddress(resultset.getString("customeraddress"));
				l.add(customer);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return l;
	}
	
	@Override
	public List<Customer> selectByUsername(String username){
		String sql="select * from customer where customerusername=?";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Customer customer=new Customer();
				customer.setId(resultset.getInt("idcustomer"));
				customer.setNumber(resultset.getString("customno"));
				customer.setIntodate(resultset.getString("customerintodate"));
				customer.setName(resultset.getString("customername"));
				customer.setUsername(resultset.getString("customerusername"));
				customer.setPassword(resultset.getString("customerpassword"));
				customer.setGender(resultset.getString("customergender"));
				customer.setAge(resultset.getString("customerage"));
				customer.setMobile(resultset.getString("customermobile"));
				customer.setAddress(resultset.getString("customeraddress"));
				l.add(customer);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}
	
	@Override
	public List<Customer> selectById(int id) {
		String sql="select * from customer where idcustomer=?";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Customer customer=new Customer();
				customer.setId(resultset.getInt("idcustomer"));
				customer.setNumber(resultset.getString("customno"));
				customer.setIntodate(resultset.getString("customerintodate"));
				customer.setName(resultset.getString("customername"));
				customer.setUsername(resultset.getString("customerusername"));
				customer.setPassword(resultset.getString("customerpassword"));
				customer.setGender(resultset.getString("customergender"));
				customer.setAge(resultset.getString("customerage"));
				customer.setMobile(resultset.getString("customermobile"));
				customer.setAddress(resultset.getString("customeraddress"));
				l.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Customer> selectByNumber(String number){
		String sql="select * from customer where customno=?";
		List<Customer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, number);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Customer customer=new Customer();
				customer.setId(resultset.getInt("idcustomer"));
				customer.setNumber(resultset.getString("customno"));
				customer.setIntodate(resultset.getString("customerintodate"));
				customer.setName(resultset.getString("customername"));
				customer.setUsername(resultset.getString("customerusername"));
				customer.setPassword(resultset.getString("customerpassword"));
				customer.setGender(resultset.getString("customergender"));
				customer.setAge(resultset.getString("customerage"));
				customer.setMobile(resultset.getString("customermobile"));
				customer.setAddress(resultset.getString("customeraddress"));
				l.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public String newNumber() {
		String sql="select MAX(customno) from customer";
		String maxCustomerId = null;
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {maxCustomerId = resultset.getString(1);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return maxCustomerId;
	}
	
	@Override
	public void update(Customer customer) {
		String sql="update customer set customno=?,customerintodate=?,customername=?,customerusername=?,customerpassword=?,customergender=?,customerage=?,customermobile=?,customeraddress=? where idcustomer=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, customer.getNumber());
			preparedstatement.setString(2, customer.getIntodate());
			preparedstatement.setString(3, customer.getName());
			preparedstatement.setString(4, customer.getUsername());
			preparedstatement.setString(5, customer.getPassword());
			preparedstatement.setString(6, customer.getGender());
			preparedstatement.setString(7, customer.getAge());
			preparedstatement.setString(8, customer.getMobile());
			preparedstatement.setString(9, customer.getAddress());
			preparedstatement.setInt(10, customer.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(int id) {
		String sql="delete from customer where idcustomer=?";
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
