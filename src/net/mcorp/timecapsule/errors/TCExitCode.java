package net.mcorp.timecapsule.errors;

public enum TCExitCode {
	
	SUCCESS(0),
	UNKNOWN_ARGUMENT(-1);
	;
	
	public final int code;
	private TCExitCode(int code) {
		this.code = code;
	}
	
}
