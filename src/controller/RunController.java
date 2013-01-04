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
		MipsMainFrame.RUN = !MipsMainFrame.RUN;
		((JButton) e.getSource()).setText((MipsMainFrame.RUN) ? MipsMainFrame.TEXT_STOP : MipsMainFrame.TEXT_RUN);
		((JButton) e.getSource()).validate();
		((JButton) e.getSource()).repaint();
		_frame.runProgram();
	}

}
