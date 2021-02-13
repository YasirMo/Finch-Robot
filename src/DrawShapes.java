import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class DrawShapes extends JFrame {
	private static final long serialVersionUID = 1L;
	public DrawShapes(){
		super ("Draw Shapes");
		// Frame name
		setVisible(true);
		// Settings to be visible when the program runs
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// When the user presses exit the program closes
		setSize(400,360);
		// Settings the frame size
		setResizable(false);
		// not allowed to resize the frame

		JPanel panel = new JPanel();
		// JPanel is the the area in which controls and shows buttons and labels
		panel.setLayout(null);
		add(panel);
		// Adding the panel 

		JLabel drawshapes = new JLabel("Draw A Shape");
		// Making a label which is text and setting the name
		drawshapes.setBounds(160, -50, 600, 200);
		// Settings the size and coordinations of the button 
		panel.add(drawshapes);
		// Adding the button to the panel 

		JButton drawsqaure = new JButton ("Draw A Sqaure");
		drawsqaure.setBounds(30, 100, 122, 50);
		drawsqaure.addActionListener(new sqaurebtn());
		// This is an  ctionListener which listens and does a command when the button is pressed it listens to the sqaurebtn() bellow
		panel.add(drawsqaure);

		JButton drawtriangle = new JButton ("Draw A Triangle");
		drawtriangle.setBounds(200, 100, 130, 50);
		drawtriangle.addActionListener(new Trianglebtn());
		panel.add(drawtriangle);

		JButton drawpentagon = new JButton ("Draw A Pentagon");
		drawpentagon.setBounds(100, 180, 140, 50);
		drawpentagon.addActionListener(new Pentagonbtn());
		panel.add(drawpentagon);

		JButton menu = new JButton("Menu");
		menu.setBounds(45, 250, 80, 50);
		panel.add(menu);
		menu.addActionListener(new Menu());

		JButton Quitbtn = new JButton ("Quit");
		Quitbtn.setBounds(270, 250, 80, 50);
		Quitbtn.addActionListener(new Quitbtn());
		panel.add(Quitbtn);
	}
	static class sqaurebtn implements  ActionListener{
		// making a static class which implements the ActionListener
		public void actionPerformed  (ActionEvent e) {
			// This runs something when the button is clicked
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new Sqaure();
					// running and creating a new class called Sqaure
				}
			});
		}
	}
	static class Menu implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new MainMenu();
				}
			});
		}
	}
	static class Trianglebtn implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new Triangle();
				}
			});
		}
	}
	static class Pentagonbtn implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new Pentagon();
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
