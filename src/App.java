import javax.swing.SwingUtilities;
public class App {
	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		new MainMenu();
		// This is the main which runs the main menu of the program first
	}
		});
	}
	}
