
public class c1p1 {

    public static boolean checkUnique(String s) { O(n) time, O(1) space //1024 bytes
        int[] counter = new int[256];
        int index = 0;
        for (int i=0; i<s.length(); ++i){
            index = s.charAt(i) - '0';
            counter[index] += 1;
            if (counter[index] > 1) return false;
        }
        return true;
    }

    public static boolean checkUniqueBit(String s){ O(n) time, O(1) space //32 bits
        int counter = 0;
        int index = 0;
        for (int i=0; i < s.length(); ++i){
            index = s.charAt(i) - 'a';
            if ((counter & (1 << index)) > 0) return false;
            counter |= (1 << index);
        }
        return true;
    }

    public static boolean checkUniqueInPlace(String s){ // O(n^2) time, O(1) space
        for (int i=0; i < s.length(); ++i){
            char curr = s.charAt(i);
            for (int j=i+1; j < s.length(); ++j){
                if (curr == s.charAt(j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        for (int i=0; i < args.length; ++i){
            String arg = args[i];
            System.out.println(arg + ": " + checkUniqueInPlace(arg));
        }   
    }
}