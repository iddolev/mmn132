import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class KeyboardFrame extends JFrame {

	public KeyboardFrame() {
		super("Keyboard Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setResizable(false);
		
		setLayout(new GridLayout(2,1));
		TextPanel t = new TextPanel();
		Keyboard k = new Keyboard(t);
		add(t);
		add(k);
		setBackground(Color.BLACK);   // ????
	}

}
