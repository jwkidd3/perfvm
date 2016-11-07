import java.util.ArrayList;
import java.util.Collection;

public class PrematurePromotion {

	private static final int MAX_CHUNKS = Integer.getInteger("max.chunks", 10_000);

	private static final Collection<byte[]> accumulatedChunks = new ArrayList<>();

	private static void onNewChunk(byte[] bytes) {
		accumulatedChunks.add(bytes);

		if (accumulatedChunks.size() > MAX_CHUNKS) {
			processBatch(accumulatedChunks);
			accumulatedChunks.clear();
		}
	}

	public static void main(String[] args) {
		while (true) {
			onNewChunk(produceChunk());
		}
	}

	private static byte[] produceChunk() {
		byte[] bytes = new byte[1024];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (Math.random() * Byte.MAX_VALUE);
		}

		return bytes;
	}

	public static volatile byte sink;

	public static void processBatch(Collection<byte[]> bytes) {
		byte result = 0;

		for (byte[] chunk : bytes) {
			for (byte b : chunk) {
				result ^= b;
			}
		}

		sink = result;
	}
}