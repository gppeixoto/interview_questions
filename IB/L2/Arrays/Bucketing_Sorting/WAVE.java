public class WAVE {
	void swap(ArrayList<Integer> a, int i, int j) {
	    int tmp = a.get(j);
	    a.set(j, a.get(i));
	    a.set(i, tmp);
	}
	
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    if (a.size() <= 1)
	        return a;

	    Collections.sort(a);
	    for (int i=0; i <= a.size()-2; i += 2) {
	        if ((i+1) < a.size())
	            swap(a, i, i+1);
	    }
	    return a;
	}
}

