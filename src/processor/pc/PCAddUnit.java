/**
 * 
 */
package processor.pc;

import processor.alu.ALU;
import processor.controls.Control;

/**
 * @author Acid Flow
 *
 */
public class PCAddUnit {
	private static int PC_INCREMENT = 4;
	
	public PCAddUnit(){
		
	}
	
	public void incrementPC(PC pc){
		pc.setPCValue(pc.getPCValue() + PC_INCREMENT);
	}
	
	public void branchPC(int signExtend, Control c, ALU alu, PC pc){
		int newAddr = signExtend << 2;
		int newValue = newAddr + pc.getPCValue();
		if(c.isBranch() && alu.isOutputZero()){
			pc.setPCValue(newValue);
		}
	}
	
}
