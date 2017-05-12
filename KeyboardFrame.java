import java.awt.BorderLayout;

import javax.swing.JFrame;

public class KeyboardFrame extends JFrame {

	public KeyboardFrame() {
		super("Keyboard Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 500);
		setResizable(false);
		
		setLayout(new BorderLayout());
		TextPanel t = new TextPanel();
		ButtonsPanel k = new ButtonsPanel(t);
		add(t, BorderLayout.CENTER);
		add(k, BorderLayout.SOUTH);
	}

}
