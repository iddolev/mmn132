import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private TextPanel _textPanel;
	private KeyboardPanel _buttonsPanel;
	
	public MainFrame() {
		super("Keyboard Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 500);
		setResizable(false);
		
		setLayout(new BorderLayout());
		_textPanel = new TextPanel();
		_buttonsPanel = new KeyboardPanel(this);
		add(_textPanel, BorderLayout.CENTER);
		add(_buttonsPanel, BorderLayout.SOUTH);
	}

	public String getText() {
		return _textPanel.getText();
	}

	public void setText(String text) {
		_textPanel.setText(text);
	}

}
