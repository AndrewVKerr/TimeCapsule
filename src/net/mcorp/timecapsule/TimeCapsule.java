package net.mcorp.timecapsule;

import java.awt.GraphicsEnvironment;

import javax.swing.*;

import net.mcorp.timecapsule.gui.FileSelector;

public class TimeCapsule {

	private boolean console_only = false;
	public boolean get_console_only() { return console_only; };
	
	public TimeCapsule(String[] args) {
		
		if(GraphicsEnvironment.isHeadless()) {
			System.err.println("[FATAL] No Graphical Environmnent is available for the graphics to be displayed on.");
			System.exit(1);
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel root = new JPanel(null);
		root.setSize(720,480);
		root.setPreferredSize(root.getSize());
		frame.add(root);
		
		final int w_width = root.getWidth();
		final int w_height = root.getHeight();
		
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		
		width = w_width-10;
		height = 25;
		
		x = 5;
		y = 5;
		
		JLabel lbl_title = new JLabel("Time Capsule",SwingConstants.CENTER);
		lbl_title.setBounds(x, y, width, height);
		root.add(lbl_title);
		
		y += height+10;
		
		JLabel lbl_file_path = new JLabel("Filepath:",SwingConstants.RIGHT);
		
		width = lbl_file_path.getPreferredSize().width;
		
		lbl_file_path.setBounds(x, y, width, height);
		root.add(lbl_file_path);
		
		x += width+5;
		
		width = w_width-width-15;
		
		FileSelector fsel_filepath = new FileSelector();
		fsel_filepath.setBounds(x, y, width, height);
		root.add(fsel_filepath);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TimeCapsule(args);
	}

}
