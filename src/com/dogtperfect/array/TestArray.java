package com.dogtperfect.array;

import java.util.Arrays;

public class TestArray {
	
	//√∞≈›≈≈–Ú
	public static int findMin(int[] a) {
		for (int i =0; i<a.length-1; i++) {
			if (a[i] > a[i+1]) {
				int temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		}
		return a[a.length-1];
	}
	
	public static String reverse(int[] a) {
		int [] r = new int [a.length];
		int j = a.length-1;
		for (int i = 0; i<a.length; i++) {
			r[j--] = a[i];
			
		}
		return Arrays.toString(r);
	}
	
	public static void copyArray() {
		int [] a = new int[] {2,4,1,5,3};
		int [] b = new int[5];
		int [] c = new int[a.length+b.length];
		
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println(Arrays.toString(b));
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println(Arrays.toString(c));
	}
	
	public static void twoDimensionArray() {
		int[][] a2 = new int[5][5];
		int[][] a3 = new int[][] {
			{1,2,3},
			{4,5},
			{6},
		};
		for(int i =0; i<a2.length ; i++) {
			for(int j =0; j<a2[i].length; j++) {
				a2[i][j] = (int) (Math.random()*100);
			}
		}
		System.out.println(Arrays.deepToString(a2));
		
		int max = -1;
		int maxi = -1;
		int maxj= -1;
		for(int i =0; i<a2.length ; i++) {
			for(int j =0; j<a2[i].length; j++) {
				if(a2[i][j]> max) {
					max = a2[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}
		System.out.println("max value is: "+max+ " dimension is :"+ maxi +", "+maxj );
	}
	
	public static void testArrays () {
		int a[] = new int[] {18, 62, 68, 82, 65, 9};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int [] b = Arrays.copyOfRange(a, 0, 3);
		System.out.println(Arrays.toString(b));
		System.out.println("65 at position: "+ Arrays.binarySearch(a, 65));	
		Arrays.fill(a, 6);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sortTwoDimensionArray() {
		int [][]a = new int [3][4];
		for(int i =0; i<a.length;i++) {
			for (int j=0 ;j<a[i].length; j++) {
				a[i][j] = (int)(Math.random() * 100);
			}
		}
		System.out.println("output two dimension array:");
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		int [] b = new int [a.length* a[0].length];
		for (int i=0; i< a.length; i++) {
			System.arraycopy(a[i], 0, b, a[i].length*i, a[i].length);
		}
		Arrays.sort(b);
		for(int i =0;i<a.length; i++) {
			System.arraycopy(b, i*a[i].length, a[i], 0, a[i].length);
		}
		System.out.println("after sort: ");
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] a = new int[] {2,4,1,5,3};
//		System.out.println(Arrays.toString(a));		
//		System.out.println(findMin(a));
//		System.out.println(reverse(a));
//		copyArray();
//		twoDimensionArray();	
//		testArrays ();
		sortTwoDimensionArray();
	}

}
