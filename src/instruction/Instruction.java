/**
 * 
 */
package instruction;

import javax.swing.table.AbstractTableModel;


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
	 * Parse instruction arguments and set each field to its value
	 */
	protected abstract void parseArguments();

	/**
	 * Create the binary representation of the instruction
	 */
	public abstract void generateBinaryRepresentation();

	/**
	 * Create the Model for JTable of instruction numerical fields
	 * @return
	 */
	public abstract AbstractTableModel getNumericalFieldsTableModel();

	public String toString(){
		return "Instruction [ class = "+ getClass().getSimpleName() + ",\n" +
				" _mnemonic = "+ _mnemonic +",\n" +
				"binary = "+ _binaryRepresentation + "]\n";
	}

	/**
	 * Create a binary string using 2 complements on a specified number of bit
	 * @param binaryString a binary string to extend
	 * @param bitNumber length of the desired string
	 * @return binary string using 2 complements on a specified number of bit
	 */
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
