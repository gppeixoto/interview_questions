public class NUM1BITS {
    public int numSetBits(long a) {
        int counter = 0;
        for (int i=0; i < 32; ++i) {
            if ((a & 1) != 0) counter ++;
            a >>= 1;
        }
        return counter;
    }
}