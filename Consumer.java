import java.util.concurrent.TimeUnit;

public class Consumer {
	public static void main(String [] args) {
		try {
			Queue queue = new Queue("dec04sa",
					"qNk3t6ebSaa3gSOtHWFrZKvqYpFFIJAzRGZDL/SsL7H47hYVeHTtAe1bA78Xlkyo5++9uhcOZTdXG0ThvK8ShA==", "msgq", true);

			while (true) {
				while (queue.size() > 0) {
					String msg = queue.get(true);
					System.out.println(msg);
				}

				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
