package dao;

import java.util.List;

import org.jfree.chart.JFreeChart;

import model.Porder;



public interface PorderDao {
			//create-->void
			void add(Porder porder);
			
			
			//read-->List
			List<Porder> selectAll();
			JFreeChart Amount();
			List<Porder> selectById(int id);
			List<Porder> selectByNumber(String number);
			String newNumber();
			
			//update-->void
			void update(Porder porder);
			
			//delete-->void
			void delete(int id);

}
