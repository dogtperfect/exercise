package me.xunmi.collection;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public Node leftNode;
	public Node rightNode;
	public Object value;
	
	public void add(Object v) {
		if(null == value) {
			value = v;
		} else {
			if((Integer)v - ((Integer)value) <= 0) {
				if (null == leftNode ) {
					leftNode = new Node();
				}
				leftNode.add(v);
			} else {
				if (null == rightNode) {
					rightNode = new Node();
				}
				rightNode.add(v);
			}
		}
	}
	
	public List<Object> middleOrder() {
		List<Object> order = new ArrayList<>();
		if(null != leftNode) {
			order.addAll(leftNode.middleOrder());
		}
		
		order.add(value);
		
		if(null != rightNode) {
			order.addAll(rightNode.middleOrder());
		}
		
		return order;
	}
}
