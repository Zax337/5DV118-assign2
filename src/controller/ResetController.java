/**
 * 
 */
package controller;

import gui.MipsMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Acid Flow
 *
 */
public class ResetController implements ActionListener {

	private MipsMainFrame _frame;
	
	public ResetController(MipsMainFrame frame){
		_frame = frame;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_frame.resetProcessor();
	}

}
