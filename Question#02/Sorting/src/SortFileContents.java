import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class SortFileContents {
    public static void main(String... args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        long used1 = runtime.totalMemory() - runtime.freeMemory();

        MassiveCounterStore mcs = new MassiveCounterStore();
        long start = System.nanoTime();
        long count = 50 * 1000 * 1000 * 1000L;
        for (long i = count; i > 0; i--)
            mcs.incrementIndex((int)  (i / 1019));
        	mcs.iterator(new NumberCountFunction() {
            @Override
            public void counted(int n, long count) {
              // System.out.println(n + ": " + count);
            }
        });
        long time = System.nanoTime() - start;
        long used2 = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Took %.1f seconds to sort %,d numbers, using %.3f MB%n", time / 1e9, count, (used2-used1)/1e6);
        mcs.close();
    }
}
interface NumberCountFunction {
    public void counted(int n, long count);
}

class MassiveCounterStore {
    public static final int PARTITION_BITS = 26;
    static final int PARTITIONS = (1 << (34 - PARTITION_BITS));  // 32-bit * 4 bytes.
    final MappedByteBuffer[] buffers = new MappedByteBuffer[PARTITIONS];
    final FileChannel channel;
    int smallest = PARTITIONS;
    int largest = 0;

    public MassiveCounterStore() throws IOException {
        File tmpStore = File.createTempFile("counter", "dat");
        tmpStore.deleteOnExit();

        channel = new RandomAccessFile(tmpStore, "rw").getChannel();
        for (int i = 0; i < PARTITIONS; i++)
            buffers[i] = channel.map(FileChannel.MapMode.READ_WRITE, (long) i << PARTITION_BITS, 1 << PARTITION_BITS);
    }

    public void incrementIndex(int n) {
        long l = (n + Integer.MIN_VALUE) & 0xFFFFFFFFL;
        int partition = (int) (l >> (PARTITION_BITS - 2)); // 4 bytes each.
        int index = (int) ((l << 2) & ((1 << PARTITION_BITS) - 1));
        MappedByteBuffer buffer = buffers[partition];
        int count = buffer.getInt(index);
        buffer.putInt(index, count + 1);
        if (smallest > partition) smallest = partition;
        if (largest < partition) largest = partition;
    }
    public void iterator(NumberCountFunction nfc) {
        int n = (smallest << (PARTITION_BITS -2)) + Integer.MIN_VALUE;
        for (int p = smallest; p <= largest; p++) {
            MappedByteBuffer buffer = buffers[p];
            for (int i = 0; i < 1 << PARTITION_BITS; i += 4) {
                int count = buffer.getInt(i);
                if (count != 0)
                    nfc.counted(n, count & 0xFFFFFFFFL);
                n++;
            }
        }
        assert n == Integer.MIN_VALUE;
    }

    public void close() {
        try {
            channel.close();
        } catch (IOException ignored) {
        }
        
    }
}