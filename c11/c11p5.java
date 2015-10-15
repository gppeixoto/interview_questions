public class c11p5 {
    public static int find(String[] arr, int begin, int end, String str) {
        System.out.println("--> " + begin + " " + end);
        if (end < begin)
            return -1;
        int mid = (begin+end)/2;
        int aux = mid;
        if (arr[mid].equals(str))
            return mid;
        
        for (int i=mid; i < arr.length; ++i){
            if (!arr[i].equals("")) { 
                aux = i; break; 
            }
        }

        if (arr[aux].equals(str))
            return aux;
        if (arr[aux].compareTo(str) > 0)
            return find(arr, begin, mid-1, str);
        return find(arr, aux+1, end, str);
    }

    public static int find(String[] arr, String str) {
        return find(arr, 0, arr.length-1, str);
    }

    public static void main(String[] args)
    {
        String[] arr = {"at", "", "", "", "ball", "", "car", "", "", "dad"};
        System.out.println(find(arr, "at"));
    }
}