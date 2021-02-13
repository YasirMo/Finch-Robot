import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Triangle extends JFrame {
	private static final long serialVersionUID = 1L;

	public Triangle() {
		super("Triangle");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,360);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		JLabel square = new JLabel("Draw A Triangle");
		square.setBounds(160, -50, 600, 200);
		panel.add(square);

		JLabel Userinputmsg = new JLabel("To start please press draw:");
		Userinputmsg.setBounds(50,0, 600, 200);
		panel.add(Userinputmsg);

		JButton submit = new JButton("Draw");
		submit.setBounds(120, 120, 170, 50);
		panel.add(submit);
		submit.addActionListener(new TriangleDraw());

		JButton menu = new JButton("Menu");
		menu.setBounds(60, 250, 80, 50);
		panel.add(menu);
		menu.addActionListener(new Menu());

		JButton DrawShapebtn = new JButton ("Draw Shapes");
		DrawShapebtn.setBounds(250, 250, 125, 50);
		DrawShapebtn.addActionListener(new Draw());
		panel.add(DrawShapebtn);

		JButton Quit = new JButton ("Quit");
		Quit.setBounds(160, 180, 100, 50);
		panel.add(Quit);
		Quit.addActionListener(new Quit());
	}
	static class TriangleDraw implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new TriangleFinchDraw();					
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
	static class Quit implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new FileLog();
				}
			});
		}
	}

}



