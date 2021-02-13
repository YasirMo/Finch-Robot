import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	MainMenu(){
		super ("Draw Shape Main Menu");
		// Setting the name of the window
		setVisible(true);
		// Making the window visible 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// The program will exit when they click close
		setSize(400,360);
		// Setting the size of the window
		setResizable(false);
		// Setting the window to not be resizable

		JPanel panel = new JPanel();
		// Making a new Panel
		panel.setLayout(null);
		add(panel);

		JLabel DrawShape = new JLabel("Draw Shape");
		// new Label to display the program name 
		DrawShape.setBounds(150, -50, 600, 200);
		// Setting the bounds of the bounds of the label 
		panel.add(DrawShape);
		// This adds the label to the panel 

		JButton DrawShapebtn = new JButton ("Draw Shapes");
		// Making a new button called draw shapes
		DrawShapebtn.setBounds(133, 100, 130, 110);
		// Settings the bounds such as height and weight
		DrawShapebtn.addActionListener(new Draw());
		panel.add(DrawShapebtn);
		// Adding the button to the panel

		JButton Quitbtn = new JButton ("Quit");
		// Making a new button called quit
		Quitbtn.setBounds(270, 250, 80, 50);
		//Setting the bounds of the button 
		Quitbtn.addActionListener(new Quitbtn());
		panel.add(Quitbtn);
		// Adding the button to the panel

	}
	static class Draw implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new DrawShapes();
				}
			});
		}
	}
	static class Quitbtn implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new Quit();
				}
			});
		}
	}
}
