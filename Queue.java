import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.queue.*;

public class Queue {

	private CloudQueue queue;

	public Queue(String sa, String saKey, String qName, boolean create) {
		String connString = "DefaultEndpointsProtocol=https;" +
			    "AccountName=" + sa + ";" +
			        "AccountKey=" + saKey; 
		try {
			CloudStorageAccount storageAccount =
			       CloudStorageAccount.parse(connString);
			CloudQueueClient queueClient = storageAccount.createCloudQueueClient();
			this.queue = queueClient.getQueueReference(qName);
			if (create)
				this.queue.createIfNotExists();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean add(String msgText) {
		if (queue == null)
			return false;

		try {
			CloudQueueMessage msg = new CloudQueueMessage(msgText);
			queue.addMessage(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public long size() {
		if (queue == null)
			return 0L;

		try {
			queue.downloadAttributes();
			return queue.getApproximateMessageCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	public String peek() {
		return get(false);
	}

	public void remove() {
		get(true);
	}

	public String pop() {
		return get(true);
	}

	public String get(boolean remove) {
		if (queue == null)
			return null;

		try {
			CloudQueueMessage msg = queue.peekMessage();
			if (msg != null && remove) {
				if (msg == null)
					System.out.println("Its null");
				queue.deleteMessage(msg);
			}
			return (msg == null) ? null : msg.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
