/* Given a list of points, output the minimum distance to 
 * cover all the points in the given order */
public class REACH {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int steps = 0;
        for (int i=0; i < X.size() - 1; ++i){
            int x0 = X.get(i); int y0 = Y.get(i);
            int x1 = X.get(i+1); int y1 = Y.get(i+1);
            steps += Math.max(Math.abs(x1-x0), Math.abs(y1-y0));
        }
        return steps;
    }
}
