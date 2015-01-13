package ex13;

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
			ListUtilities.head.nextObject.lastObject = head;
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

	public static ListUtilities cocktailSort(ListUtilities list) {
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
			if (isSorted){
				list = head;
				break;
			}
			while (list.lastObject != null){
				if (list.id < list.lastObject.id){
					int tempVal = list.lastObject.id;
					list.lastObject.id = list.id;
					list.id = tempVal;
					isSorted = false;
				}
				list = list.lastObject;
			}
		}
		
		list.lastExecTime = System.currentTimeMillis() - startTime;
		return list;
	}

	public static ListUtilities quickSort(ListUtilities arrayToLinkedList) {		
		return quickSortRecursive(arrayToLinkedList);
	}
	
	private static ListUtilities quickSortRecursive(ListUtilities list){
		double startTime = System.currentTimeMillis();
		ListUtilities pivot = head.nextObject;
		ListUtilities currentNode = pivot;
		while (currentNode != null){
			if (currentNode.id < pivot.id){
				 ListUtilities newNode= new ListUtilities(currentNode.id);
				 newNode.lastObject = pivot.lastObject;
				 newNode.nextObject = pivot;
				 if (pivot.nextObject != null) pivot.lastObject.nextObject = newNode;
				 pivot.lastObject = newNode;
				 if (currentNode.lastObject != null) currentNode.lastObject.nextObject = currentNode.nextObject;
				 if (currentNode.nextObject != null) currentNode.nextObject.lastObject = currentNode.lastObject;
			}
			currentNode = currentNode.nextObject;
		}
	
		quickSortDownwards(pivot);
		quickSortUpwards(pivot);
		list.lastExecTime = System.currentTimeMillis() - startTime;
		return head;
	}
	
	private static void quickSortDownwards(ListUtilities list){
		if (list.lastObject == null) return;
		ListUtilities pivot = list.lastObject;
		ListUtilities currentNode = pivot;
		while (currentNode != null){
			if (currentNode.id > pivot.id){
				ListUtilities newNode = new ListUtilities(currentNode.id);
				newNode.lastObject = pivot;
				newNode.nextObject = pivot.nextObject;
				if (pivot.nextObject != null)pivot.nextObject.lastObject = newNode;
				pivot.nextObject = newNode;
				if (currentNode.lastObject != null) currentNode.lastObject.nextObject = currentNode.nextObject;
				if (currentNode.nextObject != null) currentNode.nextObject.lastObject = currentNode.lastObject;
			}
			currentNode = currentNode.lastObject;
		}
		if (list.lastObject != null) quickSortDownwards(list.lastObject);
	}
	
	private static void quickSortUpwards(ListUtilities list){
		if (list.nextObject == null) return;
		ListUtilities pivot = list.nextObject;
		ListUtilities currentNode = pivot;
		while (currentNode != null){
			if (currentNode.id < pivot.id){
				 ListUtilities newNode= new ListUtilities(currentNode.id);
				 newNode.lastObject = pivot.lastObject;
				 newNode.nextObject = pivot;
				 if (pivot.nextObject != null) pivot.lastObject.nextObject = newNode;
				 pivot.lastObject = newNode;
				 if (currentNode.lastObject != null) currentNode.lastObject.nextObject = currentNode.nextObject;
				 if (currentNode.nextObject != null) currentNode.nextObject.lastObject = currentNode.lastObject;
			}
			currentNode = currentNode.nextObject;
		}
		if (list.nextObject != null) quickSortUpwards(list.nextObject);
	}
	
}