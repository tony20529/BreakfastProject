package service;

import java.util.List;

import model.Customer;

public interface CustomerService {
			//create
			void add(Customer customer);//加入會員	
			
			//read
			Customer Login(String username,String password);//驗證登入帳密是否正確
			boolean isUsernameBeenUse(String username);//驗證註冊的帳號是否有重複
			String All();//觀看所有成員表單
			String[][] AllEx();
			String[][] CustomerReportEx();
			List<Customer>readAll();
			Customer findById(int id);//查詢MemberID
			Customer findByNumber(String number);//查詢會員編號
			String customerNumber();//製造會員編號
			
			//update
			void update(Customer customer);//更改會員資料
			//delete
			void delete(int id);//刪除會員資料

}
