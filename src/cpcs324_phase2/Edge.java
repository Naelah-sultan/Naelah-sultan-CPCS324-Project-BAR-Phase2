
package cpcs324_phase2;

import java.util.ArrayList;


public class Edge {

//weight
    int w;
    //source vertex
    Vertex sVer;
    //destination vertex
    Vertex dVer;

    // arraylist of all edges
    static ArrayList<Edge> allEdges = new ArrayList<Edge>();
    String weight;

    public Edge(Vertex sourceVer, Vertex destinationVer, int weight) {
        this.sVer = sourceVer;
        this.dVer = destinationVer;
        this.w = weight;
    }



    public void setW(int w) {
        this.w = w;
    }

    public void setsVer(Vertex sVer) {
        this.sVer = sVer;
    }

    public void setdVer(Vertex dVer) {
        this.dVer = dVer;
    }

    public static void setAllEdges(ArrayList<Edge> allEdges) {
        Edge.allEdges = allEdges;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getW() {
        return w;
    }

    public Vertex getsVer() {
        return sVer;
    }

    public Vertex getdVer() {
        return dVer;
    }

    public static ArrayList<Edge> getAllEdges() {
        return allEdges;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
          if (w== 999999) {
            return (dVer.label + "(" + sVer.label + "," + "inf" + ") ");
        }
        return (dVer.label + "(" +sVer.label + "," + w + ") ");
    }

   public String toString(int sVer, int dVer) {
        if (w == 999999) {
            return (dVer + "(" + sVer + "," + "inf" + ") ");
        }
        return (dVer + "(" + sVer + "," + w+ ") ");
    }
}
    
    

