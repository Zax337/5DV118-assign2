/**
 * 
 */
package instruction;

import gui.model.TableNumericalFieldsExitModel;

import javax.swing.table.AbstractTableModel;

/**
 * @author Acid Flow
 *
 */
public final class ExitInstruction extends Instruction {

	public ExitInstruction() {
		super(null);
	}
	
	public void generateBinaryRepresentation(){}
	
	protected void parseArguments(){}

	@Override
	public AbstractTableModel getNumericalFieldsTableModel() {
		return new TableNumericalFieldsExitModel();
	}
}
