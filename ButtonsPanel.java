import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ButtonsPanel extends JPanel{

	private String _letters[][] = {{"`/~", "1/!", "2/@", "3/#", "4/$", "5/%", "6/^", "7/&", "8/*", "9/(", "0/)", "-/_", "=/+", "Backspace"},
								  {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[/{", "]/}", "\\/|"},
								  {"Caps" , "A", "S", "D", "F", "G", "H", "J", "K", "L", ";/:", "'/\"", "Enter"},
								  {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",/<", "./>", "//?", "Shift"}, {" "}};
	
	private ArrayList<ButtonsRowPanel> _keysRows;
	private boolean _shiftFlag = false;
	private boolean _capsFlag = false;
	private TextPanel _textP;
	private Color lavender = new Color(230,230,250);
	
	public ButtonsPanel(TextPanel textP) {
		
		setLayout(new GridLayout(5,1, 1, 1));
		
		_keysRows = new ArrayList<ButtonsRowPanel>();
		_textP = textP;
		textP.setBackground(lavender);
		
		for (String[] row: _letters){
			ButtonsRowPanel kPanel = new ButtonsRowPanel(row, this);
			_keysRows.add(kPanel);
			kPanel.setBackground(lavender);
			add(kPanel);
		}
		setBackground(lavender);
	}
	
	public void setShift(boolean b) {
		_shiftFlag = b;
	}
	
	public boolean isShift() {
		return _shiftFlag;
	}
	
	public void setCaps(boolean b) {
		_capsFlag = b;
	}
	
	public boolean isCaps() {
		return _capsFlag;
	}
	public String getText() {
		return _textP.getText();
	}
	
	public void setText(String text) {
		_textP.setText(text);
	}
	
	
}