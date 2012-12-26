/**
 * 
 */
package processor.alu;

import processor.controls.Control;
import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class ALU {

	private static final int FUNC_CODE_ADD = 32;
	private static final int FUNC_CODE_SUB = 34;
	private static final int FUNC_CODE_AND = 36;
	private static final int FUNC_CODE_OR = 37;
	private static final int FUNC_CODE_NOR = 39;
	private static final int FUNC_CODE_SLT = 42;
	
	
	private int _inputReadData1;
	private int _inputReadData2;
	private boolean _outputZero;
	private int _outputAluResult;
	
	public ALU(){
		
	}
	
	public void setInputReadData1(Registers r){
		_inputReadData1 = r.getOutputReadData1();
	}
	
	public void setInputReadData2(Registers r, Control c){
		if(!c.isAluSrc()){
			_inputReadData2 = r.getOutputReadData2();
		}
	}
	
	public void executeOperation(ALUControl aluControl){
		if(aluControl.getOutputOperation() == FUNC_CODE_ADD){
			_outputAluResult = _inputReadData1 + _inputReadData2;
		}
	}
	
	public int getOutputAluResult(){
		return _outputAluResult;
	}
	
	
}
