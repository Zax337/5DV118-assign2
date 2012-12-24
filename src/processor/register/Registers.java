/**
 * 
 */
package processor.register;

import java.util.HashMap;

/**
 * @author Acid Flow
 *
 */
public class Registers {

	private static final int NB_REGISTER = 32;
	private static final int[] MUST_BE_PRESERVED = {16,17,18,19,20,21,22,23,28,29,30};
	private static final HashMap<String, Integer> REGISTERS = new HashMap<String, Integer>();

	// Hashmap initialisation
	static{
		REGISTERS.put("$zero", 0); 	// Constant 0
		REGISTERS.put("$at", 1);	// Assembler temporary
		REGISTERS.put("$v0", 2); 	// values for functiuon returns and expression evaluation
		REGISTERS.put("$v1", 3);	
		REGISTERS.put("$a0", 4);	// Function arguments
		REGISTERS.put("$a1", 5);	
		REGISTERS.put("$a2", 6);
		REGISTERS.put("$a3", 7);
		REGISTERS.put("$t0", 8);	// Temporaries
		REGISTERS.put("$t1", 9);
		REGISTERS.put("$t2", 10);
		REGISTERS.put("$t3", 11);
		REGISTERS.put("$t4", 12);
		REGISTERS.put("$t5", 13);
		REGISTERS.put("$t6", 14);
		REGISTERS.put("$t7", 15);
		REGISTERS.put("$s0", 16);	// Saved temporaries
		REGISTERS.put("$s1", 17);
		REGISTERS.put("$s2", 18);
		REGISTERS.put("$s3", 19);
		REGISTERS.put("$s4", 20);
		REGISTERS.put("$s5", 21);
		REGISTERS.put("$s6", 22);
		REGISTERS.put("$s7", 23);
		REGISTERS.put("$t8", 24);	// Temporaries
		REGISTERS.put("$t9", 25);
		REGISTERS.put("$k0", 26);	// Reserved for OS kernel
		REGISTERS.put("$k1", 27);
		REGISTERS.put("$gp", 28);	// Global pointer
		REGISTERS.put("$sp", 29);	// Stack pointer
		REGISTERS.put("$fp", 30);	// Frame pointer
		REGISTERS.put("$ra", 31);	// Return address
	}

	private int[] _registerValues;

	public Registers(){
		_registerValues = new int[NB_REGISTER];
		initRegisters();
	}

	public int[] getRegistersValues(){
		return _registerValues;
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
			_registerValues[i] = 0;
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
