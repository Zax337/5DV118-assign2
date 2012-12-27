/**
 * 
 */
package instruction.iformat;

import config.Config;
import gui.model.TableNumericalFieldsIFormatModel;
import instruction.Instruction;

/**
 * @author Acid Flow
 *
 */
public abstract class IInstruction extends Instruction {
	
	protected String _rs;
	protected String _rt;
	protected String _offset;

	protected IInstruction(String mnemonic) {
		super(mnemonic);
		_format = Instruction.I_FORMAT;
	}

	protected abstract void parseArguments();
	
	public void generateBinaryRepresentation(){
		parseArguments();
		_binaryRepresentation = _opCode + _rs + _rt + _offset;
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
	
	public String getOffsetValue() {
		if(Config.DISPLAY_HEX){
			return "0x" + Integer.toHexString(Integer.parseInt(_offset,2));
		}else{
			return Integer.toString(createInt2CFromBinaryString(_offset, 16));
		}
	}
	
	public TableNumericalFieldsIFormatModel getNumericalFieldsTableModel(){
		return new TableNumericalFieldsIFormatModel(this);
	}
	
	private int createInt2CFromBinaryString(String s, int nbBits){
		int ret = 0;
		boolean isNegative = (s.length() == nbBits && s.charAt(0) == '1') ? true : false;
		for(int i = 32; i > s.length(); i--){
			ret <<= 1;
			ret |= (isNegative) ? 1 : 0;
		}
		for(int i = 0; i < s.length(); i++){
			ret <<= 1;
			ret |= (s.charAt(i) == '1') ? 1 : 0;
		}
		return ret;
	}
	


}
