import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/* Panel of one row of buttons */
public class KeysPanel extends JPanel{

	private static final Color DARK_PURPLE = new Color(110,110,255);
	private static final Color LIGHT_PURPLE= new Color(174,174,253);

	private Keyboard _keyboard;
	private JButton _cmdKey;
	private ArrayList<JButton> _shiftKeys = new ArrayList<JButton>();
	
    public KeysPanel(String letters[], Keyboard keyboard) {
    	_keyboard = keyboard;
    	KeyListener listener = new KeyListener();
    	
    	for (String let: letters) {
            _cmdKey = new JButton(let);
            _cmdKey.setBackground(LIGHT_PURPLE);
            if (let.equals("Shift")) {
            	_shiftKeys.add(_cmdKey);
            }
            if (let.equals(" ")) {
            	_cmdKey.setPreferredSize(new Dimension(450, 25));;
            }
            _cmdKey.addActionListener(listener);
    		add(_cmdKey);
    	}
    	
    }
    
    private class KeyListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			String old_text = _keyboard.getText();
			String new_text = "";
			
			if (s.equals("Backspace")) {
				if (old_text != null){
					int len = old_text.length();
					if (len > 0){
						StringBuilder sb = new StringBuilder(old_text);
						new_text = sb.deleteCharAt(len-1).toString();
						_keyboard.setText(new_text);
					}
				}
				return;
			}
			
			if (s.equals("Shift")) {
				if(_keyboard.isShift()){
					_keyboard.setShift(false);
					for (JButton k : _shiftKeys){
						k.setBackground(LIGHT_PURPLE);
					}
				}
				else {
					_keyboard.setShift(true);
					for (JButton k : _shiftKeys){
						k.setBackground(DARK_PURPLE);
					}
				}
				return;
			}
			
			if (s.equals("Caps")) {
				if(_keyboard.isCaps()){
					_keyboard.setCaps(false);
					_cmdKey = (JButton)e.getSource();
					_cmdKey.setBackground(LIGHT_PURPLE);
				}
				else {
					_keyboard.setCaps(true);
					_cmdKey = (JButton)e.getSource();
					_cmdKey.setBackground(DARK_PURPLE);
				}
				return;
			}
			
			if (s.equals("Tab")) {
				s = "\t";
			}
			
			if (s.equals("Enter")) {
				s = "\n";
			}
			
			if (s.length() > 1 && s.charAt(1) == '/'){
				
				if (_keyboard.isShift()){
					s = "" + s.charAt(2);
				}
				else{
					s = "" + s.charAt(0);
				}
			}
			
			if (Character.isLetter(s.charAt(0)) && !(_keyboard.isShift()) && !(_keyboard.isCaps())) {
					new_text = old_text + s.toLowerCase();
			}
			
			else{
				new_text = old_text + s;
			}
			
			_keyboard.setText(new_text);
		}
    }
}
