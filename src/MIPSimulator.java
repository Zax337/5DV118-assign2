import gui.MipsMainFrame;
import instruction.Instruction;

import java.awt.EventQueue;
import java.util.ArrayList;

import parser.InstructionParser;


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
		System.out.println(ins);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MipsMainFrame frame = new MipsMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
