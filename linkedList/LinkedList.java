package com.linkedList;

public class LinkedList<T> {
	Node<T> head ;
	Node<T> tail;
	public LinkedList(){
		this.head = null;
		this.tail =  null;
	}
	
	public Node<T> push(T data){
		Node<T> newNode = new Node<>(data);
		if(this.head==null){
			this.head = newNode;
			this.tail = newNode;
		}else{
			this.tail.next = newNode;
			this.tail = newNode;
		}
		return this.head;
	}
	
	public Node<T> pushAll(T[] data){
		for(T i:data){
			push(i);
		}
		return this.head;
	}
	
	public Node<T> pop(){
		Node<T> deleteNode;
		if(head==null){
			throw new NullPointerException();
		}
		deleteNode = this.tail;
		if(head.next==null){
			this.head =null;
			this.tail = null;
			return deleteNode;
		}else{
			Node<T> temp = this.head;
			while(temp.next.next!=null){
				temp = temp.next;
			}
			temp.next = null;
			this.tail = temp;
		}
		return deleteNode;
	}
	
	public Node<T> shift(){
		Node<T> deleteNode;
		if(head == null){
			throw new NullPointerException();
		}
		deleteNode = this.head;
		if(head.next==null){
			this.head = null;
			this.tail = null;
		}else{
			this.head = this.head.next;
			deleteNode.next = null;
		}
		return deleteNode;
	}
	
	public Node<T> unshift(T data){
		Node<T> newNode = new Node<>(data);

		if(this.head == null){
			this.head = newNode;
			this.tail = this.head;
		}else{
			newNode.next = this.head;
			this.head = newNode;
		}
		return this.head;	
	}
	
	public Node<T> insertAt(int index,T value){
		int len = this.getLength();
		if(index<0 || index > len){
			return null;
		}
		if(index==0){
			this.unshift(value);
		}else if(index == len){
			this.push(value);
		}else{
			Node<T> newNode = new Node<T>(value);
			Node<T> prev = this.get(index-1);
			newNode.next = prev.next;
			prev.next = newNode;
		}
		return this.head;
	}
	
	public Node<T> removeAt(int index){
		int len = this.getLength();
		Node<T> deletedNode = null;
		if(index<0 || index > len-1){
			return deletedNode;
		}
		if(index ==0){
			deletedNode = this.shift();
		}else if(index == len-1){
			deletedNode = this.pop();
		}else{
			Node<T> prev = this.get(index-1);
			deletedNode = prev.next;
			prev.next = deletedNode.next;
			deletedNode.next = null;
		}
		return deletedNode;
	}
	
	public Node<T> reverseList(){
		if(head==null) return null;
		return recursiveRecursion(this.head);
	}
	
	private Node<T> recursiveRecursion(Node<T> curr){
		if(curr.next==null){
			this.head = curr;
			this.tail = curr;
			return this.head;
		}
		 Node<T> h = recursiveRecursion(curr.next);
		 this.tail.next = curr;
		 this.tail = curr;
		 this.tail.next = null;
		 return h;
		 
	}
	public Node<T> get(int index){
		if(index<0 || index>getLength()-1 || head==null){
			return null;
		}
		Node<T> foundNode = null;
		Node<T> temp = this.head;
		while(index!=0){
			index--;
			temp = temp.next;
		}
		foundNode = temp;
		return foundNode; 
	}
	
	public boolean set(int index, T value){
		Node<T> foundNode = this.get(index);
		if(foundNode==null){
			return false;
		}
		foundNode.data = value;
		return true;
	}
	
	public int getLength(){
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
		while(temp != null){
			System.out.print("=>"+temp.data);
			temp = temp.next;
		}
	}
	
}
