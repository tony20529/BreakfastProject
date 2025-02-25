package model;

import java.io.Serializable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Product extends AbstractTableModel implements Serializable{
	private Integer id;
	private String number;
	private String name;
	private Integer price;
	private Integer inventory;
	private Integer safeinventory;
	private String intodate;
	private final String[] columnNames = {"產品ID", "產品編號", "產品名稱","產品價格", "庫存數量","安全庫存數量","更新日期"};
	private List<Product>products;
	public Product(Integer id, String number, String name, Integer price, Integer inventory, Integer safeinventory,
			String intodate) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.safeinventory = safeinventory;
		this.intodate = intodate;
	}
	public Product(String number, String name, Integer price, Integer inventory, Integer safeinventory,
			String intodate) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.safeinventory = safeinventory;
		this.intodate = intodate;
	}
	
	public Product(List<Product> products) {
		super();
		this.products = products;
	}
	
	public Product(String number, String name, Integer price) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getSafeinventory() {
		return safeinventory;
	}
	public void setSafeinventory(Integer safeinventory) {
		this.safeinventory = safeinventory;
	}
	public String getIntodate() {
		return intodate;
	}
	public void setIntodate(String intodate) {
		this.intodate = intodate;
	}
	@Override
	public int getRowCount() {
		return products.size();
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	public String getColumnName(int column) {  
        return columnNames[column];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product=products.get(rowIndex);
		switch (columnIndex) {
        case 0: return product.getId();
        case 1: return product.getNumber();
        case 2: return product.getName();
        case 3: return product.getPrice();
        case 4: return product.getInventory();
        case 5: return product.getSafeinventory();
        case 6: return product.getIntodate();
        default: return null;
        }
	}
	
	
	

}
