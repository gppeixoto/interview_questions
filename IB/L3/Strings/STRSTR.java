public class STRSTR {
	public int strStr(final String haystack, final String needle) {
	   boolean mismatch = true;
	   if (
	        haystack == null || needle == null || 
	        haystack == "" || needle == "" || needle.length() > haystack.length()
	        ) {
	            return -1;
	        }
	   
	   int i;
	   for (i=0; i < (haystack.length() - needle.length() + 1) && mismatch; ++i){
	       mismatch = false;
	       for (int j=0; j < needle.length(); ++j) {
	           if (haystack.charAt(i+j) != needle.charAt(j)){
	               mismatch = true;
	               break;
	           }
	       }
	       if (!mismatch) break;
	   }
	   return (!mismatch) ? i : -1 ;
	}
}

