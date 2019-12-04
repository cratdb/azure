import java.util.UUID;

public class Producer {
	public static void main(String [] args) {
		try {
			int count = Integer.parseInt(args[0]);
			
			Queue queue = new Queue("dec04sa",
					"qNk3t6ebSaa3gSOtHWFrZKvqYpFFIJAzRGZDL/SsL7H47hYVeHTtAe1bA78Xlkyo5++9uhcOZTdXG0ThvK8ShA==", "msgq", true);

			for (int i=0; i<count; i++)
				queue.add(UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
