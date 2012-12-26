/**
 * 
 */
package processor.controls;

import instruction.Instruction;

/**
 * @author Acid Flow
 *
 */
public class Control {
	
	private static final int[] R_OPCODE = {0};
	private static final int[] LW_OPCODE = {35};
	private static final int[] SW_OPCODE = {43};
	private static final int[] BEQ_OPCODE = {4};

	private int _inputOpcode;
	private boolean _regDst;
	private boolean _branch;
	private boolean _memRead;
	private boolean _memToReg;
	private boolean _aluOp0;
	private boolean _aluOp1;
	private boolean _memWrite;
	private boolean _aluSrc;
	private boolean _regWrite;

	public Control(){
		disableAllControls();
		_inputOpcode = -1;
	}
	
	public void setInputOpcode(int completeInstruction){
		String binString = Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32);
		String opCode = binString.substring(0,6);
		_inputOpcode = Integer.parseInt(opCode, 2);
	}
	
	public void activateLines(){
		if(isROpcode()){
			disableAllControls();
			enableRegDst();
			enableAluOp1();
			enableRegWrite();
		}else if(isLWOpcode()){
			disableAllControls();
			enableMemRead();
			enableMemToReg();
			enableAluSrc();
			enableRegWrite();
		}else if(isSWOpcode()){
			disableAllControls();
			enableMemWrite();
			enableAluSrc();
		}else if(isBEQOpcode()){
			disableAllControls();
			enableBranch();
			enableAluOp0();
		}else{
			disableAllControls();
		}
	}
	
	private boolean isInArray(int[] opCodeArray){
		for(int i = 0; i < opCodeArray.length; i++){
			if(_inputOpcode == opCodeArray[i]){
				return true;
			}
		}
		return false;
	}
	
	private boolean isROpcode(){
		return isInArray(R_OPCODE);
	}
	
	private boolean isLWOpcode(){
		return isInArray(LW_OPCODE);
	}
	
	private boolean isSWOpcode(){
		return isInArray(SW_OPCODE);
	}
	
	private boolean isBEQOpcode(){
		return isInArray(BEQ_OPCODE);
	}

	public void disableAllControls(){
		_aluOp0 = false;
		_aluOp1 = false;
		_aluSrc = false;
		_branch = false;
		_memRead = false;
		_memToReg = false;
		_memWrite = false;
		_regDst = false;
		_regWrite = false;
	}
	
	public void enableAluOp0(){		_aluOp0 = true; 	}

	public void disableAluOp0(){	_aluOp0 = false; 	}

	public void enableAluOp1(){		_aluOp1 = true;		}

	public void disableAluOp1(){	_aluOp1 = false;	}

	public void enableAluSrc(){		_aluSrc = true;		}

	public void disableAluSrc(){	_aluSrc = false;	}

	public void enableBranch(){		_branch = true;		}

	public void disableBranch(){	_branch = false;	}

	public void enableMemRead(){	_memRead = true;	}

	public void disableMemRead(){	_memRead = false;	}

	public void enableMemToReg(){	_memToReg = true;	}

	public void disableMemToReg(){	_memToReg = false;	}

	public void enableMemWrite(){	_memWrite = true;	}

	public void disableMemWrite(){	_memWrite = false;	}

	public void enableRegDst(){		_regDst = true;		}

	public void disableRegDst(){	_regDst = false;	}

	public void enableRegWrite(){	_regWrite = true;	}

	public void disableRegWrite(){	_regWrite = false;	}

	/**
	 * @return the _regDst
	 */
	public boolean isRegDst() {
		return _regDst;
	}

	/**
	 * @return the _branch
	 */
	public boolean isBranch() {
		return _branch;
	}

	/**
	 * @return the _memRead
	 */
	public boolean isMemRead() {
		return _memRead;
	}

	/**
	 * @return the _memToReg
	 */
	public boolean isMemToReg() {
		return _memToReg;
	}

	/**
	 * @return the _aluOp0
	 */
	public boolean isAluOp0() {
		return _aluOp0;
	}

	/**
	 * @return the _aluOp1
	 */
	public boolean isAluOp1() {
		return _aluOp1;
	}

	/**
	 * @return the _memWrite
	 */
	public boolean isMemWrite() {
		return _memWrite;
	}

	/**
	 * @return the _aluSrc
	 */
	public boolean isAluSrc() {
		return _aluSrc;
	}

	/**
	 * @return the _regWrite
	 */
	public boolean isRegWrite() {
		return _regWrite;
	}
}
