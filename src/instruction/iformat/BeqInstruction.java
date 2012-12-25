/**
 * 
 */
package instruction.iformat;

import processor.MipsProcessor;
import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public final class BeqInstruction extends IInstruction {

	private static final int OPCODE = 4;

	protected static final int OPCODE_NB_BITS = 6;
	protected static final int OFFSET_NB_BITS = 16;
	private static final int REGISTER_NB_BITS = 5;

	private static final int OFFSET_POS = 2;
	private static final int REGISTER_RT_POS = 1;
	private static final int REGISTER_RS_POS = 0;


	public BeqInstruction() {
		super(null);
		_opCode = extendToMaxBits(Integer.toBinaryString(OPCODE), OPCODE_NB_BITS);
	}

	public void execute(MipsProcessor processor){
		//TODO
	}

	protected void parseArguments(){
		parseRStoBinaryString();
		parseRTtoBinaryString();
		parseOffsetToBinaryString();
	}

	private void parseRTtoBinaryString(){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		if(indexFirstSpace != -1){
			String rtString = _mnemonic.substring(indexFirstSpace).trim();
			rtString = rtString.split(",")[REGISTER_RT_POS].trim();
			int rtNumber = Registers.REGISTERS.get(rtString);
			_rt = extendToMaxBits(Integer.toBinaryString(rtNumber), REGISTER_NB_BITS);
		}
	}

	private void parseRStoBinaryString(){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		if(indexFirstSpace != -1){
			String rsString = _mnemonic.substring(indexFirstSpace).trim();
			rsString = rsString.split(",")[REGISTER_RS_POS].trim();
			int rtNumber = Registers.REGISTERS.get(rsString);
			_rs = extendToMaxBits(Integer.toBinaryString(rtNumber), REGISTER_NB_BITS);
		}
	}

	private void parseOffsetToBinaryString(){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		if(indexFirstSpace != -1){
			String offsetString = _mnemonic.substring(indexFirstSpace).trim();
			offsetString = offsetString.split(",")[OFFSET_POS].trim();
			_offset = extendToMaxBits(Integer.toBinaryString(Integer.parseInt(offsetString)), OFFSET_NB_BITS);
		}
	}
}
