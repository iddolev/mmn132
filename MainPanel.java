import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		setLayout(new GridLayout(2,1));
		TextPanel t = new TextPanel();
		Keyboard k = new Keyboard(t);
		add(t);
		add(k);
		setBackground(Color.BLACK);
	}

}
