import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class c11p2
{
    public static String key(String a)
    {
        char[] str_a = a.toCharArray();
        Arrays.sort(str_a);
        return new String(str_a);
    }

    public static String[] sort_anagram(ArrayList<String> arr)
    {
        HashMap<String, ArrayList<String>> map = 
        new HashMap<String, ArrayList<String>>();
        for (String str : arr)
        {
            String key = key(str);
            if (map.containsKey(key))
            {
                map.get(key).add(str);
            }
            else
            {
                ArrayList<String> n = new ArrayList<String>();
                n.add(str);
                map.put(key, n);
            }
        }
        ArrayList<String> ret = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
        {
            for (String s : entry.getValue()) ret.add(s);
        }
        String[] array = new String[ret.size()];
        for (int i=0; i < ret.size(); ++i) array[i] = ret.get(i);
        return array;
    }

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("acre");
        array.add("banana");
        array.add("otoxeip");
        array.add("aligned");
        array.add("arara");
        array.add("race");
        array.add("dealing");
        array.add("peixoto");
        array.add("bannaa");

        String [] ret = sort_anagram(array);
        assert (ret.length == array.size());
        for (int i=0; i < ret.length; ++i) System.out.println(ret[i]);
    }
}