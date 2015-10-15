public class c11p3{

    public static int search(int[] array, int begin, int end, int n) {
        System.out.println("-> " + begin + " " + end);
        if (end < begin)
            return -1;
        int mid = (begin+end)/2;
        if (array[mid]==n)
            return mid;
        boolean left_ordered = array[begin] < array[mid];
        boolean right_ordered = array[mid] < array[begin];
        if (left_ordered)
        {

            if (array[begin] <= n && n <= array[mid-1])
                return search(array, begin, mid-1, n);
            else
                return search(array, mid+1, end, n);
        }
        else if (right_ordered)
        {
            if (array[mid+1] <= n && n <= array[end]){
                return search(array, mid+1, end, n);
            }
            else
                return search(array, begin, mid-1, n);
        }
        else    //array[mid] == array[begin]
        {
            if (array[mid] != array[end])
                return search(array, mid+1, end, n);
            else {
                int res = search(array, begin, mid-1, n);
                if (res == -1)
                    return search(array, mid+1, end, n);
                else
                    return res;
            }
        }
    }

    public static int search(int[] array, int n) {
        return search(array, 0, array.length-1, n);
    }

    public static void main(String[] args){
        int[] a = {2, 2, 2, 3, 4, 2};
        System.out.println(search(a, 3));
    }
}