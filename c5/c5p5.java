public class c5p5 {
    public static int how_many_bits(int a, int b){
        int res = a ^ b, count = 0;
        while (res > 0){
            if ((res & 1) == 1) count++;
            res >>= 1;
        }
        return count;
    }
    
    public static void main(String[] args){
        for (int i=0; i < 10; ++ i) for (int j=0; j < 10; ++j) 
            System.out.println("a: " + i + " b: " + j + " n: " + how_many_bits(i,j));
    }
}
