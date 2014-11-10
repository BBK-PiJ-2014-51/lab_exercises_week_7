package ex3;
public class ex3{
	public static void main(String[] args) {
		MyObject head = new MyObject(0);
		for (int i = 1; i < 6; i++){
			head.addObject(new MyObject(i));
		}
		
		MyObject toDelete = new MyObject(10);
		head.addObject(toDelete);
		
		for (int i = 11; i < 16; i++){
			head.addObject(new MyObject(i));
		}
		
		head.listObjects();
		head.deleteObject(toDelete);
		head.listObjects();
		head = head.nextObject;//deletes first element
		System.out.println("Deleting first element");
		head.listObjects();
	}
}