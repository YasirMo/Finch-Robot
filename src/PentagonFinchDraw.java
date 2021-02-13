import javax.swing.JFrame;
import javax.swing.JOptionPane;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class PentagonFinchDraw extends JFrame  {
	public static int numberpen;
	public static int numberpen2;
	public static double timerpen;
	public static int counter = 0;
	private static final long serialVersionUID = 1L;

	public PentagonFinchDraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String errorMessage = "";
		// Making a string for if there is an error message 
		do {
			String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter number between 15cm and 85cm please.");
			String stringInput2 = JOptionPane.showInputDialog(errorMessage + "Enter number between 15cm and 85cm please.");
			// creating a string that is a input dialog which allows the user to input numbers

			try {
				counter++;
				int  number = (Integer.parseInt(stringInput));
				int  number2 = (Integer.parseInt(stringInput2));
				// converting string to number
				if (number > 85 || number < 15) {
					// Setting the limit of the number entered
					errorMessage = "That number is not within the given \n" + "range please try again!\n";
					// If the number is out of bounds this message will be displayed
				}
				if (number2 > 30 || number2 < 10 ){
					errorMessage = "The entered is not within the given \n" + "range please try again!\n";
					// Settings limits for the second number
				} 
				else {
					// else if the input is correct the program will run and inform the user of the numbers they have chosen
					JOptionPane
					.showMessageDialog(null, "The number you have chosen is " + number + "." + number2);
					// Message to inform the numbers chosen
					errorMessage = ""; 
					Finch myFinch = new Finch();
					// making a new finch called myfinch
					double dur = 96.15384615384615;
					// Making a variable this number is the time the finch moves ever 1 milliseconds
					// I used this to times it by the number given by the user eg 15 cm
					if (myFinch.isFinchLevel()){
					myFinch.setWheelVelocities(100, 100,(int) (dur*number));
					// making the finch move speed 100 both wheels and the time is the dur dobule times by user input length
					myFinch.sleep(1000);
					// Making the finch sleep for 1 second
					myFinch.setWheelVelocities(000,95,1500);
					// Turning the finch 
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000, 60,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number2));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000, 90,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number2));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000, 80,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number2));
					myFinch.sleep(1000);
					myFinch.buzz(400, 1000);
					myFinch.setLED(255, 0, 0, 1000);
					myFinch.quit();
					}
					// stopping the finch move
					numberpen = number;
					numberpen2 = number2;
					// creating new variables which are static to be used in the text file class
					timerpen =  (dur*number*2)+ (dur*number2*3) + (6000);
					timerpen = timerpen /1000;
					timerpen = Math. round(timerpen* 10) / 10.0;
					// adding the numbers and dividing by 1000 to make it display in seconds
				}
			} catch (NumberFormatException e) {
				errorMessage = "Please type a number only!.\n";
				// This will inform the user if they inputed something thats not a number such as a letter
			}
		} while (!errorMessage.isEmpty());
		// Returns true only if the length is 0
	}
	public static int Getnumberpen() {
		return numberpen;
		// creating static int to be used in the file log class
	}
	public static int Gernumberpen2() {
		return numberpen2;
	}
	public static double Timerpen() {

		return timerpen;
	}
}



