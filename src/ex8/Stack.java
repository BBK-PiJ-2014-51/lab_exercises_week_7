package ex8;

import ex7.Queue;

public class Stack {
	public int value;
	private static Stack head = null;
	private static Stack tail = null;
	private Stack nextObject;
	private Stack lastObject;
	private	static int count;
	
	public Stack(){
		value = -1;
		nextObject = null;
		Stack.head = this;
	}
	
	public Stack(int value){
		this.value = value;
		nextObject = null;
	}
	
	public void push(Stack newObject){
		if (head.nextObject == null){
			head.nextObject = newObject;
			tail = head.nextObject;
		} else {
			newObject.nextObject = head.nextObject;
			head.nextObject = newObject;
			newObject.nextObject.lastObject = newObject;
		}
		count++;
	}
	
	public Stack pop(){
		if (head.nextObject == null){
			System.out.println("Nothing to retrieve");
			return null;
		} else{
			count--;
			Stack top = head.nextObject;
			if (head.nextObject.nextObject != null){
				head.nextObject = head.nextObject.nextObject;
				head.nextObject.lastObject = null;
			} else {
				head.nextObject = null;
				tail = null;
			}
			return top;
		}
		
	}
	
	public void listObjectsFromHead(){
		if (Stack.head.nextObject != null){
			Stack.head.nextObject.listNext();
		} else {
			System.out.println("No elemenets in list");
		}
	}
	
	public void listNext(){
		if (nextObject == null){
			System.out.println(String.valueOf(value));
		} else {
			System.out.print(String.valueOf(value) + ", ");
			nextObject.listNext();
		}
	}

	public boolean isEmpty() {
		return (head.nextObject == null) ? true : false; 
	}

}
