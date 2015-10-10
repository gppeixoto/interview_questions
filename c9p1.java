import java.math.BigInteger;

public class c9p1 {
    public static BigInteger count_ways(int n){
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.valueOf(2);
        if (n == 3) return BigInteger.valueOf(4);
        BigInteger[] series = new BigInteger[n];
        series[0] = BigInteger.valueOf(1);
        series[1] = BigInteger.valueOf(2);
        series[2] = BigInteger.valueOf(4);
        for (int i=3; i < n; ++i) series[i] = series[i-1].add(series[i-2]).add(series[i-3]);
        return series[n-1];	
    }

    public static void main(String[] args){
        int arg0 = Integer.parseInt(args[0]);
        System.out.println(count_ways(arg0).toString());
    }
}
