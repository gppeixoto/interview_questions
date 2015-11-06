/* Given a list of integers and a target result,
 * return the sum of any 3 elements on the list that
 * is the closest sum to the target 
 *
 * e.g.: S = {-1 2 1 -4}, target = 1
 * ans: 2 (-1 + 1 + 2) */
public class 3SUM {
	public int threeSumClosest(ArrayList<Integer> a, int b){
        if (a.size() == 3)
            return a.get(0)+a.get(1)+a.get(2);
    
        Collections.sort(a);
        int closest = Integer.MAX_VALUE; 
        int diff = Integer.MAX_VALUE;
    
        for (int i=0; i < a.size()-2; ++i){
            int p1 = i+1;
            int p2 = a.size() - 1;
            while (p1 < p2) {
                int sum = a.get(i) + a.get(p1) + a.get(p2);
                if (sum == b) {
                    return b;
                }
                if (Math.abs(sum - b) < diff) {
                    diff = Math.abs(sum-b);
                    closest = sum;
                }
                if (sum > b) p2--;
                else p1++;
            }
        }
        return closest;
    }
}

