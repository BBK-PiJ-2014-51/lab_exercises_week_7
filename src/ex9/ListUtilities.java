package ex9;

import ex6.CircularSingleLinkedList;

public class ListUtilities {
	int value;
	private static ListUtilities head = null;
	public ListUtilities nextObject;
	public static int count;
	
	public ListUtilities(){
		value = 0;
		nextObject = null;
		
	}
	
	public ListUtilities(int value){
		this.value = value;
		nextObject = null;
	}
	
	public void addObject(ListUtilities newObject) {
		if (ListUtilities.head == null){
			ListUtilities.head = newObject;
			this.nextObject = newObject;
			ListUtilities.count = 1;
		} else {
			if (nextObject == null) {
				nextObject = newObject;
				ListUtilities.count++;
			} else {
					nextObject.addObject(newObject);
			}
		}
	}
	
	public void listObjectsFromHead(){
		if (ListUtilities.head != null){
			ListUtilities.head.listNext();
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

	public static ListUtilities arrayToLinkedList(int[] intArray){
		ListUtilities newLinkedList = new ListUtilities();
		for (int i = 0; i < intArray.length; i++){
			newLinkedList.addObject(new ListUtilities(intArray[i]));
		}
		return ListUtilities.head;
	}
}
