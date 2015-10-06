public class c5p6 {
    public static int swap_odd_even(int n){
        int p = ~0;
        for (int i=0; i < 32; i += 2) p &= ~(1 << i);
        int q = ~p;
        //directly inputting the mask:
        //p = 0xaaaaaaaa;
        //q = 0x55555555;
        return (((n & p)>>1) | ((n & q)<<1)); 
    }

    public static void main(String[] args){
        for (String a : args){
            int arg = Integer.parseInt(a);
            String c = Integer.toBinaryString(swap_odd_even(arg));
            System.out.println(Integer.toBinaryString(arg)+"\n"+c+"\n");
        }
    }
}
