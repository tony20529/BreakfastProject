package service.impl;

import java.util.List;

import org.jfree.chart.JFreeChart;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();
	
	@Override
	public void add(Porder porder) {
		porderdaoimpl.add(porder);
		
	}

	@Override
	public String All() {
		List<Porder>l=porderdaoimpl.selectAll();
		String show="";
		
		for(Porder p:l)
		{
			
			show=show+"訂單ID:"+p.getId()+
					"\t訂單號碼:"+p.getNumber()+
					"\t客戶號碼:"+p.getCustomno()+
					"\t產品號碼:"+p.getProductno()+
					"\t選購數量:"+p.getAmount()+
					"\t員工號碼:"+p.getEmployeeno()+
					"\t訂購時間:"+p.getPordertime()+
					"\n";
		}
		
		
		return show;
	}

	@Override
	public String[][] AllEx() {
		List<Porder> l=porderdaoimpl.selectAll();
		int rowIndex = 0;
		String[][] show = new String[l.size()][7];
		for(Porder  p : l){
            show[rowIndex][0] = String.valueOf(p.getId());
            show[rowIndex][1] = p.getNumber();
            show[rowIndex][2] = p.getCustomno();
            show[rowIndex][3] = p.getProductno();
            show[rowIndex][4] = String.valueOf(p.getAmount());
            show[rowIndex][5] = p.getEmployeeno();
            show[rowIndex][6] = p.getPordertime();
            rowIndex++;
        }
        return show;
	}

	@Override
	public List<Porder> readAll() {
		return porderdaoimpl.selectAll();
	}
	
	@Override
	public JFreeChart Amount() {
		return porderdaoimpl.Amount();
	}

	@Override
	public Porder findById(int id) {
		Porder porder=null;
		if(id>0) {
			List<Porder> l=porderdaoimpl.selectById(id);
			if(l.size()>0) {
				porder=l.get(0);
			}
		}
		return porder;
	}

	@Override
	public Porder findByNumber(String number) {
		Porder porder=null;
		List<Porder> l=porderdaoimpl.selectByNumber(number);
		if(l.size()>0) {
			porder=l.get(0);
		}
	
	return porder;
	}

	@Override
	public String porderNumber() {
		String pordernumber;
		if(porderdaoimpl.newNumber()!=null) {
			String numberPart=porderdaoimpl.newNumber().substring(1);
			 int number = Integer.parseInt(numberPart);
			 number++;
			 String newNumberPart = String.format("%05d", number);
			 pordernumber="O" + newNumberPart;
		}
		else {
			pordernumber="O00001";
		}
		return pordernumber;
	}

	@Override
	public void update(Porder porder) {
		if(!porderdaoimpl.selectById(porder.getId()).isEmpty()) {porderdaoimpl.update(porder);}
		
	}

	@Override
	public void delete(int id) {
		if(!porderdaoimpl.selectById(id).isEmpty()){porderdaoimpl.delete(id);}
		
	}

}
