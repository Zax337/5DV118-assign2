/**
 * 
 */
package gui.model;

import javax.swing.table.AbstractTableModel;

import config.Config;

import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class TableRegisterModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] COL_HEADERS = {"RegName", "RegValue"};
	private String[][] _data;

	/**
	 * 
	 */
	public TableRegisterModel(Registers r) {
		int[] regValue = r.getRegistersValues();
		_data = new String[regValue.length][2];
		for(int i = 0; i < regValue.length; i++){
			_data[i][0] = Registers.REGISTERS_INT.get(i);
			if(Config.DISPLAY_HEX){
				_data[i][1] = "0x" + Integer.toHexString(regValue[i]);
			}else{
				_data[i][1] = Integer.toString(regValue[i], 10);
			}
			
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
