package ex5;
public class DoubleLinkedList{
	public DoubleLinkedList nextObject = null;
	public DoubleLinkedList lastObject = null;
	public static DoubleLinkedList firstObject = null;
	public int id;
	
	public DoubleLinkedList(int id){
		nextObject = null;
		this.id = id;
		 
	}
	public DoubleLinkedList(){
		nextObject = null;
		this.id = -1;
	}
	public void addObject(DoubleLinkedList next){
		if (DoubleLinkedList.firstObject == null){ //if first item
			DoubleLinkedList.firstObject = next;
		}else if (DoubleLinkedList.firstObject.nextObject == null) { // if second item
			DoubleLinkedList.firstObject.nextObject = next;
			DoubleLinkedList.firstObject.lastObject = next;
			next.lastObject = DoubleLinkedList.firstObject;
			next.nextObject = DoubleLinkedList.firstObject;
		} else if(this.nextObject != DoubleLinkedList.firstObject){ // if middle item
			nextObject.addObject(next);
		} else if (this.nextObject == DoubleLinkedList.firstObject){ // if last
			this.nextObject = next;
			next.nextObject = DoubleLinkedList.firstObject;
			next.lastObject = this;
			DoubleLinkedList.firstObject.lastObject = next;
		}
	}
	
	public void deleteObject(DoubleLinkedList toDelete){
		if (nextObject == toDelete){
			if (nextObject == DoubleLinkedList.firstObject){
				DoubleLinkedList.firstObject = this.nextObject.nextObject;
			}
			System.out.println("Deleting object no " + nextObject.id);
			nextObject = nextObject.nextObject;	
			nextObject.lastObject = this;
		
		} else if (nextObject == DoubleLinkedList.firstObject){
			System.out.println("Element not found");
		} else {
			nextObject.deleteObject(toDelete);
		}
	}
	
	public void listObjectsFromHead(){
		if (nextObject == DoubleLinkedList.firstObject){
			System.out.println(String.valueOf(id));
		} else {
			System.out.print(String.valueOf(id) + ", ");
			nextObject.listObjectsFromHead();
		}
	}
	
	public void listObjectsFromTail(){
		if (lastObject == DoubleLinkedList.firstObject){
			System.out.println(String.valueOf(lastObject.id));
		} else {
			System.out.print(String.valueOf(lastObject.id) + ", ");
			lastObject.listObjectsFromTail();
		}
	}
	
	public int getSizeRecursively(int count) {
		return (nextObject == null) ? count + 1 : nextObject.getSizeRecursively(count + 1);
	 
	}
	public int getSizeIteratively() {
		int count = 1;
		DoubleLinkedList objectCopy = null;
		if (nextObject != null){
			objectCopy = nextObject;			
		}
		while (objectCopy != null){
			objectCopy = objectCopy.nextObject;
			count++;
		}
		return count;
	}
}