/**
 * 
 */
package processor.signextender;

import instruction.Instruction;

/**
 * @author Acid Flow
 *
 */
public class SignExtender {

	private int _inputInstruction;
	private int _output;
	
	public SignExtender(){
		
	}
	
	public void setInputInstruction(int completeInstruction){
		_inputInstruction = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(16,32), 2);
	}
	
	public void setOutput(){
		_output = extendSign();
	}
	
	public int getOutput(){
		return _output;
	}
	
	private int extendSign(){
		int ret = 0;
		boolean isNegative = (Instruction.extendToMaxBits(Integer.toBinaryString(_inputInstruction), 16).charAt(0) == '1') ? true : false;
		if(isNegative){
			for(int i = 0; i < 16; i++){
				ret <<= 1;
				ret |= 1;
			}
		}
		for(int i = 0; i < 16; i++){
			ret <<= 1;
			ret |= ((Instruction.extendToMaxBits(Integer.toBinaryString(_inputInstruction), 16).charAt(i) == '0')) ? 0 : 1;
		}
		return ret;
	}
	
}
