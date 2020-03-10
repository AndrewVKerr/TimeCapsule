package net.mcorp.timecapsule.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu extends Gridded{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599113248812751051L;

	public MainMenu(JFrame frame) {
		super(6,3);
		if(frame == null)
			throw new NullPointerException("JFrame frame parameter is not set to a non null value.");
		this.setSize(frame.getSize());
		
		JLabel lbl_title = new JLabel("Time Capsule", SwingConstants.CENTER);
		this.grid(lbl_title, 0, 0, 1, 3);
		
		JButton btn_splitter = new JButton("Seperate");
		this.grid(btn_splitter, 1, 1);
		
		JButton btn_combinator = new JButton("Combine");
		this.grid(btn_combinator, 2, 1);
		
		JButton btn_options = new JButton("Options");
		this.grid(btn_options, 3, 1);
		
		JLabel lbl_credits = new JLabel("Program by: Andrew Kerr",SwingConstants.CENTER);
		this.grid(lbl_credits, 5, 2);
		
		frame.add(this);
	}
	
}
