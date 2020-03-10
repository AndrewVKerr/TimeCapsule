package net.mcorp.timecapsule;

import javax.swing.JFrame;

import net.mcorp.timecapsule.gui.MainMenu;

public class TimeCapsule {

	private boolean console_only = false;
	public boolean get_console_only() { return console_only; };
	
	public TimeCapsule(String[] args) {
		
		for(String arg : args) {
			if(arg.equalsIgnoreCase("-help")) {
				String message = "";
				message += "-=[ TimeCapsule ]=-\n";
				message += "\n";
				message += "\t-help : Displays this help screen.\n";
				message += "\t-console : Only allows console based input/output.\n";
				System.out.println(message);
				System.exit(0);
			}else
			if(arg.equalsIgnoreCase("-console")) {
				console_only = true;
			}
		}
		
		JFrame frame = new JFrame();
		frame.setSize(720,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		new MainMenu(frame);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TimeCapsule(args);
	}

}
