/**
 * 
 */
package processor.memory;

import java.util.ArrayList;

/**
 * @author Acid Flow
 *
 */
public class InstructionMemory {
	
	private ArrayList<Byte> _memory;
	
	public InstructionMemory(){
		_memory = new ArrayList<Byte>();
	}
	
	public void addInstructionToMemory(String binaryString){
		int ins = Integer.parseInt(binaryString, 2);
		byte[] instructionByte = new byte[4];
		instructionByte[0] = Byte.valueOf(binaryString.substring(0, 8), 2);
		instructionByte[1] = Byte.valueOf(binaryString.substring(8, 16), 2);
		instructionByte[2] = Byte.valueOf(binaryString.substring(16, 24), 2);
		instructionByte[3] = Byte.valueOf(binaryString.substring(24, 32), 2);
		_memory.add(instructionByte[0]);
		_memory.add(instructionByte[1]);
		_memory.add(instructionByte[2]);
		_memory.add(instructionByte[3]);
	}
	
	public int getInstruction(int offset){
		int ret = 0;
		for(int i = offset; i < offset + 4; i++){
			ret <<= 8;
			ret |= _memory.get(i) & 0xff;
		}
		return ret;
	}
	
}