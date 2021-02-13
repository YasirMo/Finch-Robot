import javax.swing.JFrame;
import javax.swing.JOptionPane;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class SquareFinchDraw extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static int numbersq ;
	public static int counter = 0;
	private static int timer;
	
	public SquareFinchDraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String errorMessage = "";
		do {
			String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter number between 15cm and 85cm please.");
			try {
				counter++;
				int number = (Integer.parseInt(stringInput));
				// converting string to number
				if (number > 85 || number < 15) {
					// Setting the limit of the number
					errorMessage = "That number is not within the given \n" + "range please try again!\n";
					// Displaying the number they entered was not within the given range
				} else {
					JOptionPane
					// If the number they inputed is correct this massage will appear 
					.showMessageDialog(null, "The number you have chosen is " + number + ".");
					errorMessage = ""; 
					// This code will run when the user inputs the correct number
					Finch myFinch = new Finch();
					// Setting a new Finch
					double dur = 96.15384615384615;
					// This is for every milliseconds
					if (myFinch.isFinchLevel()){
						myFinch.setWheelVelocities(100, 100,(int) (dur*number));
					// adding the user inputed number to the finch
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000,95,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100,100,(int) (dur*number));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000,95,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number));
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(000,95,1500);
					myFinch.sleep(1000);
					myFinch.setWheelVelocities(100, 100,(int) (dur*number));
					myFinch.stopWheels();	 
					myFinch.buzz(400, 1000);
					myFinch.setLED(255, 0, 0, 1000);
					myFinch.quit();
					}
					// The Finch beeps for 1 second with frequency of 400 and flashes red for 1 second
					numbersq = number;
					timer = (int) (dur*number*4 / 1000);
				}
			}
			catch (NumberFormatException e) {
				errorMessage = "Please type a number only!.\n";
				// This will inform the user if they inputed something thats not a number such as a letter
			}
		} while (!errorMessage.isEmpty());

		// Returns true only if the length is 0
	}
	public static int getNumber() {
		return numbersq;
	} 
	public static int GetTimer() {
		return timer;
	}
}





