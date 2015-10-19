import java.lang.Math;

public class c5p3 {
    public static int find_next_bigger(int n){
        int c0 = 0, c1 = 0, p = 0;
        int tmp = n;
        int len = (int) Math.ceil(Math.log(n));
        while (len > 0){
            int one = tmp & 1;
            if (one == 1) {
                c1 += 1;
                if (((~tmp >> 1) & 1) == 1){
                    break;
                }
                else {
                    p += 1;
                    tmp >>= 1;
                }
            } else {
                c0 += 1;
                p += 1;
                tmp >>= 1;
            }
        }
        if (c1 < 1) return Integer.MIN_VALUE;
        tmp = n;
        tmp |= (1<<(p+1));
        tmp &= ~(1 << p);
        tmp &= ~((1<<p)-1);
        tmp |= (1 << c1-1)-1;
        return tmp;
    }

    public static int find_next_smaller(int n){
        int c0 = 0, c1 = 1, p = 0;
        int tmp = n;
        int len = (int) Math.ceil(Math.log(n));
        while (len > 0){
            int isZero = (~tmp) & 1;
            if (isZero == 1){ //
                c0 += 1;
                if (((tmp >> 1) & 1) == 1){
                    break;
                } else {
                    p += 1; tmp >>= 1;
                }
            } else {
                c1 += 1; p += 1; tmp >>= 1;
            }
            len--;
        }
        if (c1 < 1) return Integer.MAX_VALUE;
        tmp = n;
        tmp |= (1 << p);
        tmp &= ~(1 << (p+1));
        tmp &= ~((1 << (p-1))-1);       
        tmp |= ((1 << c1)-1)<<(p-1);
        return tmp;
    }
    
    public static void main(String[] args){
        System.out.println(find_next_bigger(6));
        System.out.println(find_next_smaller(9));
    }
}
