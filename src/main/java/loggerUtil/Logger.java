package loggerUtil;

public class Logger {
	private static Logger logger = null;
	String level = "info";

	private Logger() {

	}

	public static Logger getInstance() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	public void info(Object message) {
		if (level.equals("info")) {
			System.out.println(message);
		}
	}

	public void debug(Object message) {
		if (level.equals("debug")) {
			System.out.println(message);
		}
	}

	public void error(Object message) {
		if (level.equals("error")) {
			System.out.println(message);
		}
	}
}
