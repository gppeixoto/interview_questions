import java.util.ArrayList;
import java.lang.Math;

public class sieve {
    public static int get_next(boolean[] flags, int prime){
        int ret = 0;
        for (int i=prime+1; i < flags.length; ++i){
            if (flags[i]) { ret = i; break; }
        }
        return ret;
    }

    public static void cross_off(boolean[] flags, int prime){
        for (int i=prime*prime; i < flags.length; i += prime){
            flags[i] = false;
        }
    }

    public static ArrayList<Integer> sieve(int max){
        boolean[] flags = new boolean[max+1];
        flags[0] = false; flags[1] = false;
        for (int i=2; i < max+1; ++i) flags[i] = true;
        
        int prime = 2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        while (prime <= (int)Math.sqrt(max)) {
            cross_off(flags, prime);
            prime = get_next(flags, prime);
        }

        for (int i=0; i < max+1; ++i) if (flags[i]) primes.add(i);
        return primes;
    }

    public static void main(String[] args){
        int max = Integer.parseInt(args[0]);
        ArrayList<Integer> primes = sieve(max);
        for (int i : primes) System.out.print(i + " ");
        System.out.println();
    }
}
