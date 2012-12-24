import gui.MipsMainFrame;
import instruction.Instruction;

import java.awt.EventQueue;
import java.util.ArrayList;

import parser.InstructionParser;
import processor.MipsProcessor;


/**
 * 
 */

/**
 * @author Acid Flow
 *
 */
public final class MIPSimulator {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<Instruction> ins = InstructionParser.parseFile("data/test.txt");
		final MipsProcessor mp = new MipsProcessor(ins);
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MipsMainFrame frame = new MipsMainFrame(mp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
