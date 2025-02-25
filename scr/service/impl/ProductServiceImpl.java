package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Porder;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static ProductDaoImpl productdaoimpl=new ProductDaoImpl();

	@Override
	public void add(Product product) {
		productdaoimpl.add(product);
		
	}

	@Override
	public String All() {
		List<Product>l=productdaoimpl.selectAll();
		String show="";
		
		for(Product p:l)
		{
			
			show=show+"產品ID:"+p.getId()+
					"\t產品號碼:"+p.getNumber()+
					"\t產品名稱:"+p.getName()+
					"\t產品價格:"+p.getPrice()+
					"\t產品庫存:"+p.getInventory()+
					"\t產品安全庫存:"+p.getSafeinventory()+
					"\t進貨日期:"+p.getIntodate()+
					"\n";
		}
		
		
		return show;
	}

	@Override
	public String[][] AllEx() {
		List<Product> l=productdaoimpl.selectAll();
		int rowIndex = 0;
		String[][] show = new String[l.size()][7];
		for(Product  p : l){
            show[rowIndex][0] = String.valueOf(p.getId());
            show[rowIndex][1] = p.getNumber();
            show[rowIndex][2] = p.getName();
            show[rowIndex][3] = String.valueOf(p.getPrice());
            show[rowIndex][4] = String.valueOf(p.getInventory());
            show[rowIndex][5] = String.valueOf(p.getSafeinventory());
            show[rowIndex][6] = p.getIntodate();
            rowIndex++;
        }
        return show;
	}

	@Override
	public List<Product> readAll() {
		return productdaoimpl.selectAll();
	}
	
	@Override
	public List<Product>readMenu(){
		return productdaoimpl.selectMenu();
	}

	@Override
	public Product findById(int id) {
		Product product=null;
		if(id>0) {
			List<Product> l=productdaoimpl.selectById(id);
			if(l.size()>0) {
				product=l.get(0);
			}
		}
		return product;
	}

	@Override
	public Product findByNumber(String number) {
		Product product=null;
		List<Product> l=productdaoimpl.selectByNumber(number);
		if(l.size()>0) {
			product=l.get(0);
		}
	
	return product;
	}
	
	@Override
	public Product findByName(String name) {
		Product product=null;
		List<Product> l=productdaoimpl.selectByName(name);
		if(l.size()>0) {
			product=l.get(0);
		}
	
	return product;
	}

	@Override
	public String productNumber() {
		String productnumber;
		if(productdaoimpl.newNumber()!=null) {
			String numberPart=productdaoimpl.newNumber().substring(1);
			 int number = Integer.parseInt(numberPart);
			 number++;
			 String newNumberPart = String.format("%05d", number);
			 productnumber="P" + newNumberPart;
		}
		else {
			productnumber="P00001";
		}
		return productnumber;
	}

	@Override
	public void update(Product product) {
		if(!productdaoimpl.selectById(product.getId()).isEmpty()) {productdaoimpl.update(product);}
		
	}
	
	@Override
	public void updateInventory(int inventory, String number) {
		Product p=findByNumber(number);
		p.setInventory(inventory);
		productdaoimpl.update(p);
	}

	@Override
	public void delete(int id) {
		if(!productdaoimpl.selectById(id).isEmpty()){productdaoimpl.delete(id);}
		
	}

}
