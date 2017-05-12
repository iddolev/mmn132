import java.awt.BorderLayout;

import javax.swing.JFrame;

public class KeyboardFrame extends JFrame {

	private TextPanel _textPanel;
	private ButtonsPanel _buttonsPanel;
	
	public KeyboardFrame() {
		super("Keyboard Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 500);
		setResizable(false);
		
		setLayout(new BorderLayout());
		_textPanel = new TextPanel();
		_buttonsPanel = new ButtonsPanel(this);
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
