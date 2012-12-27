/**
 * 
 */
package instruction;

import javax.swing.table.AbstractTableModel;

import processor.MipsProcessor;


/**
 * @author Acid Flow
 *
 */
public abstract class Instruction {
	public static final String R_FORMAT = "R";
	public static final String I_FORMAT = "I";

	protected String _mnemonic;
	protected String _opCode;
	protected String _format;
	protected String _binaryRepresentation;

	protected Instruction(String mnemonic){
		_mnemonic = mnemonic;
	}

	public String getMnemonic() {
		return _mnemonic;
	}

	public void setMnemonic(String mnemonic){
		_mnemonic = mnemonic;
	}

	public String getBinaryRepresentation(){
		return _binaryRepresentation;
	}

	/**
	 * Execute the instruction
	 * @param processor the processor on which the instruction will be executed
	 */
	public abstract void execute(MipsProcessor processor);

	protected abstract void parseArguments();

	public abstract void generateBinaryRepresentation();

	public abstract AbstractTableModel getNumericalFieldsTableModel();
	public abstract void activateControlsLines(MipsProcessor p);

	public String toString(){
		return "Instruction [ class = "+ getClass().getSimpleName() + ",\n" +
				" _mnemonic = "+ _mnemonic +",\n" +
				"binary = "+ _binaryRepresentation + "]\n";
	}

	public static String extendToMaxBits(String binaryString, int bitNumber){
		String ret = binaryString;
		boolean isNegative = (binaryString.length() == bitNumber && binaryString.charAt(0) == '1') ? true : false;
		if(binaryString.length() < bitNumber){
			for(int i = binaryString.length(); i < bitNumber; i++){
				ret = (isNegative) ? "1" + ret : "0" + ret;
			}
		}else{
			ret = binaryString.substring(binaryString.length() - bitNumber);
		}
		return ret;

	}



}
