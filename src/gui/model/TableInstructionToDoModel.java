/**
 * 
 */
package gui.model;

import instruction.Instruction;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class TableInstructionToDoModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] COL_HEADERS = {"Instruction"};
	private String[][] _data;

	/**
	 * 
	 */
	public TableInstructionToDoModel(ArrayList<Instruction> ins) {
		_data = new String[ins.size()][1];
		for(int i = 0; i < ins.size(); i++){
			_data[i][0] = ins.get(i).getMnemonic();
		}
	}

	public String getColumnName(int col) {
		return COL_HEADERS[col];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return COL_HEADERS.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return _data.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		return _data[row][col];
	}

}
