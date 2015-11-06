import java.util.*;

public class Solution {
    public static String get_key(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int i = 1;
        for (String s : a) {
            String key = get_key(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> list = map.get(key);
            list.add(i);
            i++;
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            ret.add(entry.getValue());                
        }
    
        return ret;
    }
}