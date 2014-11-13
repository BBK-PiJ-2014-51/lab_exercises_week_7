package ex7;
public class ex7{
	public static void main(String[] args) {
	Queue linkedList = new Queue();
	linkedList.listObjectsFromHead();
	System.out.println("Number of elements: " + linkedList.size());
	linkedList.insert(new Queue(5));	
	linkedList.insert(new Queue(8));
	linkedList.insert(new Queue(12));
	System.out.println("Number of elements: " + linkedList.size());
	System.out.println("retrieving: " + linkedList.retrieve().value);
	linkedList.insert(new Queue(13));
	System.out.println("Number of elements: " + linkedList.size());
	System.out.println("retrieving: " + linkedList.retrieve().value);
	System.out.println("retrieving: " + linkedList.retrieve().value);
	System.out.println("retrieving: " + linkedList.retrieve().value);
	System.out.println("retrieving: " + linkedList.retrieve().value);
	System.out.println("retrieving: " + linkedList.retrieve().value);
	
	linkedList.listObjectsFromHead();
	}
	
}