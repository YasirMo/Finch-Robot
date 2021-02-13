import javax.swing.JFrame;
import javax.swing.JOptionPane;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class TriangleFinchDraw extends JFrame  {
	public static int numbertri;
	public static int number2;
	private static int number3;
	public static double hypo;
	public static double timertri;
	public static int counter = 0;
	public static double degree;
	public static double degree2;
	public static double CosC2;
	private static final long serialVersionUID = 1L;
	public TriangleFinchDraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String errorMessage = "";
		do {
			String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter the first length between 15cm and 85cm please.");
			String stringInput2 = JOptionPane.showInputDialog(errorMessage + "Enter the second length between 15cm and 85cm please.");
			String stringInput3 = JOptionPane.showInputDialog(errorMessage + "Enter the third length between 15cm and 85cm please.");
			try {
				counter++;
				numbertri = Integer.parseInt(stringInput);
				number2 = Integer.parseInt(stringInput2);
				number3 = Integer.parseInt(stringInput3);
				
				if (numbertri> 85 || numbertri < 15 ){
					errorMessage = "The entered number is not within the given \n" + "range please try again!\n";
				} 
				else if(number2 > 85 || number2 < 15 ){
					errorMessage = "The entered is not within the given \n" + "range please try again!\n";
				} 
				else if (number3 > 85 || number3 < 15 ){
					errorMessage = "The entered is not within the given \n" + "range please try again!\n";
				} 
				else {
					JOptionPane
					.showMessageDialog(null, "The number you have chosen is " + numbertri+ ":"  + number2+ "."+ number3);
					errorMessage = ""; // no more error
					Finch myFinch = new Finch();
					if (myFinch.isFinchLevel()){
						double dur = 96.15384615384615;
						// Finch moves this amount every 1 millisecond
						double CosA1 =((numbertri*numbertri)+(number2*number2)-(number3*number3));
						double CosA2= (2*numbertri*number2);
						// Formula to calculate angle of a triangle
						double cosA = (CosA1 /CosA2);
						cosA = Math.acos(cosA);
						// Getting the inverse of the cos
						 degree = Math.round((Math.toDegrees(cosA)));
						 // Rounding the number and changing from radian to degree
						int velocitytoturn90 = 95;
						double timetoturn1 = ((180 - degree)/90*1500);
						// The initial degree is for example 60,60,60  however that is assuming that the Finch is facing backwards 
						// So i needed to find the time to turn by getting degree x
						// We need to divide 90 by the degrees then times that by 1500 
						// I used velocity to turn 95 by multiplying it by 1500 to make the finch turn with the square
						// Formula to turn a specific degree is degree/90 times 1500
						double CosB1=((number2*number2)+(number3*number3)-(numbertri*numbertri));
						double CosB2=(2*number2*number3);
						double cosB = (CosB1/CosB2);
						cosB = Math.acos(cosB);
						 degree2 = Math.round(Math.toDegrees(cosB));
						double timetoturn2 = ((180 - degree2)/90 *1500);

						CosC2=(180 - (degree+degree2));
						double timetoturn3 = ((180 - CosC2)/90*1500);
						// To get the 3rd angle of the triangle i done 180 minus the 2 degrees

						myFinch.setWheelVelocities(100, 100,(int) (dur*numbertri));
					// First length inputed 
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000,velocitytoturn90,(int) (timetoturn1));
					// velocitytoturn90 is 95 and the timetoturn1 is caluclated 
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100,100,(int) (dur*number2));
					// Second length inputed
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000,velocitytoturn90,(int)(timetoturn2));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100,100,(int) (dur*number3));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000, velocitytoturn90,(int) (timetoturn3));
					// third length inputed
					myFinch.buzz(400, 1000);
					myFinch.setLED(255, 0, 0, 1000);
					myFinch.stopWheels();
					myFinch.quit();
				}
				}
			}
			 catch (NumberFormatException e) {
				errorMessage = "Please type a number only!.\n";
				// This will inform the user if they inputed something thats not a number such as a letter
			}
		} while (!errorMessage.isEmpty());
		// Returns true only if the length is 0
	}
	public static int Getnumber() {
		return TriangleFinchDraw.numbertri;
		// Creating static int's to call them in the file log
	}
	public static int Getnumber2() {
		return TriangleFinchDraw.number2;
	}
	public static double Getnumber3() {
		return TriangleFinchDraw.number3;
	}
	public static double Timertriangle() {
		return timertri;
	}
	public static double GetDegree1() {
		return degree;
	}
	public static double GetDegree2() {
		return degree2;
	}
	public static double GetDgree3() {
		return CosC2 ;
	}
}






