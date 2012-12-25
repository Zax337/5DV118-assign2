/**
 * 
 */
package instruction.iformat;

import instruction.Instruction;

/**
 * @author Acid Flow
 *
 */
public abstract class IInstruction extends Instruction {
	
	protected String _rs;
	protected String _rt;
	protected String _offset;
	protected String _binaryRepresentation;

	protected IInstruction(String mnemonic) {
		super(mnemonic);
		_format = Instruction.I_FORMAT;
	}

	protected abstract void parseArguments();
	
	public void generateBinaryRepresentation(){
		parseArguments();
		_binaryRepresentation = _opCode + _rs + _rt + _offset;
	}
	
	


}
