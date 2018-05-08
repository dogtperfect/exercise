package me.xunmi.collection;

import java.util.Arrays;
import java.util.List;

public class testTree {
	
	interface Sort{
		public void sort();
		public int[] values();
	}
	
	static class Selection implements Sort{
		int[] numbers;
		Selection(int[] numbers){
			this.numbers = numbers;
		}
		
		public void sort() {
			
			for(int j = numbers.length -1; j > 0; j--) {
				int max = Integer.MIN_VALUE;
				int index = 0;
				for(int i =0; i<= j; i++) {
					if(numbers[i] > max) {
						max = numbers[i];
						index = i;
					}
				}
				int temp = numbers[index];
				numbers[index] = numbers[j];
				numbers[j] = temp;
			}
		}
		
		public int[] values() {
			return numbers;
		}
	}
	
	static class Bubble implements Sort{
		int[] numbers;
		Bubble(int[] numbers){
			this.numbers = numbers;
		}
		
		public void sort() {
			for(int j = numbers.length-1; j > 0 ; j--) {
				for(int i=0; i < j; i++) {
					if (numbers[i] > numbers[i+1]) {
						int temp = numbers[i];
						numbers[i] = numbers[i+1];
						numbers[i+1] = temp;
					}
				}
			}
		}
		
		public int[] values() {
			return numbers;
		}
	}
	
	static class Tree implements Sort{
		int[] numbers;
		Node n = null;
		Tree(int[] numbers){
			this.numbers = numbers;
			n = new Node();
		}
		
		public void sort() {
			for(int i =0; i<numbers.length; i++) {
				n.add(numbers[i]);
			}
		}
		
		public int[] values() {
			List<Object> list = n.middleOrder();
			int[] sortedNumbers = new int [list.size()];
			for (int i=0; i<sortedNumbers.length; i++) {
				sortedNumbers[i] = (int) list.get(i);
			}
			return sortedNumbers;
		}
	}
	
	public static void compareSort() {
		int total = 40000;
		int[] original = new int[total];
		for(int i=0; i<total; i++) {
			original[i] = (int) (Math.random()*total);
		}
		int[] use4sort;
		use4sort = Arrays.copyOf(original, total);
		int [] selection = speed(new Selection(use4sort),"selection");
		
		use4sort = Arrays.copyOf(original, total);
		int [] bubble = speed(new Bubble(use4sort),"bubbling");
		
		use4sort = Arrays.copyOf(original, total);
		int [] tree = speed(new Tree(use4sort),"binary tree");
		
		System.out.println("-----selection--------");
//		System.out.println(Arrays.toString(selection));
		System.out.println("------bubble -------");
//		System.out.println(Arrays.toString(bubble));
		System.out.println("--------tree---------");
//		System.out.println(Arrays.toString(tree));
		
		System.out.println("compare between selection and bubble: "+ Arrays.equals(selection, bubble));
		System.out.println("compare between tree and bubble: "+ Arrays.equals(tree, bubble));
		
	}
	
//²ßÂÔÄ£Ê½	
	public static int[] speed(Sort algorithm,String type) {
		long start = System.currentTimeMillis();
		algorithm.sort();
		long stop = System.currentTimeMillis();
		
		System.out.println("algorithm "+type+" use "+(stop-start) +" milseconds");
		return algorithm.values();
	}
	
	public static void insert() {
		int[] array = new int[] {77,21,8,91,35,14,81,56,11,62};
		Node root = new Node();
		for(int number: array) {
			root.add(number);
		}
		System.out.println(root.middleOrder());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insert();
		compareSort();
	}
}
