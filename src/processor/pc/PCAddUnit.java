/**
 * 
 */
package processor.pc;

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
	
}
