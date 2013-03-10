package com.dihuib.gson;

import org.junit.Test;

public class TypeErasureTest {
	
	@Test
	public void testTypeErasure() {
		MyNode mn = new MyNode(5);
		Node n = mn;
		n.setData("Hello");
		Integer x = mn.getData();
	}
}

class Node<T> {
	private T data;
	
	public Node() {
		
	}
	
	public Node(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
}

class MyNode extends Node<Integer> {
	public MyNode(Integer data) {super(data);}
	
	public void setData(Integer data) {
		System.out.println("MyNode.setData");
		super.setData(data);
	}
	
	
}