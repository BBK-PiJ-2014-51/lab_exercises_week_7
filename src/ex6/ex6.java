package ex6;
public class ex6{
	public static void main(String[] args) {
		CircularSingleLinkedList dynamicList = new CircularSingleLinkedList(0);
		dynamicList.addObject(dynamicList);
		for (int i = 1; i < 20; i++){
			CircularSingleLinkedList object = new CircularSingleLinkedList(i);
			//System.out.println("adding: " + i);
			dynamicList.addObject(object);
		}
		CircularSingleLinkedList toDelete = new CircularSingleLinkedList(99);
		dynamicList.addObject(toDelete);
		CircularSingleLinkedList toDelete2 = new CircularSingleLinkedList(99);
		dynamicList.addObject(toDelete2);
		CircularSingleLinkedList toDelete3 = new CircularSingleLinkedList(99);
		dynamicList.addObject(toDelete3);
		dynamicList.listObjectsFromHead();
		dynamicList.deleteObject(toDelete);
		dynamicList.deleteObject(toDelete2);
		dynamicList.deleteObject(toDelete3);
		dynamicList.listObjectsFromHead();
		dynamicList.addObject(new CircularSingleLinkedList(100));
		dynamicList.addObject(new CircularSingleLinkedList(101));
		CircularSingleLinkedList toDelete4 = new CircularSingleLinkedList(99);
		dynamicList.deleteObject(toDelete);
		//to do: delete an element that isnt in the list
		
		
	}
}