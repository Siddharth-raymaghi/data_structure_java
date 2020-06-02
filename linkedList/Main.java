package com.linkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {1,2,3,4,5};
		LinkedList<Integer> ls = new LinkedList<>();
		ls.push(0);
		ls.pushAll(data);
		ls.insertAt(6, 98);
		ls.reverseList();
		ls.printList();
	}

}
