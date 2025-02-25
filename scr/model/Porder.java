package model;

import java.io.Serializable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Porder extends AbstractTableModel implements Serializable{
	private Integer id;
	private String number;
	private String customno;
	private String productno;
	private Integer amount;
	private String employeeno;
	private String pordertime;
	private final String[] columnNames = {"訂單ID", "訂單編號", "客戶編號","產品編號", "產品數量","員工編號","訂單時間"};
	private List<Porder>porders;
	private String productname;
	private Integer amounts;
	
	public Porder(Integer id, String number, String customno, String productno, Integer amount, String employeeno,
			String pordertime) {
		super();
		this.id = id;
		this.number = number;
		this.customno = customno;
		this.productno = productno;
		this.amount = amount;
		this.employeeno = employeeno;
		this.pordertime = pordertime;
	}
	
	public Porder(String number, String customno, String productno, Integer amount, String employeeno,
			String pordertime) {
		super();
		this.number = number;
		this.customno = customno;
		this.productno = productno;
		this.amount = amount;
		this.employeeno = employeeno;
		this.pordertime = pordertime;
	}
	
	public Porder(String productname, Integer amounts) {
		super();
		this.productname = productname;
		this.amounts = amounts;
	}

	public Porder(List<Porder> porders) {
		super();
		this.porders = porders;
	}

	public Porder() {
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
	public String getCustomno() {
		return customno;
	}
	public void setCustomno(String customno) {
		this.customno = customno;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getEmployeeno() {
		return employeeno;
	}
	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}
	public String getPordertime() {
		return pordertime;
	}
	public void setPordertime(String pordertime) {
		this.pordertime = pordertime;
	}
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getAmounts() {
		return amounts;
	}

	public void setAmounts(Integer amounts) {
		this.amounts = amounts;
	}

	@Override
	public int getRowCount() {
		return porders.size();
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
		Porder porder=porders.get(rowIndex);
		switch (columnIndex) {
        case 0: return porder.getId();
        case 1: return porder.getNumber();
        case 2: return porder.getCustomno();
        case 3: return porder.getProductno();
        case 4: return porder.getAmount();
        case 5: return porder.getEmployeeno();
        case 6: return porder.getPordertime();
        default: return null;
        }
	}
	

}
