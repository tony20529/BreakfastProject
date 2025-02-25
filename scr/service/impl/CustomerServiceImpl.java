package service.impl;


import java.util.List;

import dao.impl.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	public static void main(String[] args) {
		
	}
	private static CustomerDaoImpl customerdaoimpl=new CustomerDaoImpl();
	@Override
	public void add(Customer customer) {
		customerdaoimpl.add(customer);
		
	}

	@Override
	public Customer Login(String username, String password) {
		Customer customer=null;
		List<Customer> l=customerdaoimpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			customer=l.get(0);
		}		
		
		return customer;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		return customerdaoimpl.selectByUsername(username).isEmpty();
	}

	@Override
	public String All() {
		List<Customer> l=customerdaoimpl.selectAll();
		String show="";
		
		for(Customer p:l)
		{
			
			show=show+"客戶ID:"+p.getId()+
					"\t客戶號碼:"+p.getNumber()+
					"\t客戶申請日期:"+p.getIntodate()+
					"\t客戶姓名:"+p.getName()+
					"\t客戶帳號:"+p.getUsername()+
					"\t客戶密碼:"+p.getPassword()+
					"\t客戶性別:"+p.getGender()+
					"\t客戶年齡:"+p.getAge()+
					"\t客戶電話:"+p.getMobile()+
					"\t客戶地址:"+p.getAddress()+
					"\n";
		}
		
		
		return show;
	}
	
	@Override
	public String[][] AllEx(){
		List<Customer> l=customerdaoimpl.selectAll();
		int rowIndex = 0;
		String[][] show = new String[l.size()][10];
		 
	        for (Customer p : l) {
	            show[rowIndex][0] = String.valueOf(p.getId());
	            show[rowIndex][1] = p.getNumber();
	            show[rowIndex][2] = p.getIntodate();
	            show[rowIndex][3] = p.getName();
	            show[rowIndex][4] = p.getUsername();
	            show[rowIndex][5] = p.getPassword();
	            show[rowIndex][6] = p.getGender();
	            show[rowIndex][7] = p.getAge();
	            show[rowIndex][8] = p.getMobile(); 
	            show[rowIndex][9] = p.getAddress(); 
	            rowIndex++;
	        }
	        return show;
	}
	
	@Override
	public String[][] CustomerReportEx(){
		List<Customer> l=customerdaoimpl.selectCustomerReport();
		int rowIndex = 0;
		String[][] show = new String[l.size()][4];
		 
	        for (Customer p : l) {
	            show[rowIndex][0] = p.getNumber();
	            show[rowIndex][1] = p.getName();
	            show[rowIndex][2] = String.valueOf(p.getBuysum());
	            show[rowIndex][3] = String.valueOf(p.getSum());
	            rowIndex++;
	        }
	        return show;
	}
	
	@Override
	public List<Customer>readAll(){
		return customerdaoimpl.selectAll();
	}

	@Override
	public Customer findById(int id) {
		Customer customer=null;
		if(id>0)
		{
			List<Customer> l=customerdaoimpl.selectById(id);
			if(l.size()>0)
			{
				customer=l.get(0);
			}
			
		}	
		return customer;
	}

	@Override
	public Customer findByNumber(String number) {
		Customer customer=null;
		List<Customer> l=customerdaoimpl.selectByNumber(number);
		if(l.size()>0)
		{
			customer=l.get(0);
		}
			
			
		return customer;
	}
	
	@Override
	public String customerNumber() {
		String customernumber;
		if(customerdaoimpl.newNumber()!=null) {
			String numberPart=customerdaoimpl.newNumber().substring(1);
			 int number = Integer.parseInt(numberPart);
			 number++;
			 String newNumberPart = String.format("%05d", number);
			 customernumber="C" + newNumberPart;
		}
		else {
			customernumber="C00001";
		}
		return customernumber;
	}

	@Override
	public void update(Customer customer) {
		if(!customerdaoimpl.selectById(customer.getId()).isEmpty()) {customerdaoimpl.update(customer);}
	}

	@Override
	public void delete(int id) {
		if(!customerdaoimpl.selectById(id).isEmpty()){customerdaoimpl.delete(id);}
		
	}

}
