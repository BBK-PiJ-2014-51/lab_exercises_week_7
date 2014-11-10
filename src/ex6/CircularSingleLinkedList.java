package ex6;
public class CircularSingleLinkedList{
	public CircularSingleLinkedList nextObject = null;
	public static CircularSingleLinkedList firstObject = null;
	public int id;
	
	public CircularSingleLinkedList(int id){
		nextObject = null;
		this.id = id;
		 
	}
	public CircularSingleLinkedList(){
		nextObject = null;
		this.id = -1;
	}
	public void addObject(CircularSingleLinkedList next){
		if (CircularSingleLinkedList.firstObject == null){ //if first item
			CircularSingleLinkedList.firstObject = next;
		}else if (CircularSingleLinkedList.firstObject.nextObject == null) { // if second item
			CircularSingleLinkedList.firstObject.nextObject = next;
			
			
			next.nextObject = CircularSingleLinkedList.firstObject;
		} else if(this.nextObject != CircularSingleLinkedList.firstObject){ // if middle item
			nextObject.addObject(next);
		} else if (this.nextObject == CircularSingleLinkedList.firstObject){ // if last
			this.nextObject = next;
			next.nextObject = CircularSingleLinkedList.firstObject;
		}
	}
	
	public void deleteObject(CircularSingleLinkedList toDelete){
		if (nextObject == toDelete){
			if (nextObject == CircularSingleLinkedList.firstObject){
				CircularSingleLinkedList.firstObject = this.nextObject.nextObject;
			}
			System.out.println("Deleting object no " + nextObject.id);
			nextObject = nextObject.nextObject;	
		
		} else if (nextObject == CircularSingleLinkedList.firstObject){
			System.out.println("Element not found");
		} else {
			nextObject.deleteObject(toDelete);
		}
	}
	
	public void listObjectsFromHead(){
		if (nextObject == CircularSingleLinkedList.firstObject){
			System.out.println(String.valueOf(id));
		} else {
			System.out.print(String.valueOf(id) + ", ");
			nextObject.listObjectsFromHead();
		}
	}
	
	public int getSizeRecursively(int count) {
		return (nextObject == null) ? count + 1 : nextObject.getSizeRecursively(count + 1);
	 
	}
	public int getSizeIteratively() {
		int count = 1;
		CircularSingleLinkedList objectCopy = null;
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