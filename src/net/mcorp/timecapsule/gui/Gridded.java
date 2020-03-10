package net.mcorp.timecapsule.gui;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Gridded extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8101130294537791913L;

	public final int columns;
	public final int rows;
	
	public Gridded(int rows, int columns) {
		super(null);
		this.rows = rows;
		this.columns = columns;
	}
	
	public void grid(JComponent component, int row, int column) {
		this.grid(component, row, column, 1, 1);
	}
	
	public void grid(JComponent component, int row, int column, int rowspan, int columnspan) {
		if(component == null)
			throw new NullPointerException("Parameter [component] is null.");
		
		if(row < 0)
			throw new IndexOutOfBoundsException("Parameter [row] is set to a negative number, must be positive.");
		
		if(column < 0)
			throw new IndexOutOfBoundsException("Parameter [column] is set to a negative number, must be positive.");
		
		if(rowspan < 0)
			throw new IndexOutOfBoundsException("Parameter [rowspan] is set to a negative number, must be positive.");
		
		if(columnspan < 0)
			throw new IndexOutOfBoundsException("Parameter [columnspan] is set to a negative number, must be positive.");
		
		if(rowspan == 0)
			throw new IndexOutOfBoundsException("Parameter [rowspan] is set to zero, must be a non zero value.");
		
		if(columnspan == 0)
			throw new IndexOutOfBoundsException("Parameter [columnspan] is set to zero, must be a non zero value.");
		
		if(row > rows)
			throw new IndexOutOfBoundsException("Parameter [row] is higher than variable [rows].");
		
		if(column > columns)
			throw new IndexOutOfBoundsException("Parameter [column] is higher than variable [columns].");
		
		if(row+rowspan > rows)
			throw new IndexOutOfBoundsException("Parameters [row + rowspan] is greater than the variable [rows].");
		
		if(column+columnspan > columns)
			throw new IndexOutOfBoundsException("Parameter [column + columnspan] is greater than the variable [columns].");
		
		int x, y, width, height;
		
		width = (this.getWidth()/columns);
		height = (this.getHeight()/rows);
		
		x = width * column;
		y = height * row;
		
		width = width*columnspan;
		height = height*rowspan;
		
		component.setBounds(x, y, width, height);
		this.add(component);
	}
	
}
