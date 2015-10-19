public class c11p1{
    public static int[] merge(int[] a, int[] b) {
        int i=0, j=0, cur=0;
        int[] res = new int[a.length+b.length];
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[cur] = a[i];
                i += 1;
            } else { 
                res[cur] = b[j];
                j += 1;
            }
            cur += 1;
        }
        if (i == a.length) {
            while (j < b.length) { res[cur] = b[j]; j++; cur++; }
        } else if (j == b.length) {
            while (i < a.length) { res[cur] = a[i]; i++; cur++; }
        }
        return res;
    }
    
    public static int[] merge_inplace(int[] a, int[] b, int n){
        //assume a has [just] enough space to hold b
        int i=0, j=0, cur=0;
        while (j < b.length)
        {
            
            if (b[j] < a[i] && i < n)
            {
                //put b[j] in place of a[i]
                //move each a[i] to a[i+1]
                int tmp = b[j], tmp2 = a[i];
                int k = i;
                while (k < n-1)
                {
                   a[k] = tmp;
                   tmp = tmp2;
                   tmp2 = a[k+1];
                   k += 1;
                }
                a[k] = tmp;
                a[k+1] = tmp2;
                n += 1;
                j += 1;
            }
            else if (a[i] == 0)
            {
                a[i] = b[j];
                j += 1;
            }
            i += 1;
        }
        return a;
    }

    public static int[] merge_inplace(int[] a, int[] b, int lastA, int lastB)
    {
        int lastMerge = lastA+lastB+1;
        while (lastB >= 0)
        {
            if (lastA >=0 && a[lastA] <= b[lastB])
            {
                a[lastMerge] = b[lastB];
                lastB--;
            }
            else
            {
                a[lastMerge] = a[lastA];
                lastA--;
            }
            lastMerge--;
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = {1,3,5,7,9,11, 0, 0, 0};
        int[] b = {4,6,12};
        int[] res = merge_inplace(a,b, 5, 2);
        for (int i=0; i < res.length; ++i) System.out.print(res[i] + " ");
        System.out.println();
    }
}
