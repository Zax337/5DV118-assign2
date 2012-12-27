/**
 * 
 */
package processor.memory;

import instruction.Instruction;
import processor.alu.ALU;
import processor.controls.Control;
import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class DataMemory {

	public static final int MEMORY_SIZE = 1000;
	private byte[] _memory;
	private boolean _inputMemRead;
	private boolean _inputMemWrite;
	private int _inputAddress;
	private int _inputWriteData;
	private int _outputReadData;
	
	public DataMemory(){
		_memory = new byte[MEMORY_SIZE];
	}
	
	public void reset(){
		for(int i = 0; i < MEMORY_SIZE; i++){
			_memory[i] = 0;
		}
	}
	
	public byte[] getMemoryValue(){
		return _memory;
	}
	
	public void setInputAddress(ALU alu){
		_inputAddress = alu.getOutputAluResult();
	}
	
	public void setInputWriteData(Registers r){
		_inputWriteData = r.getOutputReadData2();
	}
	
	public void setInputMemRead(Control c){
		_inputMemRead = c.isMemRead();
	}
	
	public void setInputMemWrite(Control c){
		_inputMemWrite = c.isMemWrite();
	}
	
	public void setOutputReadData(){
		if(!_inputMemRead && !_inputMemWrite){
			_outputReadData = _inputAddress;
		}else if(_inputMemRead && !_inputMemWrite){
			// TODO Peut être de _inputAddress - 1 !!
			_outputReadData = loadWord();
		}else if(!_inputMemRead && _inputMemWrite){
			storeWord();
		}
	}
	
	private void storeWord(){
		_memory[_inputAddress] = createByteFromString(Instruction.extendToMaxBits(Integer.toBinaryString(_inputWriteData), 32).substring(0, 8));
		_memory[_inputAddress+1] = createByteFromString(Instruction.extendToMaxBits(Integer.toBinaryString(_inputWriteData), 32).substring(8, 16));
		_memory[_inputAddress+2] = createByteFromString(Instruction.extendToMaxBits(Integer.toBinaryString(_inputWriteData), 32).substring(16, 24));
		_memory[_inputAddress+3] = createByteFromString(Instruction.extendToMaxBits(Integer.toBinaryString(_inputWriteData), 32).substring(24, 32));
	}
	
	private int loadWord(){
		int b = 0;
		for(int i = 0; i < 4; i++){
			b <<= 8;
			b |= _memory[_inputAddress + i];
		}
		return b;
	}
	
	private byte createByteFromString(String bin){
		byte b = 0;
		for(int i = 0; i < bin.length(); i++){
			b <<= 1;
			b |= (bin.charAt(i) == '1') ? 1 : 0;
		}
		return b;
	}
	
	public int getOutput(Control c, ALU alu){
		if(c.isMemToReg()){
			return _outputReadData;
		}else{
			return alu.getOutputAluResult();
		}
	}
	
}
