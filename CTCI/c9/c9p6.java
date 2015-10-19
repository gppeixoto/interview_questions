class Global {
    public static int cnt = 0;
}
public class c9p6 {
    public static void parenthesis(String str, int n, int left, int right) {
        if (str.length() == n*2){
            Global.cnt += 1;
            System.out.println(str);
        }
        if (left < n)
            parenthesis(str + "(", n, left+1, right);
        if (right < left)
            parenthesis(str + ")", n, left, right+1);
    }

    public static void parenthesis(int n) {
        parenthesis("(", n, 1, 0);
    }

    public static void main(String[] args){
        parenthesis(Integer.parseInt(args[0]));
        System.out.println("Total: " + Global.cnt);
    }
}