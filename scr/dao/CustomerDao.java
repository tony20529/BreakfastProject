package dao;

import java.util.List;

import model.Customer;




public interface CustomerDao {
			//create-->void
			void add(Customer customer);//新增客戶
			
			
			//read-->List
			List<Customer> selectAll();//觀看客戶名單
			List<Customer> selectCustomerReport();
			List<Customer> selectUsernameAndPassword(String username,String password);
			//驗證帳號與密碼是否存在
			List<Customer> selectByUsername(String username);
			//驗證帳號是否存在
			List<Customer> selectById(int id);//搜尋ID
			List<Customer> selectByNumber(String number); //搜尋客戶編號
			String newNumber();
			
			//update-->void
			void update(Customer customer);//更新客戶資料
			
			//delete-->void
			void delete(int id);//刪除客戶資料

}
