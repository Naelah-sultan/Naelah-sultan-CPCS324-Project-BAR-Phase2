
package cpcs324_phase2;

public class AllSourceSPAlg extends ShortestPathAlgorithm {



    public AllSourceSPAlg() {
    }



  public  void computeFloyedWarshalAlg() {
       double StartTime = System.nanoTime();
        int numOfVertices = Graph.vertices.size();



   //k is number of floyed trials
        for (int k = 0; k < numOfVertices; k++) {
            for (int i = 0; i < numOfVertices; i++) {
                for (int j = 0; j < numOfVertices; j++) {

                    //each cell in algorithm where the will be operated on
                    int cella = Graph.adjMatrix[i][j].w;
                    int cellb = (Graph.adjMatrix[i][k].w);
                    int cellc = (Graph.adjMatrix[k][j].w);

                    Graph.adjMatrix[i][j].w = Math.min(cella, cellb + cellc);
                

                } 
            } 
            
            System.out.println("\n------------ "+ "trial"+ (k+1) + " --------------------");
            
                    //finish time of the algorithm
        double FinishTime = System.nanoTime();
        //print the total time consumed by the algorithm
        System.out.println("Total runtime of Floyd Warshall Algorithm: " + (FinishTime - StartTime) + " ns.");
        // Print the shortest distance matrix
        //ethir by char version or int version
        if (Graph.Charr == true) {
            System.out.println("\n******************************************" + "Final result" + "******************************************");
          printGraph(Graph.adjMatrix);
              System.out.println("Total runtime of Floyd Warshall Algorithm: " + (FinishTime - StartTime) + " ns.");
        }
        }
        }
    
      
   
           
    
    

    /**
     * print graph with char label
     *
     * @param graph
     */
    public void printGraph(Edge[][] adjMatrix) {
     
        int verticesNo = adjMatrix.length;
	 
          System.out.print("   ");
        for (int i = 0; i < verticesNo; i++) {
               System.out.printf( (char) (i + 65) + " ");
        }
          System.out.println();

    	
        for (int i = 0; i < verticesNo; i++) {
              System.out.print((char) (i + 65)  + " ");
            for (int j = 0; j < verticesNo; j++) {
                if (adjMatrix[i][j] == null) {
                      System.out.print("∞"+ " ");
                } else {
                     System.out.printf(adjMatrix[i][j]+" ");
                }
            }
            System.out.println();
        }
          System.out.println("\n");
    
   
   
         System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("The adjacency matrix for Floyed-Warshal Alg: ");
            System.out.println();
            System.out.print("  ");
        
        int verticesNum =adjMatrix.length;
    	
          System.out.print("   ");
        for (int i = 0; i < verticesNum; i++) {
            System.out.printf( i + " ");
        }
        System.out.println();

        for (int i = 0; i < verticesNum; i++) {
               System.out.print(i  + " ");
            for (int j = 0; j < verticesNum; j++) {
                if (adjMatrix[i][j] == null) {
                      System.out.print("∞"+ " ");
                } else {
                       System.out.printf(adjMatrix[i][j]+" ");
                }
            }
              System.out.println();
        }
        System.out.println("\n");
    }

  
       
        
    }
    

