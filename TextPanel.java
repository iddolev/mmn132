import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class TextPanel extends JPanel {

	private final JTextArea _textArea;
	private Font f = new Font(Font.SANS_SERIF, 0, 20);
	private JScrollPane scroll;
	
	public TextPanel(int height, int witdh) {
		_textArea = new JTextArea(height, witdh);
		_textArea.setEditable(false);
		_textArea.setFont(f);
		_textArea.setLineWrap(true);
		_textArea.setLayout(new FlowLayout());
		scroll = new JScrollPane(_textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// TODO add scroll-bar
		add(scroll, BorderLayout.CENTER);
	}
	
	public void setText(String text) {
		_textArea.setText(text);
	}

	public String getText() {
		return _textArea.getText();
	}

}
