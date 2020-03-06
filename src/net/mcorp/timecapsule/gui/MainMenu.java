package net.mcorp.timecapsule.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599113248812751051L;

	public final int columns = 3;
	public final int rows = 5;
	
	public MainMenu(JFrame frame) {
		frame.add(this);
		
		this.setLayout(new GridLayout(5,3));
		this.setLocale(Locale.ENGLISH);
		this.setBackground(Color.DARK_GRAY);
		
		this.add(new JPanel());
		
		JLabel lbl_title = new JLabel("TimeCapsule");
		this.add(lbl_title);
	}
	
}
