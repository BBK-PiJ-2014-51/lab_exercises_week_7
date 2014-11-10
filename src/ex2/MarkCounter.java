package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkCounter{
	private int numStudents = 0;
	private int numDist = 0;
	private int numPass = 0;
	private int numFail = 0;
	private int numInvalid = 0;
	
	public void loadMarks(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		int mark = -1;
		while (true){
			try {
				System.out.print("Input a mark: ");
				inputString = br.readLine();
				mark = Integer.parseInt(inputString);
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			if (mark == -1){				
				break;
			} else {
				scoreMark(mark);
			}
		}
		printResults();
	}
	
	public void printResults(){
		System.out.println("There are " + numStudents + " students: " + numDist + " distinctions, " + numPass + " passes, " + numFail + " fails (plus " + numInvalid + " invalids).");
	}
	
	private void scoreMark(int mark){
		if (mark < 0 || mark > 100){
			numInvalid++;
		} else if(mark < 50){
			numStudents++;
			numFail++;
		} else if (mark < 70){
			numStudents++;
			numPass++;
		} else{
			numStudents++;
			numDist++;
		}
		
	}
}