package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {
	private static Connection conn=DbConnection.getDb();
	public static void main(String[] args) {
		List <Product> l=new ProductDaoImpl().selectMenu();
		for(Product s:l) {System.out.println(s.getNumber()+"\t"+s.getName()+"\t"+s.getPrice());}
	}

	@Override
	public void add(Product product) {
		String sql="insert into product(productno,productname,productprice,productinventory,productsafeinventory,productintodate) "
				+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, product.getNumber());
			preparedstatement.setString(2, product.getName());
			preparedstatement.setInt(3, product.getPrice());
			preparedstatement.setInt(4, product.getInventory());
			preparedstatement.setInt(5, product.getSafeinventory());
			preparedstatement.setString(6, product.getIntodate());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAll() {
		String sql="select * from product";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Product product=new Product();
				product.setId(resultset.getInt("idproduct"));
				product.setNumber(resultset.getString("productno"));
				product.setName(resultset.getString("productname"));
				product.setPrice(resultset.getInt("productprice"));
				product.setInventory(resultset.getInt("productinventory"));
				product.setSafeinventory(resultset.getInt("productsafeinventory"));
				product.setIntodate(resultset.getString("productintodate"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}
	
	@Override
	public List<Product> selectMenu() {
		String sql="SELECT product.productno,product.productname,product.productprice from product";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Product product=new Product();
				product.setNumber(resultset.getString("productno"));
				product.setName(resultset.getString("productname"));
				product.setPrice(resultset.getInt("productprice"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Product> selectById(int id) {
		String sql="select * from product where idproduct=?";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Product product=new Product();
				product.setId(resultset.getInt("idproduct"));
				product.setNumber(resultset.getString("productno"));
				product.setName(resultset.getString("productname"));
				product.setPrice(resultset.getInt("productprice"));
				product.setInventory(resultset.getInt("productinventory"));
				product.setSafeinventory(resultset.getInt("productsafeinventory"));
				product.setIntodate(resultset.getString("productintodate"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Product> selectByNumber(String number){
		String sql="select * from product where productno=?";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, number);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Product product=new Product();
				product.setId(resultset.getInt("idproduct"));
				product.setNumber(resultset.getString("productno"));
				product.setName(resultset.getString("productname"));
				product.setPrice(resultset.getInt("productprice"));
				product.setInventory(resultset.getInt("productinventory"));
				product.setSafeinventory(resultset.getInt("productsafeinventory"));
				product.setIntodate(resultset.getString("productintodate"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Product> selectByName(String name){
		String sql="select * from product where productname=?";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, name);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Product product=new Product();
				product.setId(resultset.getInt("idproduct"));
				product.setNumber(resultset.getString("productno"));
				product.setName(resultset.getString("productname"));
				product.setPrice(resultset.getInt("productprice"));
				product.setInventory(resultset.getInt("productinventory"));
				product.setSafeinventory(resultset.getInt("productsafeinventory"));
				product.setIntodate(resultset.getString("productintodate"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public String newNumber() {
		String sql="select MAX(productno) from product";
		String maxProductId = null;
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {maxProductId = resultset.getString(1);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return maxProductId;
	}

	@Override
	public void update(Product product) {
		String sql="update product set productno=?,productname=?,productprice=?,productinventory=?,productsafeinventory=?,productintodate=? where idproduct=?";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, product.getNumber());
			preparedstatement.setString(2, product.getName());
			preparedstatement.setInt(3, product.getPrice());
			preparedstatement.setInt(4, product.getInventory());
			preparedstatement.setInt(5, product.getSafeinventory());
			preparedstatement.setString(6, product.getIntodate());
			preparedstatement.setInt(7, product.getId());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from product where idproduct=?";
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
