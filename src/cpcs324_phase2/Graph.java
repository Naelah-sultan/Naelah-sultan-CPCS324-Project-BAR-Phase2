
package cpcs324_phase2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//----------------------------------------------------------------
public class Graph {
    int NOVertices;// number of vertices
    int NOEdges;// number of edges
    boolean isDigraph = false; // <false>=> directet graph
    static Edge[][] adjMatrix = null;

    static char[] vertex_label = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
    static ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    //private Vertex[] vertices = null;

    public static boolean Charr = false;

    // ---------------------------------------------------------------------------

    // -----------------------Constructures---------------------------

    public Graph(int VertixsNum, int EdgeNum, boolean isDigraph) {
        this.NOVertices = VertixsNum;
        this.NOEdges = EdgeNum;
        this.isDigraph = isDigraph;
        adjMatrix = new Edge[VertixsNum][VertixsNum];

    }

    public Graph() {

        // 26 letters
        adjMatrix = new Edge[26][26];
    }

    // call this constructure to create graph object for both methods
    public Graph(int VertixsNum, int EdgeNum) {
        adjMatrix = new Edge[VertixsNum][VertixsNum];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {

                adjMatrix[i][j] = null;
            }
        } // end
    }
    // ----------------------------------------------------------------------------

    // ----------------------------------------------------------------------------------------------------------

    // -+-+-+-+-+-+-+-+-+-+-+-+-Requirement 2-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

    // --------------------------------MakeGraph()---------------------------------
    // makegraph() method
    // create the 5 specified graphs (with n vertices & m edges)from cases
    // Apply the chosen algorithm on each graph
    // For each graph display the running time
    // Make the required comparison between the running time and the result of the
    // expected asymptotic class for each graph
    // -------------------------------------------------------------------------------------------------------
    public Graph makeGraph(int verticeNum, int edgeNum) {
        Graph graph = new Graph(verticeNum, edgeNum);
        int randomS;
        int randomD;
        int weight = 0;
        int remainingEdge = 0;
        Vertex sourceVert;
        Vertex targetVert;

        // loop to generete vetices
        for (int i = 0; i < verticeNum; i++) {

            Vertex tempVert = new Vertex(i);
            vertices.add(tempVert);
        }

        // for (int i = 0; i < Graph.adjMatrix.length; i++) {
        // for (int j = 0; j < Graph.adjMatrix[i].length; j++) {
        // if (i == j) {
        // Graph.adjMatrix[i][j] = new Edge(verList.get(i), verList.get(j), 0);
        // } else {
        // Graph.adjMatrix[i][j] = new Edge(verList.get(i), verList.get(j), 999999);
        // } // END IF
        // } // END FOR LOOP j
        // } // END FOR LOOP i

        for (int i = 0; i < Graph.adjMatrix.length; i++) {
            for (int j = 0; j < Graph.adjMatrix[i].length; j++) {
                if (i == j) {
                    Graph.adjMatrix[i][j] = new Edge(vertices.get(i), vertices.get(j), 0);
                } else {
                    Graph.adjMatrix[i][j] = new Edge(vertices.get(i), vertices.get(j), 999999);
                }
            }
        }

        // loop to randomly connect two random verices with random edges
        for (int i = 0; i < verticeNum; i++) {

            // random vertices
            randomS = (int) (Math.random() * verticeNum);
            sourceVert = new Vertex(randomS);
            randomD = (int) (Math.random() * verticeNum);
            targetVert = new Vertex(randomD);

            // if isConnected is true, choose different vertices
            if (graph.getAdjMatrix()[randomS][randomD].w != 999999 || randomS == randomD) {
                i--;
            } // if not connectend, connect it by addEdge function shown below
            else {
                // random waight
                weight = (int) (Math.random() * 20 + 1);
                graph.addEdgee(randomS, randomD, weight);
                graph.getAdjMatrix()[randomS][randomD].getsVer().setIsVisited(true);
                graph.getAdjMatrix()[randomS][randomD].getdVer().setIsVisited(true);

            }
            remainingEdge = edgeNum - graph.NOEdges;// decrease number of edge
        }
        int isConnect = isConnected(vertices);// save value of is conected
        // if it is bigger than -1 it means a vertex was un Visited
        if (isConnect > -1) {
            // loop to find the un Visited vertex
            for (int i = 0; i < graph.getAdjMatrix().length; i++) {
                // either i is the vertex
                if (i == isConnect) {
                    // if i is the vertex loop to find a empty place to make edge
                    for (int j = 0; j < graph.getAdjMatrix()[i].length; j++) {
                        if (graph.getAdjMatrix()[i][j] == null) {
                            graph.getAdjMatrix()[i][j] = graph.addEdgee(i, j, weight);
                            graph.NOEdges++;
                        }
                    }
                } // or j is the vertex
                else {
                    // make the edge and break out of the for-loop
                    if (graph.getAdjMatrix()[i][isConnect] == null) {
                        graph.getAdjMatrix()[i][isConnect] = graph.addEdgee(i, isConnect, weight);
                        graph.NOEdges++;
                    }
                    break;
                }
            }
            
            if (graph.isDigraph == false) {

                remainingEdge = edgeNum - (graph.NOEdges / 2);// decrease number of edge
            } else {

                remainingEdge = edgeNum - graph.NOEdges;// decrease number of edge
            }
            
        }
        // loop again on rem edges
        for (int i = 0; i < remainingEdge; i++) {
            // random vertices
            randomS = (int) (Math.random() * verticeNum);
            sourceVert = new Vertex(randomS);
            randomD = (int) (Math.random() * verticeNum);
            targetVert = new Vertex(randomD);

            // if isConnected is true, choose different vertices
            if (graph.getAdjMatrix()[randomS][randomD] != null) {
                i--;
            } // if not connectend, connect it by addEdge function shown below
            else {
                // random waight
                weight = (int) (Math.random() * 20 + 1);
                graph.addEdge(sourceVert, targetVert, weight);
                graph.getAdjMatrix()[randomS][randomD].getsVer().setIsVisited(true);
                graph.getAdjMatrix()[randomS][randomD].getdVer().setIsVisited(true);

            }
        }
        this.printMakeGraph();
         
        return graph;

    }
    // ------------------------------------------------------------------------------------------------------

    // ------------------------------ printMakeGraph
    // --------------------------------------------------------------
    public void printMakeGraph() {
        for (Edge[] adjMatrix1 : adjMatrix) {
            for (Edge adjMatrix11 : adjMatrix1) {
                if (adjMatrix11 != null) {
                    Edge e = adjMatrix11;
                    System.out.println("Edge from " + e.getsVer().getLabel() + " to " + e.getdVer().getLabel()
                            + " has weight " + e.getW());
                }
            }
        }
    }

    // --------------------------------------------------------------------------

    // -+-+-+-+-+-+-+-+-+-+-+-+-Requirement 1-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

    // --------------------------------ReadFromFile()----------------------------------------------
    // Given a specific graph with 10 vertices.
    // Do the following:
    // Write the definition of this graph in a text file
    // Read the file ()
    // Run the algorithm
    // Display the output of each iteration for floyed & w. algorithm and to print
    // the shortest paths with their lengths.
    // Compute the run time and print it

    // @param fileName
    // @throws FileNotFoundException
    // -------------------------------------------------------------------------------------------------------
    public void readGraphFromFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        // --------------------------IS DIAGRAPH ?----------------------------
        // is graph directed or not ?
        // if Diagraph=0 then not "false"
        // if Diagraph=1 then it's directed "true"
        int Diagraph = input.nextInt();
        if (Diagraph == 0) {
            this.setIsDigraph(false);
        } else {
            this.setIsDigraph(true);
        }
        // --------------------------------------------------------------------------------------

        // ************************************************

        // take the second line of file
        // number of vertex and edges
        int ver = input.nextInt();
        this.setNOVertices(ver);

        int edg = input.nextInt();
        this.setNOEdges(edg);
        // *********************************************
        // read the graph from the file
        while (input.hasNext()) {

            // read weight and >
            // read from letter as "source" and to letter as "destination"
            char source = input.next().charAt(0);
            char dest = input.next().charAt(0);
            int w = input.nextInt();

            // graph is directed
            // create directed edge
            if (isDigraph) {
                Vertex s = new Vertex(source, false);
                Vertex d = new Vertex(dest, false);
                // create edge between source and destination
                Edge edge = new Edge(s, d, w);

                // substracting "vertex_label[0]" fom any of source or dest letter to know
                // position
                adjMatrix[source - vertex_label[0]][dest - vertex_label[0]] = edge;
            }

            // graph is not directed
            // create 2 edges from and to
            else if (isDigraph == false) {
                Vertex s = new Vertex(source, false);
                Vertex d = new Vertex(dest, false);
                // create edge between source and destination
                Edge edgefrom = new Edge(s, d, w);
                // create edge between destination and source
                Edge edgeto = new Edge(d, s, w);

                // substracting "vertex_label[0]" fom any of source or dest letter to know
                // position
                adjMatrix[source - vertex_label[0]][dest - vertex_label[0]] = edgefrom;
                adjMatrix[dest - vertex_label[0]][source - vertex_label[0]] = edgeto;
            }

        } // end file read

        // -----------------------Print Graph From File--------------------------------
        this.printGraph();

    }// end readFromFile method

    // -*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*

    // ------------------------------------ addEdge
    // ------------------------------------------------
    private void addEdge(Vertex s, Vertex d, int w) {
        Edge edgeObj = new Edge(s, d, w);
        Edge.allEdges.add(edgeObj);

    }

    // ------------------------------------------------------------------------------------------------
    private Edge addEdgee(int s, int d, int w) {
        Edge edgeS, edgeD;
        Vertex source = new Vertex(s);
        // vertices.add(source);
        NOVertices++;
        Vertex dest = new Vertex(d);
        // vertices.add(dest);
        NOVertices++;
        edgeS = new Edge(source, dest, w);
        adjMatrix[s][d] = edgeS;
        NOEdges++;
        if (isDigraph == false && s != d) {
            edgeD = new Edge(dest, source, w);
            adjMatrix[d][s] = edgeD;
            NOEdges++;
        }
        return edgeS;
    }

    // ---------------------- addVertLabel
    // --------------------------------------------------------------
    public boolean addVertLabel(Vertex ver) {
        // loop to see is the vertex in the vertices vector
        for (int i = 0; i < vertices.size(); i++) {
            // if yes return false(no added label to vertices)
            if (ver.getLabel() == vertices.get(i).getLabel()) {
                return false;
            }
        }
        vertices.add(ver);// otherwise add the vertex
        NOVertices++;// increment number of vertices
        return true;// return true since(vertex is added)
    }

    // -------------------------------- isConnected
    // ----------------------------------------------------
    private int isConnected(ArrayList<Vertex> vertices) {
        int count = 0;// to count all vertices
        boolean coneccted[] = new boolean[vertices.size()];// array to save Visited or not
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getIsVisited() == true) {
                coneccted[i] = true;
            }
        }
        // now after count reach the vertices number check if there any un Visited
        // vertex
        if (vertices.size() == count) {
            for (int i = 0; i < vertices.size(); i++) {
                if (coneccted[i] == false) {
                    return i;// return the un Visited vertex
                }
            }
        }
        return -1;
    }

    // ----------------------------------------------------------------------------------------------------
    // ---------------------------------------- Print Graph
    // ----------------------------------------------------------
    void printGraph() {
        System.out.println("");
        System.out.println("-----********--------Read From File output-------*********---------");
        System.out.println("----------------------------Reasults--------------------------------");
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] == null) {
                    continue;
                } else {

                    System.out.println("Vertex" + "  " + adjMatrix[i][j].getsVer().getLabel() + "  " + "is connceted to"
                            + "  " + adjMatrix[i][j].getdVer().getLabel() + "  " + "with weight :"
                            + adjMatrix[i][j].getW());

                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("The adjacency matrix for the given graph is: ");
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < vertex_label.length; i++)

            System.out.print(vertex_label[i] + " ");
        System.out.println();

        for (int i = 0; i < vertex_label.length; i++) {
            System.out.print(vertex_label[i] + " ");
            for (int j = 0; j < NOVertices; j++) {

                if (adjMatrix[i][j] == null) {
                    System.out.print("0" + " ");

                } else {
                    System.out.print(adjMatrix[i][j].getW() + " ");
                }
            }
            System.out.println();

        }

    }

    // -------------------------------------------------------------------------------------------

    public int getNOVertices() {
        return NOVertices;
    }

    public void setNOVertices(int verticesNo) {
        this.NOVertices = verticesNo;
    }

    public int getNOEdges() {
        return NOEdges;
    }

    public void setNOEdges(int edgeNo) {
        this.NOEdges = edgeNo;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public Edge[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(Edge[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public boolean Charr() {
        return Charr;
    }

    public void setChar(boolean Char) {
        this.Charr = Char;
    }

    ArrayList<Vertex> getvertices() {
        return vertices;
    }

    public void setvertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

}