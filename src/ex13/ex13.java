package ex13;
public class ex13{
	int[] testArray;
	public static void main(String[] args) {
		ex13 exercise = new ex13();
		for (int i = 500; i < 50000; i *= 2){
			exercise.test(i);
		}
	}
	

	private void sortIt(int[] testArray) {
		//System.out.print(testArray.length + " ints, unsorted list: ");
		//ListUtilities linkedList = ListUtilities.arrayToLinkedList(testArray);
		//linkedList.listObjectsFromHead();
		System.out.print("bubble sorted list:");
		ListUtilities bubblesort = ListUtilities.bubbleSort(ListUtilities.arrayToLinkedList(testArray));
		System.out.println(testArray.length + " items sorted in " + bubblesort.getLastExecTime() + "ms.");
		
		System.out.print("cocktail sorted list:");
		ListUtilities cocktailsort = ListUtilities.cocktailSort(ListUtilities.arrayToLinkedList(testArray));
		System.out.println(testArray.length + " items sorted in " + cocktailsort.getLastExecTime() + "ms.");
		
		
		System.out.print("quick sorted list:");
		ListUtilities quicksort = ListUtilities.quickSort(ListUtilities.arrayToLinkedList(testArray));
		System.out.println(testArray.length + " items sorted in " + quicksort.getLastExecTime() + "ms.");
	}
	
	private void test(int length){
		testArray = new int[length];
		for (int i = 0; i < testArray.length; i++){
			testArray[i] = (int) (Math.random() * 100);
		}
		this.sortIt(testArray);
	}
	
}