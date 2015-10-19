public class c1p2
{
    public static String reverse(String s) {
        int len = s.length();
        char[] arr = new char[len]; for (int i=0; i<len; ++i) arr[i] = s.charAt(i);
        int middle = len / 2;
        for (int i=0; i<middle; ++i){
            arr[i] = s.charAt(len-1-i);
            arr[len-1-i] = s.charAt(i);
        }
        if (len % 2 != 0) arr[middle] = s.charAt(middle);
        String ret = "";
        for (char c : arr) ret += c;
        return ret;
    }

    public static void main(String[] args){
        for (String arg : args) {
            System.out.println(arg + " reversed: " + reverse(arg));
        }
    }
}