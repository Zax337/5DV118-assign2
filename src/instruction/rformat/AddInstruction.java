/**
 * 
 */
package instruction.rformat;

import processor.MipsProcessor;


/**
 * @author Acid Flow
 *
 */
public final class AddInstruction extends RInstruction {

	public AddInstruction(){
		super(null);
	}
	
	public AddInstruction(String mnemonic) {
		super(mnemonic);
	}

	public void execute(MipsProcessor processor){
		//TODO
	}
}
