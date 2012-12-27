/**
 * 
 */
package controller;

import gui.MipsMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Acid Flow
 *
 */
public class RunController implements ActionListener {

	private MipsMainFrame _frame; 
	
	public RunController(MipsMainFrame f){
		_frame = f;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		_frame.RUN = !_frame.RUN;
		((JButton) e.getSource()).setText((_frame.RUN) ? _frame.TEXT_STOP : _frame.TEXT_RUN);
		((JButton) e.getSource()).repaint();
		_frame.runProgram();
	}

}
