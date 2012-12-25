/**
 * 
 */
package instruction.rformat;

import processor.MipsProcessor;

/**
 * @author Acid Flow
 *
 */
public final class SubInstruction extends RInstruction {

	private static final int OP_CODE = 0;
	private static final int FUNC_CODE = 34;
	protected static final int SHAMT_VALUE = 0;
	
	public SubInstruction() {
		super(null);
		_opCode = extendToMaxBits(Integer.toBinaryString(OP_CODE), OPCODE_NB_BITS);
		_shamt = extendToMaxBits(Integer.toBinaryString(SHAMT_VALUE), SHAMT_NB_BIT);
		_funcCode = extendToMaxBits(Integer.toBinaryString(FUNC_CODE), FUNC_CODE_NB_BITS);
	}

	public void execute(MipsProcessor processor){
		//TODO
	}
}
