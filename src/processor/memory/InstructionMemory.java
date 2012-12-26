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
		byte[] instructionByte = new byte[4];
		instructionByte[0] = createByteFromString(binaryString.substring(0, 8));
		instructionByte[1] = createByteFromString(binaryString.substring(8, 16));
		instructionByte[2] = createByteFromString(binaryString.substring(16, 24));
		instructionByte[3] = createByteFromString(binaryString.substring(24, 32));
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
	
	private byte createByteFromString(String bin){
		byte b = 0;
		for(int i = 0; i < bin.length(); i++){
			b <<= 1;
			b |= (bin.charAt(i) == '1') ? 1 : 0;
		}
		return b;
	}
	
	
	
}