package ex10;
public class ex10{
	public static void main(String[] args) {
	int[] testArray = new int[15];
	for (int i = 0; i < testArray.length; i++){
		testArray[i] = (i + 1) * 3;
	}
	
	
	System.out.print("pre sorted list:");
	
	ListUtilities linkedList = new ListUtilities();
	linkedList = linkedList.addObject(new ListUtilities(99));
	for (int i = 2; i < testArray.length; i++){
		linkedList = linkedList.addObject(new ListUtilities(i * 3));
	}
	linkedList.listObjectsFromHead();
	linkedList.addObject(new ListUtilities(19));
	linkedList.addObject(new ListUtilities(1));
	linkedList.addObject(new ListUtilities(190));
	linkedList.addObject(new ListUtilities(18));
	System.out.println("list after adding 19, 1, 190, 18:");
	linkedList.listObjectsFromHead();
	}
	
}