import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileLog   {

	public FileLog() {

		File fileName = new File("\\\\ikb\\home\\39\\1812139\\My Documents\\DrawShapes.txt");
		// Creating a file that can be found at the location 
		ArrayList<String> aList = new ArrayList<String>();
		// Making an ArrayList called aList
		String S = "Square " +": "+ SquareFinchDraw.getNumber()+" :";
		// Making a new string which displays the lengths of the square in the SquareFinchDraw class
		String T = "Traingle"+":"+ TriangleFinchDraw.Getnumber()+":"+TriangleFinchDraw.Getnumber2()+":"+TriangleFinchDraw.Getnumber3()+"(" + "Angles:" + TriangleFinchDraw.GetDegree1()+":"+ TriangleFinchDraw.GetDegree2()+ ":"+ TriangleFinchDraw.GetDgree3()+")";
		// This creates a string which displays the lengths of the triangle
		String P = "Pentagon"+":"+PentagonFinchDraw.numberpen+":"+PentagonFinchDraw.numberpen+":"+PentagonFinchDraw.numberpen+":"+PentagonFinchDraw.numberpen2+":"+PentagonFinchDraw.numberpen2;
		aList.add(0, S+T+P);
		// This adds the strings to the ArrayList
		int Squareenum = SquareFinchDraw.getNumber()+SquareFinchDraw.getNumber()+SquareFinchDraw.getNumber()+SquareFinchDraw.getNumber();
		double Trainglenum = TriangleFinchDraw.Getnumber()+TriangleFinchDraw.Getnumber2()+TriangleFinchDraw.Getnumber3();
		int Pennum = PentagonFinchDraw.numberpen+ PentagonFinchDraw.numberpen+ PentagonFinchDraw.numberpen+PentagonFinchDraw.numberpen2+PentagonFinchDraw.numberpen2;
		// Making new variables to check in an if statement the largest shape drawn

		if (Squareenum > Trainglenum  && Squareenum > Pennum) {
			aList.add("The Largest drawn shape was a Sqaure "+":"+Squareenum);
		} 
		else if (Trainglenum >Squareenum && Trainglenum > Pennum) {
			aList.add("The Largest drawn shape was a Traingle " +":"+Trainglenum);
		}
		else if (Pennum > Squareenum && Pennum >Trainglenum){
			aList.add("The Largest drawn shape was a Pentagon "+":"+Pennum);
		}
		// This is an IF else statement which checks the largest shape drawn and displays that on the text file
		int average= (int)((SquareFinchDraw.GetTimer()+TriangleFinchDraw.Timertriangle()+PentagonFinchDraw.timerpen)/3);
		// Calculating the mean time that it took to draw the shapes. We are adding the numbers and diving by the number of values in the list
		aList.add("The average time taken to draw the shapes was: "+ average+" seconds");
		// Adding the mean to the array in the text file
		
		int counter1 = SquareFinchDraw.counter ;
		int counter2 = TriangleFinchDraw.counter ;
		int counter3 =  PentagonFinchDraw.counter ;
		// creating variables to place into the if statement
		
		if (counter1 > counter2 || counter1 > counter3) {
			aList.add("The most frequently drawn shape was a Sqaure:"+counter1+" times");
		}
		else if (counter2 > counter1 || counter2 > counter3) {
			aList.add("The most frequently drawn shape was a Triangle:"+counter2+" times");
		}
		else if (counter3 > counter1 || counter3 > counter2) {
			aList.add("The most frequently drawn shape was a Pentagon:"+counter3+" times");
			// Making else if statement to capture the most frequently drawn shape	
		}
		try {
			FileWriter file = new FileWriter(fileName);
			// Creating a new FileWriter    
			Writer output  = new BufferedWriter(file);
			// Creates a buffer character output
			int d = aList.size();
			// returns the number of elements in the list
			for (int i = 0; i <d; i++) {
				// Incrementing by 1 each time i is less than the size of d which is the size of the array
				output.write(aList.get(i).toString()+ "\n");
				// Outputting the list 
			}
			output.close();
		}
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "I cant create this file sorry!");
			// this will appear if the file cannot be created
		}
		System.exit(0);
		// the program will terminate once the file log is created 
	}
}



