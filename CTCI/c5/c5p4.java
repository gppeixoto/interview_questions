public class c5p4{
    public static void main(String[] args){
    /*
    It checks if n is a power of two.
    
    n - 1:
        if least_significant == 1:
            flip to 0
        else:
            flip every 0 to 1 until find a 1
            flip that 1 to 0
    
    if          n == 0x1000
    then      n-1 == 0x0111

    n and n-1 must have no 1s in common
    x must be all 0s
    so n is: 0*(1)0*
    
    therefore it checks if n is power of two

    public boolean isPowerTwo (int n) { return (n & (n-1))==0; }
    */
    }
}
