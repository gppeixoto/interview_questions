public class Solution {
    public String longestCommonPrefix(ArrayList<String> a) {
        boolean neq = false;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (neq == false) {
            char cmp = s.get(0).charAt(i);
            for (int j=1; j < a.size(); ++j) {
                if (a.get(j) != cmp) {
                    neq = true;
                    break;
                }
            }
            i += 1;
        }
        return sb.toString();
    }
}