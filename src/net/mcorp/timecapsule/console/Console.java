package net.mcorp.timecapsule.console;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <h1>Console</h1>
 * <hr>
 * <p>
 * 	
 * </p>
 * @author Andrew Kerr
 */
public class Console {
	
	public static class ConsoleFrame {
		
		public static abstract class ConsoleLine {
			
			public final ConsoleFrame frame;
			
			public ConsoleLine(ConsoleFrame frame) {
				this.frame = frame;
			}
			
			public abstract String toString();
			
		}
		
		public static class ConsoleTextLine extends ConsoleLine {

			public ConsoleTextLine(ConsoleFrame frame) {
				super(frame);
			}
			
			public ConsoleTextLine(ConsoleFrame frame, String content) {
				super(frame);
				this.content = content;
			}

			public String content = "";
			
			@Override
			public String toString() {
				return content;
			}
			
		}
		
		public static class ConsoleBorderLine extends ConsoleLine {

			public ConsoleBorderLine(ConsoleFrame frame) {
				super(frame);
			}

			@Override
			public String toString() {
				int largest_line_length = 0;
				for(ConsoleLine line : frame.lines) {
					if(line instanceof ConsoleBorderLine)
						continue;
					String content = line.toString();
					if(content.contains("\t"))
						content = content.replaceAll("\t", "        ");
					if(largest_line_length < content.length()) {
						largest_line_length = content.length();
					}
				}
				return "+"+"-".repeat(largest_line_length-3)+"+";
			}
			
		}
		
		public final ArrayList<ConsoleLine> lines = new ArrayList<ConsoleLine>();
		
		public void addNewLine() {
			this.lines.add(new ConsoleTextLine(this,""));
		}
		
		public void addTextLine(String content) {
			this.lines.add(new ConsoleTextLine(this,content));
		}
		
		public void addBorderLine() {
			this.lines.add(new ConsoleBorderLine(this));
		}
		
		public void display() {
			this.display(System.out);
		}
		
		public void displayError() {
			this.display(System.err);
		}
		
		public void display(PrintStream ps) {
			ps.print(this.toString());
		}
		
		public String toString() {
			String message = "";
			for(ConsoleLine line : lines) {
				message += line.toString()+"\n";
			}
			return message;
		}
		
	}
	
}
