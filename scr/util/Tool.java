package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;


	//存檔資料:

	public class Tool {
	public static void main(String[] args) {
		
	}	
		
	public static void save(Object s,String filename) {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//讀取資料:
	
	public static Object read(String filename) {
		Object o=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
		
	}

	
	//時間控制:
	
		public static String format(int number)
		{
			return number<10?"0"+number:""+number;
		}
		
		public static String Week(int number)
		 {
		  String[] x={"日","一","二","三","四","五","六"};
		  return "("+x[number]+")";
		 }
		
		public static String getTime()
		{
			Calendar calendar=new GregorianCalendar ();
			int Year=calendar.get (Calendar.YEAR);
			int Month=calendar.get(Calendar.MONTH)+1;
			int Date=calendar.get (Calendar.DAY_OF_MONTH);
			int Week=calendar.get(Calendar.DAY_OF_WEEK)-1;
			int Hour=calendar.get (Calendar.HOUR_OF_DAY);
			int Minute=calendar.get (Calendar.MINUTE);
			int Second=calendar.get(Calendar.SECOND) ;
			return format(Year)+"/"+format(Month)+"/"+format(Date)+Week(Week)+format(Hour)+":"+format(Minute)+":"+format(Second);
		}	
		
		public static String getTime1()
		{
			Calendar calendar=new GregorianCalendar ();
			int Year=calendar.get (Calendar.YEAR);
			int Month=calendar.get(Calendar.MONTH)+1;
			int Date=calendar.get (Calendar.DAY_OF_MONTH);
			int Hour=calendar.get (Calendar.HOUR_OF_DAY);
			int Minute=calendar.get (Calendar.MINUTE);
			return format(Year)+"/"+format(Month)+"/"+format(Date)+" "+format(Hour)+":"+format(Minute);
		}	
		public static String getDate()
		{
			Calendar calendar=new GregorianCalendar ();
			int Year=calendar.get (Calendar.YEAR);
			int Month=calendar.get(Calendar.MONTH)+1;
			int Date=calendar.get (Calendar.DAY_OF_MONTH);
			int Week=calendar.get(Calendar.DAY_OF_WEEK)-1;
			return format(Year)+"/"+format(Month)+"/"+format(Date)+Week(Week);
		}	
		
		public static String encrypt(String input) {
			if (input == null) {
	            return null;
	        }
			 // 去除前後空格
	        input = input.trim();
	        try {
	        	 // 獲取 SHA - 256 的方法
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            // 計算字符串的哈希值
	            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
	            for (byte b : encodedHash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	           return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	           throw new RuntimeException(e);
	        }
	    }
		
		
		
	        
	    

	
}
