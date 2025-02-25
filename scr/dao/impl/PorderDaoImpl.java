package dao.impl;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;



import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {
	private static Connection conn=DbConnection.getDb();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Porder porder) {
		String sql="insert into porder(porderno,customno,productno,amount,employeeno,pordertime) "
				+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getNumber());
			preparedstatement.setString(2, porder.getCustomno());
			preparedstatement.setString(3, porder.getProductno());
			preparedstatement.setInt(4, porder.getAmount());
			preparedstatement.setString(5, porder.getEmployeeno());
			preparedstatement.setString(6, porder.getPordertime());
			

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("idporder"));
				porder.setNumber(resultset.getString("porderno"));
				porder.setCustomno(resultset.getString("customno"));
				porder.setProductno(resultset.getString("productno"));
				porder.setAmount(resultset.getInt("amount"));
				porder.setEmployeeno(resultset.getString("employeeno"));
				porder.setPordertime(resultset.getString("pordertime"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;

	}
	
	@Override
	public JFreeChart Amount(){
		 StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
	        standardChartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 20)); // 标题字体
	        standardChartTheme.setLargeFont(new Font("宋体", Font.BOLD, 16)); // 图例字体
	        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 12)); // 其他元素字体
	        ChartFactory.setChartTheme(standardChartTheme);
		String sql="select allporder.productname,sum(allporder.amount) as amounts from allporder group by allporder.productname";
		DefaultPieDataset dataset = new DefaultPieDataset();

		try {
			Statement stmt=(Statement) conn.createStatement();
			ResultSet resultset=((java.sql.Statement) stmt).executeQuery(sql);
			while(resultset.next())
			{
				String productNname = resultset.getString("productname");
                int amounts = resultset.getInt("amounts");
                dataset.setValue(productNname, amounts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	
		return ChartFactory.createPieChart(
                "Product Sell Report",   // 圖表標題
                dataset,
                true, true, false);
		}
	


	@Override
	public List<Porder> selectById(int id) {
		String sql="select * from porder where idporder=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("idporder"));
				porder.setNumber(resultset.getString("porderno"));
				porder.setCustomno(resultset.getString("customno"));
				porder.setProductno(resultset.getString("productno"));
				porder.setAmount(resultset.getInt("amount"));
				porder.setEmployeeno(resultset.getString("employeeno"));
				porder.setPordertime(resultset.getString("pordertime"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Porder> selectByNumber(String number){
		String sql="select * from porder where porderno=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, number);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("idporder"));
				porder.setNumber(resultset.getString("porderno"));
				porder.setCustomno(resultset.getString("customno"));
				porder.setProductno(resultset.getString("productno"));
				porder.setAmount(resultset.getInt("amount"));
				porder.setEmployeeno(resultset.getString("employeeno"));
				porder.setPordertime(resultset.getString("pordertime"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public String newNumber() {
		String sql="select MAX(porderno) from porder";
		String maxPorderId = null;
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {maxPorderId = resultset.getString(1);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return maxPorderId;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set porderno=?,customno=?,productno=?,amount=?,employeeno=?,pordertime=? where idporder=?";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getNumber());
			preparedstatement.setString(2, porder.getCustomno());
			preparedstatement.setString(3, porder.getProductno());
			preparedstatement.setInt(4, porder.getAmount());
			preparedstatement.setString(5, porder.getEmployeeno());
			preparedstatement.setString(6, porder.getPordertime());
			preparedstatement.setInt(7, porder.getId());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where idporder=?";
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
