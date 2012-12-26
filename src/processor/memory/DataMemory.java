/**
 * 
 */
package processor.memory;

import processor.alu.ALU;
import processor.controls.Control;
import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class DataMemory {

	private static final int MEMORY_SIZE = 1000;
	private byte[] _memory;
	private boolean _inputMemRead;
	private boolean _inputMemWrite;
	private int _inputAddress;
	private int _inputWriteData;
	private int _outputReadData;
	
	public DataMemory(){
		_memory = new byte[MEMORY_SIZE];
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
		}
	}
	
	public int getOutput(Control c, ALU alu){
		if(c.isMemToReg()){
			return _outputReadData;
		}else{
			return alu.getOutputAluResult();
		}
	}
	
}
