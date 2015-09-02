public class c1p3
{

    public static boolean checkperm(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[128];
        for (int i=0; i < s.length(); ++i) counter[s.charAt(i)-'0'] += 1;
        for (int i=0; i < t.length(); ++i) if (counter[s.charAt(i)-'0']-- < 0) {return false;}
        return true;
    }

    public static void main (String[] args) {
        System.out.println(checkperm("abcdef", "feacbd"));
        System.out.println(checkperm("arara", "arara"));
        System.out.println(checkperm("arara", "rraaa"));
        System.out.println(checkperm("arara", "rraga"));
    }
}