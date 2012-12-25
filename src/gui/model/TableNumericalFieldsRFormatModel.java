/**
 * 
 */
package gui.model;

import instruction.rformat.RInstruction;

import javax.swing.table.AbstractTableModel;

/**
 * @author Acid Flow
 *
 */
public class TableNumericalFieldsRFormatModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final String[] COL_HEADERS = {"opcode" , "rs", "rt", "rd", "shamt", "funccode"};
	private String[][] _data;

	/**
	 * 
	 */
	public TableNumericalFieldsRFormatModel(RInstruction ins) {
		_data = new String[1][COL_HEADERS.length];
		_data[0][0] = ins.getOpcodeValue();
		_data[0][1] = ins.getRSValue();
		_data[0][2] = ins.getRTValue();
		_data[0][3] = ins.getRDValue();
		_data[0][4] = ins.getShamtValue();
		_data[0][5] = ins.getFuncCodeValue();
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
