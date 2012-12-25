/**
 * 
 */
package controller;

import gui.MipsMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import config.Config;

/**
 * @author Acid Flow
 *
 */
public class DisplaySwitchController implements ActionListener {

	private MipsMainFrame _frame;
	/**
	 * 
	 */
	public DisplaySwitchController(MipsMainFrame f) {
		_frame = f;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox){
			JComboBox switcher = (JComboBox) e.getSource();
			if(switcher.getSelectedItem().equals(MipsMainFrame.DISPLAY_HEX)){
				Config.DISPLAY_HEX = true;
			}else{
				Config.DISPLAY_HEX = false;
			}
			_frame.refresh();
		}
	}

}
