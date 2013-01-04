/**
 * 
 */
package instruction.rformat;

import gui.model.TableNumericalFieldsRFormatModel;
import instruction.Instruction;
import processor.register.Registers;
import config.Config;

/**
 * @author Acid Flow
 *
 */
public abstract class RInstruction extends Instruction {
	protected static final int OPCODE_NB_BITS = 6;
	protected static final int FUNC_CODE_NB_BITS = 6;
	protected static final int SHAMT_NB_BIT = 5;
	protected static final int REGISTER_NB_BITS = 5;
	private static final int REGISTER_RS_POS = 1;
	private static final int REGISTER_RD_POS = 0;
	private static final int REGISTER_RT_POS = 2;
	
	protected String _rs;
	protected String _rt;
	protected String _rd;
	protected String _shamt;
	protected String _funcCode;

	protected RInstruction(String mnemonic) {
		super(mnemonic);
		_format = Instruction.R_FORMAT;
	}

	public void generateBinaryRepresentation(){
		parseArguments();
		_binaryRepresentation = _opCode + _rs + _rt + _rd + _shamt + _funcCode;
	}

	protected void parseArguments(){
		parseRStoBinaryString();
		parseRDtoBinaryString();
		parseRTtoBinaryString();
	}

	private String parseRegisterToBinaryString(int reg){
		int indexFirstSpace = _mnemonic.indexOf(" ");
		if(indexFirstSpace != -1){
			String registersString = _mnemonic.substring(indexFirstSpace);
			registersString = registersString.trim();
			registersString = registersString.split(",")[reg].trim();
			int registerNumber = Registers.REGISTERS.get(registersString);
			return extendToMaxBits(Integer.toBinaryString(registerNumber), REGISTER_NB_BITS);
		}
		return null;
	}

	protected void parseRStoBinaryString(){
		_rs = parseRegisterToBinaryString(REGISTER_RS_POS);
	}

	protected void parseRTtoBinaryString(){
		_rt = parseRegisterToBinaryString(REGISTER_RT_POS);
	}

	protected void parseRDtoBinaryString(){
		_rd = parseRegisterToBinaryString(REGISTER_RD_POS);
	}
	
	public String getOpcodeValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_opCode,2));
		}else{
			return Integer.toString(Integer.parseInt(_opCode,2));
		}
	}
	
	public String getRSValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_rs,2));
		}else{
			return Integer.toString(Integer.parseInt(_rs,2));
		}
	}
	
	public String getRTValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_rt,2));
		}else{
			return Integer.toString(Integer.parseInt(_rt,2));
		}
	}
	
	public String getRDValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_rd,2));
		}else{
			return Integer.toString(Integer.parseInt(_rd,2));
		}
	}
	
	public String getShamtValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_shamt,2));
		}else{
			return Integer.toString(Integer.parseInt(_shamt,2));
		}
	}
	
	public String getFuncCodeValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_funcCode,2));
		}else{
			return Integer.toString(Integer.parseInt(_funcCode,2));
		}
	}
	
	public TableNumericalFieldsRFormatModel getNumericalFieldsTableModel(){
		return new TableNumericalFieldsRFormatModel(this);
	}
}
