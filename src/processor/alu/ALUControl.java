/**
 * 
 */
package processor.alu;

import instruction.Instruction;
import processor.controls.Control;

/**
 * @author Acid Flow
 *
 */
public class ALUControl {

	private boolean _intputAluOp0;
	private boolean _intputAluOp1;
	private int _inputFunctionCode;
	private int _outputOperation;
	
	public ALUControl(){
		
	}
	
	public void setInputAluOp0(Control c){
		_intputAluOp0 = c.isAluOp0();
	}
	
	public void setInputAluOp1(Control c){
		_intputAluOp1 = c.isAluOp1();
	}
	
	public void setInputFunctionCode(int completeInstruction){
		_inputFunctionCode = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(26,32), 2);
	}
	
	public void setOutputOperation(){
		if(_intputAluOp1 && !_intputAluOp0){
			_outputOperation = _inputFunctionCode;
		}
	}
	
	public int getOutputOperation(){
		return _outputOperation;
	}
	
}
