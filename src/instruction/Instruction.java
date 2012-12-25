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
	
	/**
	 * Execute the instruction
	 * @param processor the processor on which the instruction will be executed
	 */
	public abstract void execute(MipsProcessor processor);
	
	protected abstract void parseArguments();
	
	public abstract void generateBinaryRepresentation();
	
	public abstract AbstractTableModel getNumericalFieldsTableModel();
	
	public String toString(){
		return "Instruction [ class = "+ getClass().getSimpleName() + ",\n" +
				" _mnemonic = "+ _mnemonic +",\n" +
						"binary = "+ _binaryRepresentation + "]\n";
	}
	
	protected String extendToMaxBits(String binaryString, int bitNumber){
		String ret = binaryString;
		for(int i = binaryString.length(); i < bitNumber; i++){
			ret = "0" + ret;
		}
		return ret;
	}


	
}
