/**
 * 
 */
package gui.model;

import javax.swing.table.AbstractTableModel;

import processor.controls.Control;

/**
 * @author Acid Flow
 *
 */
public class TableControlsModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] COL_HEADERS = {"Control", "Enabled"};
	private String[][] _data;
	
	public TableControlsModel(Control c){
		_data = new String[9][2];
		_data[0][0] = "RegDst";
		_data[0][1] = c.isRegDst() ? "1" : "0";
		
		_data[1][0] = "Branch";
		_data[1][1] = c.isBranch() ? "1" : "0";
		
		_data[2][0] = "MemRead";
		_data[2][1] = c.isMemRead() ? "1" : "0";
		
		_data[3][0] = "MemToReg";
		_data[3][1] = c.isMemToReg() ? "1" : "0";
		
		_data[4][0] = "AluOP0";
		_data[4][1] = c.isAluOp0() ? "1" : "0";
		
		_data[5][0] = "AluOP1";
		_data[5][1] = c.isAluOp1() ? "1" : "0";
		
		_data[6][0] = "MemWrite";
		_data[6][1] = c.isMemWrite() ? "1" : "0";
		
		_data[7][0] = "AluSrc";
		_data[7][1] = c.isAluSrc() ? "1" : "0";
		
		_data[8][0] = "RegWrite";
		_data[8][1] = c.isRegWrite() ? "1" : "0";
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COL_HEADERS.length;
	}
	
	public String getColumnName(int col) {
		return COL_HEADERS[col];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return _data.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return _data[row][col];
	}

}
