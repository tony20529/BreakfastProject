package service;

import java.util.List;

import org.jfree.chart.JFreeChart;

import model.Porder;



public interface PorderService {
			//create
			void add(Porder porder);	
			
			//read
			String All();
			String[][] AllEx();
			List<Porder>readAll();
			JFreeChart Amount();
			Porder findById(int id);
			Porder findByNumber(String number);
			String porderNumber();
			
			//update
			void update(Porder porder);
			//delete
			void delete(int id);
}
