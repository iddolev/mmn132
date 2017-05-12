import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class KeyboardPanel extends JPanel{

	private static final Color LAVENDER = new Color(230,230,250);
	
	private String _buttonLables[][] = {{"`/~", "1/!", "2/@", "3/#", "4/$", "5/%", "6/^", "7/&", "8/*", "9/(", "0/)", "-/_", "=/+", "Backspace"},
								  {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[/{", "]/}", "\\/|"},
								  {"Caps" , "A", "S", "D", "F", "G", "H", "J", "K", "L", ";/:", "'/\"", "Enter"},
								  {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",/<", "./>", "//?", "Shift"}, 
								  {" "}};
	
	private ArrayList<ButtonsRowPanel> _keysRows;
	private boolean _shiftFlag = false;
	private boolean _capsFlag = false;
	private MainFrame _parent;
	
	public KeyboardPanel(MainFrame parent) {
		
		setLayout(new GridLayout(5,1, 1, 1));
		
		_keysRows = new ArrayList<ButtonsRowPanel>();
		_parent = parent;

		// Go over the rows of button lables and construct the rows
		for (String[] row: _buttonLables){
			ButtonsRowPanel kPanel = new ButtonsRowPanel(row, this);
			_keysRows.add(kPanel);
			kPanel.setBackground(LAVENDER);
			add(kPanel);
		}
		setBackground(LAVENDER);
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
		return _parent.getText();
	}
	
	public void setText(String text) {
		_parent.setText(text);
	}
	
	
}