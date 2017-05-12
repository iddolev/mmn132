import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/* Panel of one row of buttons */
public class ButtonsRowPanel extends JPanel{

	private static final Color DARK_PURPLE = new Color(110,110,255); // the color of a pressed button
	private static final Color LIGHT_PURPLE= new Color(174,174,253); // the color of a button
	private static final int SPACE_BUTTON_W = 450;
	private static final int SPACE_BUTTON_H = 25;

	
	private KeyboardPanel _parent;
	/* We save the shift buttons so we can change both their color at once when pressed */
	private ArrayList<JButton> _shiftKeys = new ArrayList<JButton>(); 
	
    public ButtonsRowPanel(String letters[], KeyboardPanel parent) {
    	_parent = parent;
    	KeyListener listener = new KeyListener();
    	
    	/* Creating the keys buttons */
    	for (String let: letters) {
    		JButton btn = new JButton(let);
            btn.setBackground(LIGHT_PURPLE);
            if (let.equals("Shift")) {
            	_shiftKeys.add(btn); // We add the shift buttons to the shiftKeys list
            }
            if (let.equals(" ")) { // so we can have a larger space button
            	btn.setPreferredSize(new Dimension(SPACE_BUTTON_W, SPACE_BUTTON_H));
            }
            btn.addActionListener(listener);
    		add(btn);
    	}
    	
    }
    
    private class KeyListener implements ActionListener {

		String keyString, oldText, newText;
		JButton sourceBtn;

		@Override
		public void actionPerformed(ActionEvent e) {
			sourceBtn = (JButton)e.getSource();
			keyString = e.getActionCommand();
			oldText = _parent.getText();
			newText = "";

			// Check if it is the backspace button and handle it
			if (handleBackspace(keyString))
				return;
			// Check if it is the shift button and handle it
			if (handleShift(keyString))
				return;
			// Check if it is the caps-lock button and handle it
			if (handleCaps(keyString))
				return;
			
			if (keyString.equals("Tab")) {
				keyString = "\t";
			}
			
			if (keyString.equals("Enter")) {
				keyString = "\n";
			}
			
			// If the button is a special button like - "2/@"
			if (keyString.length() > 1 && keyString.charAt(1) == '/'){
				// If the Shift key is pressed, print the 2nd char, else - print the 1st char
				if (_parent.isShift()){
					keyString = "" + keyString.charAt(2);
				} else {
					keyString = "" + keyString.charAt(0);
				}
			}
			/* If the button is a letter and the Caps or Shift button isn't pressed
			 * print it as a lower-case letter, else - print it as an upper-case letter */
			if (Character.isLetter(keyString.charAt(0)) && !(_parent.isShift()) && !(_parent.isCaps())) {
				newText = oldText + keyString.toLowerCase();
			} else {
				newText = oldText + keyString;
			}
			
			// Now add the new text (that was pressed) to the textArea
			_parent.setText(newText);
		}
		
		private boolean handleBackspace(String s) {
			if (s.equals("Backspace")) {
				if (oldText != null){
					int len = oldText.length();
					// If there's something to delete, delete the last letter in the text with each backspace press
					if (len > 0){
						StringBuilder sb = new StringBuilder(oldText);
						newText = sb.deleteCharAt(len-1).toString();
						_parent.setText(newText);
					}
				}
				return true;
			}
			return false; // It wasn't a backspace button so try on the next "ifs"
		}
		
		private boolean handleShift(String s) {
			if (s.equals("Shift")) {
				if(_parent.isShift()) { // If the Shift button was already pressed
					_parent.setShift(false); // Turn off the Shift button
					for (JButton k : _shiftKeys){
						k.setBackground(LIGHT_PURPLE); // And change back both Shift keys color
					}
				} else { // If the Shift button wasn't already pressed
					_parent.setShift(true); // Turn on the Shift button
					for (JButton k : _shiftKeys){
						k.setBackground(DARK_PURPLE); // And change both Shift keys color
					}
				}
				return true;
			}
			return false; // It wasn't a shift button so try on the next "ifs"
		}
		
		private boolean handleCaps(String s) {
			if (s.equals("Caps")) {
				if(_parent.isCaps()){ // If the Caps button was already pressed
					_parent.setCaps(false); // Turn off the Caps button
					sourceBtn.setBackground(LIGHT_PURPLE); // And change back it's color
				}
				else { // If the Caps button wasn't already pressed
					_parent.setCaps(true); // Turn on the Caps button
					sourceBtn.setBackground(DARK_PURPLE); // And change it's color
				}
				return true;
			}
			return false; // It wasn't a caps-lock button so try on the next "ifs"
		}
    }
}
