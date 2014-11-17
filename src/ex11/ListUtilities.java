package ex11;

public class ListUtilities{
	private ListUtilities nextObject = null;
	private ListUtilities lastObject = null;
	private static ListUtilities head;
	public static ListUtilities tail;
	public int id;
	private static int count;
	
	public ListUtilities(int id){
		this.id = id;
	}
	
	public ListUtilities(){
		head = this;
		nextObject = null;
		this.id = -1;
		count = 0;
	}
	

	
	public void addObject(ListUtilities next){
		if (ListUtilities.head.nextObject == null){ 
			ListUtilities.head.nextObject = next;
			count = 1;
		}else if (nextObject == null) { 
			this.nextObject = next;
			next.lastObject = this;
			tail = next;
			count++;
		} else { 
			nextObject.addObject(next);
		}
	}
	

	
	public void listObjectsFromHead(){
		if (nextObject != null){
			System.out.print(nextObject.id);
			if (nextObject.nextObject != null) System.out.print(", ");
			nextObject.listObjectsFromHead();
		} else {
			System.out.println();
		}
	}
	
	public void listObjectsFromTail(){
		if (lastObject != null){
			System.out.print(id);
			if (lastObject.lastObject != null) System.out.print(", ");
			lastObject.listObjectsFromTail();
		} else {
			System.out.println();
		}
	}

	
	public int getSizeRecursively(int count) {
		return (nextObject == null) ? count + 1 : nextObject.getSizeRecursively(count + 1);
	 
	}
	public int getSizeIteratively() {
		int count = 1;
		ListUtilities objectCopy = null;
		if (nextObject != null){
			objectCopy = nextObject;			
		}
		while (objectCopy != null){
			objectCopy = objectCopy.nextObject;
			count++;
		}
		return count;
	}
	
	public static ListUtilities arrayToLinkedList(int[] intArray){
		ListUtilities newLinkedList = new ListUtilities();
		for (int i = 0; i < intArray.length; i++){
			newLinkedList.addObject(new ListUtilities(intArray[i]));
		}
		return newLinkedList;
	}
	
	public static ListUtilities bubbleSort(ListUtilities list){
		for (int i = 0; i < count; i++){
			System.out.println("calling bubbile sort for element " + i);
			list = list.recursiveComparision(list);
			list.listObjectsFromHead();
		}
		return list;
	}
	
	private ListUtilities recursiveComparision(ListUtilities list){
		System.out.println("Recursive call on list");
		if (list.nextObject == null) {
			System.out.println("Returning head");
			return head;
		} else {
			System.out.println("Comparing " + list.id + " with " + list.nextObject.id);
			if (list.id > list.nextObject.id && list != head){
				if (lastObject == null){
					System.out.println("last object null, must be front of list");
					head.nextObject = list.nextObject;
					head.nextObject.lastObject = null;
					list.lastObject = head.nextObject;
					if (list.nextObject.nextObject != null)list.nextObject = list.nextObject.nextObject;
					else list.nextObject =  null;
				} else {
					list.lastObject.nextObject = list.nextObject;
					list.nextObject.lastObject = list.lastObject;
					list.lastObject = list.nextObject;
					list.nextObject = list.nextObject.nextObject;
					list.lastObject.nextObject = list;
				}
			}
			return (list.nextObject == null) ? head : recursiveComparision(list.nextObject);
		}
	}
	
}