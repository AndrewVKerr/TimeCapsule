package net.mcorp.timecapsule;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

import net.mcorp.timecapsule.console.Console;
import net.mcorp.timecapsule.console.Console.ConsoleFrame;
import net.mcorp.timecapsule.errors.TCExitCode;
import net.mcorp.timecapsule.gui.MainMenu;

/**
 * <h1>TimeCapsule</h1>
 * <hr>
 * <p>
 * 
 * </p>
 * @author Andrew Kerr
 */
public final class TimeCapsule {
	
	public final boolean console_only;
	
	/**
	 * The public constructor for {@linkplain TimeCapsule}.
	 * @param args - {@link String String[]} - An array of Strings used to change this programs behavior. 
	 */
	public TimeCapsule(String[] args) {
		
		boolean console_only = false;
		
		for(String arg_temp : args) {
			
			String[] arg_value_pair = arg_temp.split(":",2);
			
			String arg = arg_value_pair[0];
			String value = null;
			if(arg_value_pair.length == 2)
				value = arg_value_pair[1];
			
			if(arg.equalsIgnoreCase("-help")) {
				ConsoleFrame frame = new ConsoleFrame();
				frame.addBorderLine();
				frame.addTextLine("|\t\t\t\tTimeCapsule program help\t\t\t\t|");
				frame.addBorderLine();
				frame.addTextLine("\t-help    : displays this help screen.\t");
				frame.addTextLine("\t-console : Defaults to the console for input, doesnt initialized the GUI.\t");
				frame.addTextLine("\t");
				System.out.println(frame);
				System.exit(TCExitCode.SUCCESS.code);
			}else
			if(arg.equalsIgnoreCase("-console")){
				console_only = true;
			}else {
				System.err.println("Unknown option switch ["+arg+"]"+(value == null ? "!" : ", value["+value+"]!"));
				System.exit(TCExitCode.UNKNOWN_ARGUMENT.code);
			}
		}
		
		this.console_only = console_only;
		if(this.console_only == false && !GraphicsEnvironment.isHeadless()) {
			this.startGUI();
		}else {
			this.startConsole();
		}
		
	}
	
	private void startConsole() {
		
	}

	private void startGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("TimeCapsule");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension frame_size = new Dimension(720,480);
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(frame_size);
		frame.setLocation(screen_size.width/2-frame_size.width/2, screen_size.height/2-frame_size.height/2);
		
		new MainMenu(frame);
		
		frame.setVisible(true);
	}
	
	/**
	 * The main method for the TimeCapsule program executable. Generates one {@linkplain TimeCapsule} object using the
	 * given <b>args</b> parameter.
	 * @param args -  {@link String String[]} - An array of Strings.
	 */
	public static void main(String[] args) {
		
		new TimeCapsule(args);
		
	}
	
}
