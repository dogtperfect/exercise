package me.xunmi.collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestLinkedList implements Stack {
	
//ʵ��Dqueue �ӿ�	
	public static void testDequeue() {
		LinkedList<Hero> heros = new LinkedList<>();
		heros.addLast(new Hero("hero1"));
		heros.addLast(new Hero("hero2"));
		heros.addLast(new Hero("hero3"));
		heros.addLast(new Hero("hero4"));
		System.out.println(heros);
		
		heros.addFirst(new Hero("heroX"));
		heros.addLast(new Hero("heroY"));
		System.out.println(heros);
		
		System.out.println(heros.getFirst());
		System.out.println(heros.getLast());
		
		System.out.println(heros);
//ɾ����ͬʱ, ȡ��		
		System.out.println(heros.removeFirst());
		System.out.println(heros.removeLast());
		System.out.println(heros);
	}
	
//ʵ��Queue �ӿ�, ��offer, ��ɾpoll(ͶƱ), �鲻ɾ peek(͵��)
	public static void testQueue() {
		Queue<Hero> qHeros = new LinkedList<>();
		qHeros.offer(new Hero("hero1"));
		qHeros.offer(new Hero("hero2"));
		qHeros.offer(new Hero("hero3"));
		qHeros.offer(new Hero("hero4"));
		System.out.println(qHeros);
		
		Hero h = qHeros.poll();
		System.out.println("after poll first hero");
		System.out.println(h);
		System.out.println(qHeros);
		
		h = qHeros.peek();
		System.out.println("after peek first hero");
		System.out.println(h);
		System.out.println(qHeros);
	}
	
	LinkedList<Hero> heros = new LinkedList<>();
	public void push(Hero h) {
		heros.addLast(h);
	}

//��������  pop ������
	@Override
	public Hero pull() {
		return heros.removeLast();
	}
	
	@Override
	public Hero peek() {
		return heros.getLast();
	}
	
	public static void testStack() {
		TestLinkedList tll = new TestLinkedList();
		for(int i =0; i<5; i++) {
			System.out.println("push into stack hero: ");
			tll.push(new Hero("hero name "+i));
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("pull hero outof stack: ");
			tll.pull();
			System.out.println(tll.heros);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testDequeue();
//		testQueue();
		testStack();
	}

}
