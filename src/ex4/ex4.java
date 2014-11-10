package ex4;
public class ex4{
	public static void main(String[] args) {
		MyObject dynamicList = new MyObject(0);
		for (int i = 1; i < 50; i++){
			MyObject object = new MyObject(i);
			dynamicList.addObject(object);
		}
		
		int length = dynamicList.getSizeRecursively(0);
		System.out.println("Recursive size method returns: " + length);
		length = dynamicList.getSizeIteratively();
		System.out.println("Iterative size method returns: " + length);
	}
}