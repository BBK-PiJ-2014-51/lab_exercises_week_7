package ex5;
public class ex5{
	public static void main(String[] args) {
		DoubleLinkedList dynamicList = new DoubleLinkedList(0);
		dynamicList.addObject(dynamicList);
		for (int i = 1; i < 20; i++){
			DoubleLinkedList object = new DoubleLinkedList(i);
			//System.out.println("adding: " + i);
			dynamicList.addObject(object);
		}
		DoubleLinkedList toDelete = new DoubleLinkedList(99);
		dynamicList.addObject(toDelete);
		DoubleLinkedList toDelete2 = new DoubleLinkedList(99);
		dynamicList.addObject(toDelete2);
		DoubleLinkedList toDelete3 = new DoubleLinkedList(99);
		dynamicList.addObject(toDelete3);
		dynamicList.listObjectsFromHead();
		dynamicList.listObjectsFromTail();
		dynamicList.deleteObject(toDelete);
		dynamicList.deleteObject(toDelete2);
		dynamicList.deleteObject(toDelete3);
		dynamicList.listObjectsFromHead();
		dynamicList.listObjectsFromTail();
		dynamicList.addObject(new DoubleLinkedList(100));
		dynamicList.addObject(new DoubleLinkedList(101));
		DoubleLinkedList toDelete4 = new DoubleLinkedList(99);
		dynamicList.deleteObject(toDelete);
		//to do: delete an element that isnt in the list
		
		
	}
}