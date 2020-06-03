package com.queue;

import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> lst ;
	
	public Queue(){
		lst = new LinkedList<>();
	}
	
	public void enqueue(T data){
		lst.addLast(data);
	}
	
	public T dequeue(){
		if(this.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		return lst.removeFirst();
	}
	
	public T peek(){
		if(this.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		return lst.peekFirst();
	}
	
	public boolean isEmpty(){
		return lst.size() == 0;
	}
	
	public int size(){
		return lst.size();
	}
}
