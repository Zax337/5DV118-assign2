/**
 * 
 */
package instruction;

import gui.model.TableNumericalFieldsExitModel;
import gui.model.TableNumericalFieldsRFormatModel;

import javax.swing.table.AbstractTableModel;

import processor.MipsProcessor;

/**
 * @author Acid Flow
 *
 */
public final class ExitInstruction extends Instruction {

	public ExitInstruction() {
		super(null);
	}
	
	public void generateBinaryRepresentation(){
		
	}
	
	protected void parseArguments(){
		
	}

	public void execute(MipsProcessor processor){
		//TODO
	}

	@Override
	public AbstractTableModel getNumericalFieldsTableModel() {
		return new TableNumericalFieldsExitModel();
	}
	
	public void activateControlsLines(MipsProcessor p){
		p.getControls().disableAllControls();
	}
}
