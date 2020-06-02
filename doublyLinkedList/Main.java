package com.doublyLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<String> dls = new DoublyLinkedList<>();
		String[] s = {"one","two","three","four","five"};
		dls.pushAll(s);
		dls.unshift("zero");
		dls.deleteAt(3);
		dls.printList();
	}
}
