import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Manager {
	private static void printUsage() {
		com.sun.management.OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
			com.sun.management.OperatingSystemMXBean.class);
		System.out.printf(" %6.3f", 100*osBean.getProcessCpuLoad());
		System.out.printf(" %6.3f\n", 100*osBean.getSystemCpuLoad());
	}

	public static void sleep(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String [] args) {	
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		int sleepSecs = 10;
		try {
			sleepSecs = Integer.parseInt(args[0]);
		} catch (Exception e) {
			sleepSecs = 10;
		}

		while (true) {
			System.out.print(sdf.format(new Date()) + "\t");
			printUsage();
			sleep(sleepSecs);
		}
	}
}
