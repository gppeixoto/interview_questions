public class INSERTPOS {
    static int helper(ArrayList<Integer> arr, int begin, int end, int n){
        if (end < begin)
            return Math.min(begin, end)+1;
        int mid = (begin+end)/2;
        if (arr.get(mid) == n)
            return mid;
        else if (arr.get(mid) < n) //right
            return helper(arr, mid+1, end, n);
        else //left
            return helper(arr, begin, mid-1, n);
    }
    
    public int searchInsert(ArrayList<Integer> a, int b) {
        return helper(a, 0, a.size()-1, b);
    }
}