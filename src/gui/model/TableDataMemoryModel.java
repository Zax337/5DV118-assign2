/**
 * 
 */
package gui.model;

import javax.swing.table.AbstractTableModel;

import config.Config;

import processor.memory.DataMemory;
import processor.register.Registers;

/**
 * @author Acid Flow
 *
 */
public class TableDataMemoryModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final String[] COL_HEADERS = {"Address", "Value 1", "Value 2", "Value 3", "Value 4", };
	private String[][] _data;

	/**
	 * 
	 */
	public TableDataMemoryModel(DataMemory m) {
		byte[] memValue = m.getMemoryValue();
		_data = new String[memValue.length/4][5];
		for(int i = 0; i < memValue.length/4; i++){
			
			if(Config.DISPLAY_HEX){
				_data[i][0] = "0x" + Integer.toHexString(4*i);
				_data[i][1] = "0x" + Integer.toHexString(memValue[i*4]);
				_data[i][2] = "0x" + Integer.toHexString(memValue[4*i+1]);
				_data[i][3] = "0x" + Integer.toHexString(memValue[4*i+2]);
				_data[i][4] = "0x" + Integer.toHexString(memValue[4*i+3]);
			}else{
				_data[i][0] = 4*i + "";
				_data[i][1] = Integer.toString(memValue[4*i]);
				_data[i][2] = Integer.toString(memValue[4*i+1]);
				_data[i][3] = Integer.toString(memValue[4*i+2]);
				_data[i][4] = Integer.toString(memValue[4*i+3]);
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
