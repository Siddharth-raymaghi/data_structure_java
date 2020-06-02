package com.doublyLinkedList;

public class DoublyLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	public DoublyLinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	public Node<T> push(T data){
		Node<T> newNode = new Node<T>(data);
		if(this.head==null){
			this.head = newNode;
			this.tail = newNode;
		}else{
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		return this.head;
	}
	
	public Node<T> pushAll(T[] arr){
		for(T i : arr){
			push(i);
		}
		return this.head;
	}
	
	public Node<T> pop(){
		Node<T> deletedNode = null;
		if(this.head == null){
			return deletedNode;
		}
		deletedNode = this.tail;
		if(this.head.next == null){
			this.tail = null;
			this.head = null;
		}else{
			this.tail = this.tail.prev;
			this.tail.next = null;
			deletedNode.prev = null;
		}
		return deletedNode;
	}
	
	public Node<T> shift(){
		Node<T> deleteNode = null;
		if(head == null){
			return deleteNode;
		}
		deleteNode = this.head;
		if(head.next==null){
			this.head = null;
			this.tail = null;
		}else{
			this.head = this.head.next;
			this.head.prev = null;
			deleteNode.next = null;
		}
		return deleteNode;
	}
	
	
	public Node<T> unshift(T data){
		Node<T> newNode = new Node<>(data);
		if(this.head == null){
			this.head = newNode;
			this.tail = newNode;
		}else{
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		return this.head;
	}
	
	public Node<T> insertAt(int index,T data){
		int len = this.length();
		if(index<0 || index > len){
			return null;
		}
		if(index == 0){
			this.unshift(data);
		}else if(index == len){
			this.push(data);
		}else{
			Node<T> newNode = new Node<>(data);
			Node<T> prev = this.get(index-1);
			newNode.next = prev.next;
			newNode.next.prev = newNode;
			prev.next = newNode;
			newNode.prev = prev;
		}
		return this.head;
	}
	
	public Node<T> deleteAt(int index){
		int len = this.length();
		Node<T> deletedNode = null;
		if(index<0 || index > len-1){
			return deletedNode;
		}
		if(index == 0){
			deletedNode = this.shift();
		}else if(index == len-1){
			deletedNode = this.pop();
		}else{
			Node<T> prev = this.get(index-1);
			deletedNode = prev.next;
			prev.next = deletedNode.next;
			deletedNode.next.prev = prev;
			deletedNode.next = null;
			deletedNode.prev = null;
		}
		return deletedNode;
	}
	
	public boolean set(int index,T data){
		Node<T> foundNode = this.get(index);
		if(foundNode!=null){
			foundNode.data = data;
			return true;
		}
		return false;
	}
	
	public Node<T> get(int index){
		if(index<0||index>length()-1){
			return null;
		}
		Node<T> temp = this.head;
		while(index!=0){
			temp = temp.next;
			index--;
		}
		return temp;
	}
	
	public int length(){
		Node<T> temp = this.head;
		int len = 0;
		while(temp!=null){
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	public void printList(){
		Node<T> temp = this.head;
		while(temp!=null){
			System.out.print("<=>"+temp.data);
			temp = temp.next;
		}
	}
}
