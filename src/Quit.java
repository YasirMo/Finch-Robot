import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Quit extends JFrame {
	private static final long serialVersionUID = 1L;

	public Quit() {
		super("Quit");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,360);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		JButton Filelogbtn = new JButton ("File Log");
		Filelogbtn.setBounds(150, 90, 100, 50);
		Filelogbtn.addActionListener(new File());
		panel.add(Filelogbtn);
		JButton menu = new JButton("Menu");
		menu.setBounds(45, 250, 80, 50);
		panel.add(menu);
		menu.addActionListener(new Menu());
		JOptionPane.showMessageDialog(panel, "Please Press the exit if you wish to quit the program otherwise press the File Log!");
	}
	static class File implements  ActionListener{
		public void actionPerformed  (ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new FileLog();
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
}







