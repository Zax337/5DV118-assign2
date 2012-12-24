/**
 * 
 */
package instruction;

import processor.MipsProcessor;


/**
 * @author Acid Flow
 *
 */
public abstract class Instruction {

	protected String _mnemonic;
	
	protected Instruction(String mnemonic){
		_mnemonic = mnemonic;
	}
	
	
	public void setMnemonic(String mnemonic){
		_mnemonic = mnemonic;
	}
	
	/**
	 * Execute the instruction
	 * @param processor the processor on which the instruction will be executed
	 */
	public abstract void execute(MipsProcessor processor);
	
	public String toString(){
		return "Instruction [ class = "+ getClass().getSimpleName() + ", _mnemonic = "+ _mnemonic +"]\n";
	}
}
