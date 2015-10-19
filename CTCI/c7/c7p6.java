import java.lang.Math;
import java.util.HashMap;
import java.util.ArrayList;

class Point {
    double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Line{
    double m, b;
    boolean inf_slope;
    static double eps = 1e-6;
    public Line(Point p, Point q){
        if (Math.abs(p.x-q.x) < eps) {
            this.b = p.x;
            this.m = Double.POSITIVE_INFINITY;
            inf_slope = true;
        } else {
            inf_slope = false;
            this.m = (p.y-q.y)/(p.x-q.x);
            this.b = p.y - m*p.x;
        }
    }

    static public double nearest_eps(double a){
        int r = (int)(a/eps);
        double d = ((double) r) * eps;
        return d;
    }
    
    public boolean equals(Line l){
        if (l.inf_slope)
            return (Math.abs(this.b - l.b)<eps);
        return (Math.abs(this.b-l.b)<eps)&&
            (Math.abs(this.m-l.m)<eps)&&
            (this.inf_slope==l.inf_slope);
    }

    public String toString(){
        char c = this.inf_slope ? 'T' : 'F';
        String line_str = "slope: " + this.m + " y_intercept: " + this.b;
        return line_str;
    }

}

public class c7p6{
    
    public static void insert_line(HashMap<Double, ArrayList<Line>> map, Line l){
        ArrayList<Line> lines = null;
        double key = Line.nearest_eps(l.m);
        if (!map.containsKey(key)){
            lines = new ArrayList<Line>();
            map.put(key, lines);
        } else {
            lines = map.get(key); 
        }
        lines.add(l);
    }

    public static int count_eq_lines(ArrayList<Line> lines, Line l){
        double key = Line.nearest_eps(l.m);
        double eps = Line.eps;
        if (lines == null)
            return 0;
        int cnt = 0;
        for (Line line : lines){
            if (l.equals(line)) cnt += 1;    
        }
        return cnt;
    }
    
    public static int count_eq_lines(HashMap<Double, ArrayList<Line>> map, Line l){
        double key = Line.nearest_eps(l.m);
        double key_plus=key+Line.eps, key_minus=key+Line.eps;
        ArrayList<Line> lines = map.get(key), lines_plus = map.get(key_plus), 
            lines_minus = map.get(key_minus);
        return (count_eq_lines(lines, l)
                + count_eq_lines(lines_plus, l)
                + count_eq_lines(lines_minus, l));

    }
    
    public static Line find_best(ArrayList<Point> points){
        Line best = null;
        int max = Integer.MIN_VALUE, count=0;
        HashMap<Double, ArrayList<Line>> map = 
            new HashMap<Double, ArrayList<Line>>();
        
        for (Point p : points){
            for (Point q : points){
                Line l = new Line(p, q);
                insert_line(map, l);
                count = count_eq_lines(map, l);
                if (count > max) {
                    best = l;
                    max = count;
                }
            }
        }
        return best;
    }

    public static void insert(ArrayList<Point> points, double a, double b){
        points.add(new Point(a,b));
    }
 
}
