package net.mcorp.timecapsule.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class FileSelector extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3809487407652804321L;
	
	private File selectedFile;
	public File getSelection() { return this.selectedFile; };
	
	public final int X_PERCENT = 75;
	
	private JTextPane tpane_file_path;
	private JButton btn_select_file;
	
	public FileSelector() {
		super(null);
		selectedFile = null;
		create_elements();
	}
	
	public FileSelector(File file) {
		super(null);
		selectedFile = file;
		create_elements();
	}
	
	private void create_elements() {
		this.tpane_file_path = new JTextPane();
		this.tpane_file_path.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.add(tpane_file_path);
		this.btn_select_file = new JButton("...");
		this.add(btn_select_file);
	}
	
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		System.out.println("SETTING BOUNDS!");
		
		int btn_width = this.btn_select_file.getPreferredSize().width;
		int tpane_width = width-btn_width;
		
		if(tpane_width < 100)
			throw new RuntimeException("Provided width is too small to support this widget. Width must be greater than or equal to "+(100+btn_width)+" units.");
		
		this.tpane_file_path.setBounds(0,0,tpane_width, height);
		this.btn_select_file.setBounds(tpane_width,0,btn_width, height);
	}
	
}
