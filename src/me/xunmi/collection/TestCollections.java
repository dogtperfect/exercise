package me.xunmi.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	public static void testCollectionMethod() {
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i<10; i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		
		Collections.reverse(numbers);
		System.out.println(numbers);
		
		Collections.shuffle(numbers);
		System.out.println(numbers);
		
		Collections.sort(numbers);
		System.out.println(numbers);
		
		Collections.swap(numbers, 0, 9);
		System.out.println(numbers);
		
		Collections.rotate(numbers, 3);
		System.out.println(numbers);
		
		List<Integer> numbers2 = new ArrayList<>();
		List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers2);
	}
	
	public static void calculateProbability() {
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i<10; i++) {
			numbers.add(i);
		}
		int count = 0;
		for(int i=0; i<1000000; i++) {
			Collections.shuffle(numbers);
			if(numbers.get(0) == 3 && numbers.get(1) == 1 && numbers.get(2) == 4  ) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testCollectionMethod();
		calculateProbability();
	}

}
