public class LENGTHLAST {

    static int len_last(String s){
        int len = 0;
        for (int i=0; i < s.length(); ++i){    
            len = (s.charAt(i) == ' ') ? 0 : (len+1);
        }
        return len;
    }

    public static void main(String[] args){
        System.out.println(len_last("hello world"));
    }

}
