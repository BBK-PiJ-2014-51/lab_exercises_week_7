package ex7;

public class Queue {
	public int value;
	private static Queue head = null;
	private static Queue tail = null;
	public Queue nextObject;
	public Queue lastObject;
	public static int count;
	
	public Queue(){
		value = -1;
		nextObject = null;
		Queue.head = this;
	}
	
	public Queue(int value){
		this.value = value;
		nextObject = null;
	}
	
	public void insert(Queue newObject){
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
	
	public Queue retrieve(){
		if (tail == null){
			System.out.println("Nothing to retrieve");
		} else{
			count--;
			Queue lastValue = tail;
			if (tail.lastObject != null){
				tail = tail.lastObject;
				tail.nextObject = null;
			} else {
				head.nextObject = null;
				tail = null;
			}
			return lastValue;
		}
		count--;
		return new Queue();
	}
	
	public int size(){
		return count;
	}
	
	public Queue addObject(Queue newObject) {
		//if (ListUtilities.head != null)listObjectsFromHead(); 
		if (nextObject == null) {
			nextObject = newObject;
			Queue.count++;
			
		} else {
			if( nextObject.value >= newObject.value){
				newObject.nextObject = nextObject;
				nextObject = newObject;
				Queue.count++;
			} else {
					nextObject.addObject(newObject);
			}
		}	
		return head;
	}
	
	public void listObjectsFromHead(){
		if (Queue.head.nextObject != null){
			Queue.head.nextObject.listNext();
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

	public static Queue arrayToLinkedList(int[] intArray){
		Queue newLinkedList = new Queue();
		for (int i = 0; i < intArray.length; i++){
			newLinkedList.addObject(new Queue(intArray[i]));
		}
		return Queue.head;
	}
}
