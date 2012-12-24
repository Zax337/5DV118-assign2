/**
 * 
 */
package instruction;

/**
 * @author Acid Flow
 *
 */
public abstract class Instruction {

	protected String _mnemonic;
	
	protected Instruction(String mnemonic){
		_mnemonic = mnemonic;
	}
	
	public void setMnemonic(String mnemonic){
		_mnemonic = mnemonic;
	}
	
	public String toString(){
		return "Instruction [ class = "+ getClass().getSimpleName() + ", _mnemonic = "+ _mnemonic +"]\n";
	}
}
