package com.dogtperfect.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
	
	public static void testDateFormat() {
		
		// date -> simpledateformat.format(date) -> string
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		String str = sdf.format(d);
		System.out.println("after format: "+str);
		System.out.println();
		
		
		// string -> simpledateformat.parse(string) -> date
		String f = "2017-08-08 14:00:00";
		try {
			Date df = sdf.parse(f);	
			System.out.println("from date format string get : "+ df);
			String str1 = sdf.format(df);
			System.out.println("after format: "+str1);
			System.out.println();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void genRandomDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startYear = "1970-01-01 00:00:00";
		String endYear = "2000-12-31 23:59:59";
		Date[] dateArray = new Date[9];
		long [] milesec = new long[9];
		try {
			Date startY= sdf.parse(startYear);
			Date endY= sdf.parse(endYear);
			long start = startY.getTime();
			long end = endY.getTime();
			System.out.println();
			System.out.println("startY: "+startY);
			System.out.println("endY: "+endY);
			System.out.println();
			for (int i=0; i< dateArray.length; i++) {
		    	long s=(long)((Math.random())*(end-start));
		    	dateArray[i] = new Date(s);
		    	milesec[i] = s;
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		for(Date d: dateArray) {
			System.out.println(d);
		}
		for(long m: milesec) {
			System.out.println(m);
		}
		System.out.println();
		for (int i =0 ; i< milesec.length; i++) {

			int index = i;
			for(int j =i+1; j < milesec.length; j++) {
				
				if ( milesec[j] < milesec[index]) {
					index = j; 
				}
			}
			if (index != i) {
				long temp = milesec[i];
				milesec[i] = milesec[index];
				milesec[index] = temp;
			}
		}
		for(long m: milesec) {
			System.out.println(m);
			System.out.println(new Date(m));
		}
	}

	public static void testCalendar() {
		//单例模式
		Calendar cal =  Calendar.getInstance(); 
		// 当前时间  calendar -> date
		Date da1 = cal.getTime(); 	
		System.out.println(da1);
		
		Date da2 = new Date(0);
		System.out.println(da2);
		// date -> calendar
		cal.setTime(da2);
		System.out.println(cal);
		System.out.println();
		
		cal.setTime(da1);
		cal.add(Calendar.MONTH, 3);
		System.out.println(cal.getTime());
		
		cal.add(Calendar.YEAR, 2);
		System.out.println(cal.getTime());
		
		cal.set(Calendar.DATE, 1);
		System.out.println(cal.getTime());
		
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -3);
		System.out.println(cal.getTime());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testDateFormat();
		testCalendar();
//		genRandomDate();
		
	}

}
