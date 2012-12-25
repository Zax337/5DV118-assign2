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
			return Integer.toString(Integer.parseInt(_offset,2));
		}
	}
	
	public TableNumericalFieldsIFormatModel getNumericalFieldsTableModel(){
		return new TableNumericalFieldsIFormatModel(this);
	}
	


}
