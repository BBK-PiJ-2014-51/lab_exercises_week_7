package ex1;
public class Spy{
	static int spyCount = 0;
	private int id;
	
	public Spy(int id){
		this.id = id;
		System.out.println("Added new spy with id " + id + ". There are now " + ++Spy.spyCount + " total spies");
	}
	
	public void die(){
		System.out.println("Spy " + this.id + " has been killed. There are now " + --Spy.spyCount + " spies left.");
	}
}