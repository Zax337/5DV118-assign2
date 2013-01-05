package gui.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RegistersRenderer extends DefaultTableCellRenderer {

	private static final Color HIGHLIGHTED_CELL = Color.LIGHT_GRAY;
	private static final Color DEFAULT_CELL = Color.WHITE;
	private int _indexCell;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistersRenderer(){
		super();
		_indexCell = -1;
	}
	
	public void setIndexCell(int i){
		_indexCell = i;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(_indexCell == row && _indexCell != -1){
			c.setBackground(HIGHLIGHTED_CELL);
		}
		else{
			c.setBackground(DEFAULT_CELL);
		}
		return c;
	}
}
