public class PALINDROME {
	
	
	public static boolean isPalindrome(int a) {
            int cp = a;
	    if (a < 0)
	        return false;
	    if (a >= 0 && a <= 9)
	        return true;
	   
	    long res = 0;
	    boolean ret = false;
	    while (a>0)
	    {
	        res = (res*10) + (a%10); 
	        a /= 10;
	        if (res == cp){
	            ret = true;
	            break;
	        }
	        if (res > cp)
	            break;
	    }
	    return ret;
	}

}      


