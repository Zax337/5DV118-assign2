/**
 * 
 */
package instruction.rformat;


/**
 * @author Acid Flow
 *
 */
public final class NopInstruction extends RInstruction {

	private static final int OP_CODE = 0;
	private static final int FUNC_CODE = 0;
	protected static final int SHAMT_VALUE = 0;
	
	public NopInstruction() {
		super(null);
		_opCode = extendToMaxBits(Integer.toBinaryString(0), RInstruction.OPCODE_NB_BITS);
		_funcCode = extendToMaxBits(Integer.toBinaryString(0), RInstruction.FUNC_CODE_NB_BITS);
	}
	
	@Override
	public void parseArguments(){
		_rd = extendToMaxBits(Integer.toBinaryString(0), RInstruction.REGISTER_NB_BITS);
		_rs = extendToMaxBits(Integer.toBinaryString(0), RInstruction.REGISTER_NB_BITS);
		_rt = extendToMaxBits(Integer.toBinaryString(0), RInstruction.REGISTER_NB_BITS);
		_shamt = extendToMaxBits(Integer.toBinaryString(0), RInstruction.REGISTER_NB_BITS);
	}
}
