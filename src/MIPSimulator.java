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
		if(args.length < 1){
			System.out.println("Usage : MIPSimlator <path_to_asm_file>");
		}else{
			ArrayList<Instruction> ins = InstructionParser.parseFile(args[0]);
			System.out.println(ins);
			final MipsProcessor mp = new MipsProcessor(ins);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MipsMainFrame frame = new MipsMainFrame(mp);
						mp.addObserver(frame);
						mp.notifyObservers();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
