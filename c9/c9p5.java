import java.util.ArrayList;

public class c9p5{
    public static String helper(String str, char c, int index) {
        String ret = "";
        for (int i=0; i < index; ++i) ret += str.charAt(i);
            ret += c;
        for (int i=index; i < str.length(); ++i) ret += str.charAt(i);
            return ret;
    }

    public static ArrayList<String> 
    permutations(ArrayList<String> strs, char c)
    {
        ArrayList<String> ret = new ArrayList<String>();
        if (strs.size() == 0) {
            String str = ""+c;
            ret.add(str);
        } else {
            for (String s : strs)
                for (int i=0; i <= s.length(); ++i)
                    ret.add(helper(s, c, i));
        }
        return ret;
    }

    public static ArrayList<String> permutations(String str)
    {
        ArrayList<String> ret = new ArrayList<String>();
        for (int i=0; i < str.length(); ++i){
            ret  = permutations(ret, str.charAt(i));
        }
        return ret;
    }

    public static void main(String[] args){
        for (String arg : args){
            System.out.println("Permutations of: " + arg);
            System.out.println("##########");
            for (String s : permutations(arg))
                    System.out.println(s);            
            System.out.println("##########");
        }
    }
}