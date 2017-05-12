import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/* Panel of one row of buttons */
public class ButtonsRowPanel extends JPanel{

	private static final Color DARK_PURPLE = new Color(110,110,255);
	private static final Color LIGHT_PURPLE= new Color(174,174,253);

	private ButtonsPanel _parent;
	private ArrayList<JButton> _shiftKeys = new ArrayList<JButton>();
	
    public ButtonsRowPanel(String letters[], ButtonsPanel keyboard) {
    	_parent = keyboard;
    	KeyListener listener = new KeyListener();
    	
    	for (String let: letters) {
    		JButton btn = new JButton(let);
            btn.setBackground(LIGHT_PURPLE);
            if (let.equals("Shift")) {
            	_shiftKeys.add(btn);
            }
            if (let.equals(" ")) {
            	btn.setPreferredSize(new Dimension(450, 25));;
            }
            btn.addActionListener(listener);
    		add(btn);
    	}
    	
    }
    
    private class KeyListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			String old_text = _parent.getText();
			String new_text = "";
			
			if (s.equals("Backspace")) {
				if (old_text != null){
					int len = old_text.length();
					if (len > 0){
						StringBuilder sb = new StringBuilder(old_text);
						new_text = sb.deleteCharAt(len-1).toString();
						_parent.setText(new_text);
					}
				}
				return;
			}
			
			if (s.equals("Shift")) {
				if(_parent.isShift()){
					_parent.setShift(false);
					for (JButton k : _shiftKeys){
						k.setBackground(LIGHT_PURPLE);
					}
				}
				else {
					_parent.setShift(true);
					for (JButton k : _shiftKeys){
						k.setBackground(DARK_PURPLE);
					}
				}
				return;
			}
			
			if (s.equals("Caps")) {
				JButton btn = (JButton)e.getSource();
				if(_parent.isCaps()){
					_parent.setCaps(false);
					btn.setBackground(LIGHT_PURPLE);
				}
				else {
					_parent.setCaps(true);
					btn.setBackground(DARK_PURPLE);
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
				
				if (_parent.isShift()){
					s = "" + s.charAt(2);
				}
				else{
					s = "" + s.charAt(0);
				}
			}
			
			if (Character.isLetter(s.charAt(0)) && !(_parent.isShift()) && !(_parent.isCaps())) {
				new_text = old_text + s.toLowerCase();
			} else{
				new_text = old_text + s;
			}
			
			_parent.setText(new_text);
		}
    }
}
