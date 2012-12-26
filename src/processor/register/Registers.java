/**
 * 
 */
package processor.register;

import instruction.Instruction;

import java.util.HashMap;

import processor.controls.Control;

/**
 * @author Acid Flow
 *
 */
public class Registers {

	private static final int NB_REGISTER = 32;
	private static final int[] MUST_BE_PRESERVED = {16,17,18,19,20,21,22,23,28,29,30};
	public static final HashMap<String, Integer> REGISTERS = new HashMap<String, Integer>();
	public static final HashMap<Integer, String> REGISTERS_INT = new HashMap<Integer, String>();

	// Hashmap initialisation
	static{
		REGISTERS.put("$zero", 0);	REGISTERS_INT.put(0, "$zero"); 	// Constant 0
		REGISTERS.put("$at", 1);	REGISTERS_INT.put(1,"$at");	// Assembler temporary
		REGISTERS.put("$v0", 2);	REGISTERS_INT.put(2,"$v0");	// values for functiuon returns and expression evaluation
		REGISTERS.put("$v1", 3);	REGISTERS_INT.put(3,"$v1");	
		REGISTERS.put("$a0", 4);	REGISTERS_INT.put(4,"$a0");	// Function arguments
		REGISTERS.put("$a1", 5);	REGISTERS_INT.put(5,"$a1");
		REGISTERS.put("$a2", 6);	REGISTERS_INT.put(6,"$a2");
		REGISTERS.put("$a3", 7);	REGISTERS_INT.put(7,"$a3");
		REGISTERS.put("$t0", 8);	REGISTERS_INT.put(8,"$t0");		// Temporaries
		REGISTERS.put("$t1", 9);	REGISTERS_INT.put(9,"$t1");
		REGISTERS.put("$t2", 10);	REGISTERS_INT.put(10,"$t2");
		REGISTERS.put("$t3", 11);	REGISTERS_INT.put(11,"$t3");
		REGISTERS.put("$t4", 12);	REGISTERS_INT.put(12,"$t4");
		REGISTERS.put("$t5", 13);	REGISTERS_INT.put(13,"$t5");
		REGISTERS.put("$t6", 14);	REGISTERS_INT.put(14,"$t6");
		REGISTERS.put("$t7", 15);	REGISTERS_INT.put(15,"$t7");
		REGISTERS.put("$s0", 16);	REGISTERS_INT.put(16,"$s0");		// Saved temporaries
		REGISTERS.put("$s1", 17);	REGISTERS_INT.put(17,"$s1");
		REGISTERS.put("$s2", 18);	REGISTERS_INT.put(18,"$s2");
		REGISTERS.put("$s3", 19);	REGISTERS_INT.put(19,"$s3");
		REGISTERS.put("$s4", 20);	REGISTERS_INT.put(20,"$s4");
		REGISTERS.put("$s5", 21);	REGISTERS_INT.put(21,"$s5");
		REGISTERS.put("$s6", 22);	REGISTERS_INT.put(22,"$s6");
		REGISTERS.put("$s7", 23);	REGISTERS_INT.put(23,"$s7");
		REGISTERS.put("$t8", 24);	REGISTERS_INT.put(24,"$t8");		// Temporaries
		REGISTERS.put("$t9", 25);	REGISTERS_INT.put(25,"$t9");
		REGISTERS.put("$k0", 26);	REGISTERS_INT.put(26,"$k0");		// Reserved for OS kernel
		REGISTERS.put("$k1", 27);	REGISTERS_INT.put(27,"$k1");
		REGISTERS.put("$gp", 28);	REGISTERS_INT.put(28,"$gp");		// Global pointer
		REGISTERS.put("$sp", 29);	REGISTERS_INT.put(29,"$sp");		// Stack pointer
		REGISTERS.put("$fp", 30);	REGISTERS_INT.put(30,"$fp");		// Frame pointer
		REGISTERS.put("$ra", 31);	REGISTERS_INT.put(31,"$ra");		// Return address
	}

	private int[] _registerValues;
	private int _inputReadRegister1;
	private int _inputReadRegister2;
	private int _inputWriteRegister;
	private int _inputWriteData;
	private int _outputReadData1;
	private int _outputReadData2;

	public Registers(){
		_registerValues = new int[NB_REGISTER];
		initRegisters();
	}

	public int[] getRegistersValues(){
		return _registerValues;
	}
	
	public void setInputReadRegister1(int completeInstruction){
		_inputReadRegister1 = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(6,11), 2);
	}
	
	public void setInputReadRegister2(int completeInstruction){
		_inputReadRegister2 = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(11,16), 2);
	}
	
	public void setInputWriteRegister(int completeInstruction, Control c){
		if(!c.isRegDst()){
			_inputWriteRegister = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(11,16), 2); 
		}else{
			_inputWriteRegister = Integer.parseInt(Instruction.extendToMaxBits(Integer.toBinaryString(completeInstruction), 32).substring(16,21), 2);
		}
	}
	
	public void setOuputReadData1(){
		_outputReadData1 = _registerValues[_inputReadRegister1];
	}
	
	public void setOuputReadData2(){
		_outputReadData1 = _registerValues[_inputReadRegister2];
	}
	
	public int getOutputReadData1(){
		return _outputReadData1;
	}
	
	public int getOutputReadData2(){
		return _outputReadData2;
	}
	
	public void setInputWriteData(int data){
		_inputWriteData = data;
	}
	
	public void writeData(){
		_registerValues[_inputWriteRegister] = _inputWriteData;
	}

	/**
	 * Set the register value
	 * @param regNumber register name
	 * @param value value to store in register
	 * @throws IllegalArgumentException if the register must be preserved
	 */
	public void setRegisterValue(String regName, int value) throws IllegalArgumentException{
		if(REGISTERS.containsKey(regName)){
			int regNumber = REGISTERS.get(regName);
			setRegisterValue(regNumber, value);
		}else{
			throw new IllegalArgumentException("Register :" + regName + " is not a valid register");
		}
	}

	/**
	 * Set the register value
	 * @param regNumber register number
	 * @param value value to store in register
	 * @throws IllegalArgumentException if the register must be preserved
	 */
	public void setRegisterValue(int regNumber, int value) throws IllegalArgumentException{
		if(mustBePreserved(regNumber)){
			throw new IllegalArgumentException("Register "+ regNumber + " must be preserved by callee");
		}else{
			_registerValues[regNumber] = value;
		}
	}

	/**
	 * Initialize registers to 0 
	 */
	private void initRegisters(){
		for(int i = 0; i < NB_REGISTER; i++){
			_registerValues[i] = (i == 10) ? 1 : 0;
		}
	}

	/**
	 * Check if the register reg must be preserved by callee
	 * @param reg register number
	 * @return true if the callee must preserve the register reg, false otherwise
	 */
	private boolean mustBePreserved(int reg){
		for(int i = 0; i < MUST_BE_PRESERVED.length; i++){
			if(MUST_BE_PRESERVED[i] == reg){
				return true;
			}
		}
		return false;
	}
	
	
}
