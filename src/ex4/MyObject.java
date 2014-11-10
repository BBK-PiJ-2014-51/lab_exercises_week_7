package ex4;
public class MyObject{
	public MyObject nextObject = null;
	public int id;
	
	public MyObject(int id){
		nextObject = null;
		this.id = id;
	}
	public MyObject(){
		nextObject = null;
		this.id = -1;
	}
	public void addObject(MyObject next){
		if (this.nextObject == null) {
			nextObject = next;
		} else {
			nextObject.addObject(next);
		}
	}
	
	public void deleteObject(MyObject toDelete){
		if (nextObject == toDelete){
			System.out.println("Deleting object no " + nextObject.id);
			nextObject = nextObject.nextObject;			
		} else {
			nextObject.deleteObject(toDelete);
		}
	}
	
	public void listObjects(){
		if (nextObject == null){
			System.out.println(String.valueOf(id));
		} else {
			System.out.print(String.valueOf(id) + ", ");
			nextObject.listObjects();
		}
	}
	public int getSizeRecursively(int count) {
		return (nextObject == null) ? count + 1 : nextObject.getSizeRecursively(count + 1);
	 
	}
	public int getSizeIteratively() {
		int count = 1;
		MyObject objectCopy = null;
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