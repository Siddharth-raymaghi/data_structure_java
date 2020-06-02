package com.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> list;
	public Stack(){
		list = new LinkedList<>();
	}
	
	public void push(T data){
		list.addLast(data);
	}
	
	public T pop(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		return list.removeLast();
	}
	
	public T peek(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		return list.peekLast();
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.size() == 0;
	}
}
