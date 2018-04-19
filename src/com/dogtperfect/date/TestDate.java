package com.dogtperfect.date;

import java.util.Date;

public class TestDate {

	public static void testDate() {
		Date d1 = new Date();
		System.out.println("now time is "+ d1);
		System.out.println();
		
		Date d2 = new Date(5000);
		System.out.println("from 1970-01-01 08:00:00, 5s passed");
		System.out.println(d2);
		
		Date now = new Date();
		System.out.println("now time is "+ now.toString());
		System.out.println("gettime() is "+ now.getTime());
		System.out.println("System.current: "+ System.currentTimeMillis());
		
		Date zero = new Date(0);
		System.out.println("use 0 to construct: "+ zero);			
	}
	
	public static void randomDate() {
		long sec =1000;
		long min = 60*sec;
		long hour = 60*min;
		long day = 24*hour;
		long year = 365*day;
		long year1995 = (1995-1970)*year;
		long leapDay = (1995-1970)/4*day;
		year1995 += leapDay;
		year1995 = year1995 - 8*hour;
		long year1995End = year1995 + year - 1; // 减一 , 否则到1996了
		Date year95 = new Date(year1995);
		Date year95End = new Date(year1995End);
		System.out.println("1995 first day is "+ year95);
		System.out.println("1995 last day is  "+ year95End);
		long randomTime = (long) (Math.random()*(year-1)) + year1995;
		Date dRandom = new Date(randomTime);
		System.out.println("random date in 1995 is: "+ dRandom);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testDate();
		randomDate();
	}

}
