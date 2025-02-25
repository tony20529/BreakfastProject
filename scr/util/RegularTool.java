package util;

import java.util.regex.Pattern;

public class RegularTool {
	public static void main(String[] args) {
		
	}
	
	public static boolean AddName(String name){
		return !Pattern.matches("^[a-zA-Z\\u4e00-\\u9fa5]{2,10}|[a-zA-Z]{1,10}$", name);
	}
	public static boolean AddUsername(String username) {
		return !Pattern.matches("^[a-zA-Z0-9]{6,10}$", username);
	}
	public static boolean AddPassword(String password) {
		return !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{6,12}$", password);
	}
	public static boolean AddAge(String age) {
		return !Pattern.matches("^(1|[2-9]|[1-9][0-9]|1[0-4][0-9]|150)$", age);
	}
	public static boolean AddMobile(String mobile) {
		return !Pattern.matches("^09[0-9]{8}$", mobile);
	}
	public static boolean AddAddress(String address) {
		return !Pattern.matches("(?<city>\\D+[縣市])(?<district>\\D+?(市區|鎮區|鎮市|[鄉鎮市區]))(?<others>.+)", address);
	}
	public static boolean Id(String id) {
		return !Pattern.matches("^[0-9]*$", id);
	}
	public static boolean AddBirthday(String birthday) {
		if(!Pattern.matches("^(0?[1-9]|[1-8][0-9]|9[0-4])/([1-9]|1[0-2])/([1-9]|[12][0-9]|3[01])$", birthday)) {return false;}
		else {
			 String[] parts = birthday.split("/");
		        int year = Integer.parseInt(parts[0]);
		        int month = Integer.parseInt(parts[1]);
		        int day = Integer.parseInt(parts[2]);
		        switch (month) {
	            case 4:
	            case 6:
	            case 9:
	            case 11:
	                return day <= 30;
	            case 2:
	                return day <= 29;
	            default:
	                return day <= 31;
	        }
		        
		}
	}
	public static boolean AddIdCard(String idcard) {
		return !Pattern.matches("^[A-Z]\\d{9}$", idcard);
	}
	public static boolean AddInt(String number) {
		return !Pattern.matches("^[0-9]+$", number);
	}
}
