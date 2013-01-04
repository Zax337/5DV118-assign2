/**
 * 
 */
package instruction.iformat;

import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public final class LwInstruction extends IInstruction {

	private static final int OPCODE = 35;
	
	protected static final int OPCODE_NB_BITS = 6;
	protected static final int OFFSET_NB_BITS = 16;
	private static final int REGISTER_NB_BITS = 5;
	
	private static final int OFFSET_POS = 1;
	private static final int REGISTER_RT_POS = 0;
	
	protected static final int RS_VALUE = 0;
	protected static final int OFFSET_VALUE = 0;
	
	public LwInstruction() {
		super(null);
		_rs = extendToMaxBits(Integer.toBinaryString(RS_VALUE), REGISTER_NB_BITS);
		_opCode = extendToMaxBits(Integer.toBinaryString(OPCODE), OPCODE_NB_BITS);
	}

	
	
	protected void parseArguments(){
		parseRTtoBinaryString();
		parseOffsetToBinaryString();
	}

	private void parseRTtoBinaryString(){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		String rtString = _mnemonic.substring(indexFirstSpace).trim();
		rtString = rtString.split(",")[REGISTER_RT_POS].trim();
		int rtNumber = Registers.REGISTERS.get(rtString);
		_rt = extendToMaxBits(Integer.toBinaryString(rtNumber), REGISTER_NB_BITS);
	}
	
	private void parseOffsetToBinaryString(){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		String offsetString = _mnemonic.substring(indexFirstSpace).trim();
		offsetString = offsetString.split(",")[OFFSET_POS].trim();
		
		// 4($reg)
		if(offsetString.matches("[0-9]+\\(.*\\)")){
			_offset = extendToMaxBits(Integer.toBinaryString(Integer.parseInt(offsetString.split("\\(")[0])), OFFSET_NB_BITS);
			_rs = extendToMaxBits(Integer.toBinaryString(Registers.REGISTERS.get(offsetString.split("\\(")[1].replace(")", ""))), REGISTER_NB_BITS);
		// ($reg)
		}else if(offsetString.matches("\\(.*\\)")){
			_rs = extendToMaxBits(Integer.toBinaryString(Registers.REGISTERS.get(offsetString.split("\\(")[1].replace(")", ""))), REGISTER_NB_BITS);
			_offset = extendToMaxBits(Integer.toBinaryString(OFFSET_VALUE), OFFSET_NB_BITS);
		// 4
		}else{
			_rs = extendToMaxBits(Integer.toBinaryString(RS_VALUE), REGISTER_NB_BITS);
			_offset = extendToMaxBits(Integer.toBinaryString(Integer.parseInt(offsetString)), OFFSET_NB_BITS);
		}
	}	
}
