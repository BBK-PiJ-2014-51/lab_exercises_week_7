package ex1;
//Complete the example given in the notes with a class called Spy. Your class must have:
//• one and only one static variable, and int called spyCount.
//• an instance variable of type int for the spy’s ID.
//• a constructor method that receives the ID of the spy as an argument, increases spyCount(int) by one, and
//prints on the screen the ID of this spy plus the total number of spies so far.
//• a die() method that prints on the screen “Spy XX has been detected and eliminated” (where XX is the spy’s
//ID), decrements the spy counter and prints on the screen the total number of spies so far.
//• a main method in which several objects of class Spy are created and some of them killed (their method die()
//is called).
//Observe how the static variable is accessed by different objects both to increment and to decrement it.

public class ex1{
	public static void main(String[] args) {
		Spy spy1 = new Spy((int)Math.abs(1000 * Math.random()));
		Spy spy2 = new Spy((int)Math.abs(1000 * Math.random()));
		Spy spy3 = new Spy((int)Math.abs(1000 * Math.random()));
		Spy spy4 = new Spy((int)Math.abs(1000 * Math.random()));
		Spy spy5 = new Spy((int)Math.abs(1000 * Math.random()));
		
		spy1.die();
		spy3.die();
		spy5.die();
	}
}