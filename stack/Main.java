package com.stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<>();
		s.push("one");
		s.push("two");
		s.push("three");
		s.push("four");
		s.push("five");
		s.push("six");
		s.pop();
		System.out.println(s.isEmpty());
		System.out.println(s.peek());
		System.out.println(s.size());
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}

}
