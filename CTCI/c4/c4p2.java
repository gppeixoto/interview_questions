// simple bfs solves

import java.util.ArrayList;
import java.util.LinkedList;

enum State {
    Unvisited, Visiting, Visited;
}

class Node {
    private int id;
    private ArrayList<Node> adjacents;
    private State state;
    
    public Node(int d, ArrayList<Node> adjs) {
        this.id = d;
        this.adjacents = adjs;
        this.state = State.Unvisited;
    }
    public int getId() {return this.id; }
    public State getState() { return this.state; }
    public void setState(State s) {this.state = s;}

    public ArrayList<Node> getAdjacents() { return this.adjacents; }
}

class Graph {
    private ArrayList<Node> adjList;

    public Graph(ArrayList<Node> nodes) {
        this.adjList = nodes;
    }

    public ArrayList<Node> get_adjlist() { return this.adjList; }
}

public class c4p2 {

    public static boolean existsPath(Graph g, Node start, Node end) {
        for (Node n : g.get_adjlist())
            n.setState(State.Unvisited); 
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node u = queue.removeFirst();
            u.setState(State.Visiting);
            if (u.getId() == end.getId())
                return true;
            for (Node v : u.getAdjacents()) { 
                if (v.getState() == State.Unvisited)
                    queue.add(v);
            }
            u.setState(State.Visited);
        }
        return false;   
    }

    public static void main(String[] args) {
        ArrayList<Node> x = new ArrayList<Node>();
        Node n = new Node(0, null);
        x.add(n);
        ArrayList<Node> y = new ArrayList<Node>();
        y.add(new Node(0, null));
        System.out.println(x.get(0) == y.get(0));
    }
}