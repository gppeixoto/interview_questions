class arr_stack {
    int[] arr;
    int SIZE;
    int[] tops;

    public arr_stack(int n, int size)
    {
        tops = new int[n];
        SIZE = size;
        for (int i=0; i < n; ++i) tops[i] = i*SIZE-1;
        arr = new int[n*size];
    }

    public void push(int item, int stack)
    {
        if (tops[stack] == (stack+1)*SIZE-1) {
            System.out.println("full stack error"); 
        } else {
            tops[stack] += 1;
            arr[tops[stack]] = item;
        }
    }

    public int pop(int stack)
    {
        if (tops[stack] == stack*SIZE-1) {
            System.out.println("empty stack error");
            return Integer.MIN_VALUE;
        } else {
            int ret = arr[tops[stack]];
            arr[tops[stack]] = 0;
            tops[stack] -= 1;
            return ret;
        }
    }
}

public class c3p1 
{
    public static void main(String[] args) {
        arr_stack s = new arr_stack(3, 100);
    }
}