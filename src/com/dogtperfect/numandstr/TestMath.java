package com.dogtperfect.numandstr;

public class TestMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f1 = 5.4f;
		float f2 = 5.5f;
		System.out.println(Math.round(f1));
		System.out.println(Math.round(f2));
		System.out.println(Math.random());
		System.out.println( (int)(Math.random()*10));
		System.out.println(Math.sqrt(64));
		System.out.println(Math.pow(2, 10));
		System.out.println(Math.PI);
		System.out.println(Math.E);
		int n = Integer.MAX_VALUE;
		System.out.println( Math.pow((1+1d/n), n));// 1f 不行
		int count = 0;
		for(int i = 2; i <= 100; i++) {
			boolean prime = false;
			int c =0;
			for(int j = i; j>=1; j--) {
				if((i%j) == 0)
					c ++;
				if (c > 2 )
					break;
				if (j == 1) {
					prime = true;
					System.out.println(i);
				}
			}
			if (prime == true )
				count++;
			else
				continue;
		}
		System.out.println("prime count is : "+ count);
		
		countPrime(100);
	}

	public static void countPrime(int max) {
		int count = 0;
		for(int i =2; i<=max; i++) {
			if( isPrime(i)) {
				count++;
			}
		}
		System.out.println(max+" 以内有  "+ count +" 个质数");
	}
	
	public static boolean isPrime(int i) {
		for (int j=2; j <=Math.sqrt(i); j++) {
			if (i%j == 0)
				return false;
		}
		return true;
	}
	
}
