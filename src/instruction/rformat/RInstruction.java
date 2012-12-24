/**
 * 
 */
package instruction.rformat;

import processor.MipsProcessor;
import instruction.Instruction;

/**
 * @author Acid Flow
 *
 */
public abstract class RInstruction extends Instruction {
	
	protected RInstruction(String mnemonic) {
		super(mnemonic);
	}

	public void execute(MipsProcessor processor){
		//TODO
	}
}
