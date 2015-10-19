import java.util.ArrayList;
import java.util.HashMap;

public class c9p11{
    static HashMap<String, Integer> memo;

    public static String sub(String exp, int i, int j){
        return exp.substring(i, j);
    }
    
    public static String sub(String exp, int i){
        return exp.substring(i+1);
    }

    public static int f(String exp, boolean res){
        //check if precomputed
        String key = exp+"_"+res;
        if (memo.containsKey(key)){
            return memo.get(key);
        }

        //base cases
        if (exp.equals("0") && !res) return 1;
        if (exp.equals("1") && res) return 1;
        else if (exp.length() <= 1) return 0;

        int ways = 0;
        for (int i=0; i < exp.length(); ++i){
            char c = exp.charAt(i);
            if (res){
                if (c == '^') {
                    ways += f(sub(exp, 0, i), true)*f(sub(exp,i), false) +
                    f(sub(exp, 0, i), false)*f(sub(exp,i), true);
                } else if (c == '&') {
                    ways += f(sub(exp, 0, i), true)*f(sub(exp, i), true);
                } else if (c == '|') {
                    ways += f(sub(exp,0,i), true)*f(sub(exp,i), true)+
                    f(sub(exp,0,i), true)*f(sub(exp,i), false)+
                    f(sub(exp,0,i), false)*f(sub(exp,i),true);
                }
            } else {
                if (c == '^'){
                    ways += f(sub(exp,0,i),true)*f(sub(exp,i), true)+
                    f(sub(exp,0,i), false)*f(sub(exp,i), false);
                } else if (c == '&') {
                    ways += f(sub(exp,0,i), false)*f(sub(exp,i), false)+
                    f(sub(exp,0,i), true)*f(sub(exp,i), false)+
                    f(sub(exp,0,i), false)*f(sub(exp,i),true);
                } else if (c == '|') {
                    ways += f(sub(exp, 0, i), false)*f(sub(exp, i), false);
                }
            }
        }
        memo.put(exp+"_"+res, ways);
        return ways;
    }

    public static void main(String[] args){
        memo = new HashMap<String, Integer>();
        System.out.println(f("1^0|1&0|0^1", true));
    }
}