package ex11;

public class ListUtilities{
	private ListUtilities nextObject = null;
	private ListUtilities lastObject = null;
	private static ListUtilities head;
	public static ListUtilities tail;
	public int id;
	private double lastExecTime;
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
	
	public double getLastExecTime(){
		return lastExecTime;
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
		double startTime = System.currentTimeMillis();
		boolean isSorted = false;
		while(!isSorted){
			isSorted = true;
			while (list.nextObject != null){
				if (list.id > list.nextObject.id){
					int tempVal = list.nextObject.id;
					list.nextObject.id = list.id;
					list.id = tempVal;
					isSorted = false;
				}
				list = list.nextObject;
			}
			list = head;
		}
		
		list.lastExecTime = System.currentTimeMillis() - startTime;
		return list;
	}
	
	
	
}