public class c17p3 {
    
    static int count_zeros(int n)
    {
        boolean f = false;
        int counter = 0;
        while (n != 0) {
            if ((n%5 == 0) && !f) f = true;
            if ((n%2 == 0) && f) {
                f = false;
                counter++;
            }
            --n;
        }
        return counter;
    }

    public static void main(String[] args){
        for (String s : args){
            System.out.println("fat of " + s + ": " + count_zeros(Integer.parseInt(s)));
        }
    }

}
