
package cpcs324_phase2;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    Graph ggraph;
    
    public SingleSourceSPAlg(){

    }

    
  
public void computeDijkstraAlg(){
    
        double StartTime = System.nanoTime();
        Edge graph[][] = Graph.adjMatrix;
 

        int graphL = graph.length;
        final int inf = Integer.MAX_VALUE;
     
        boolean[] isVisited = new boolean[graphL ];
        int dist[] = new int[graphL ];

        for (int i = 0; i < graphL ; i++) {
            isVisited[i] = false;
            dist[i] = inf ;
        }
       dist[0] = 0;


    //----------------------------------------------------------------------------------------
        for (int i = 0; i < graphL ; i++) {
            
            int index = 0;
            int smallestDistance = inf ;
            for (int j = 0; j < graphL ; j++) {
                if (isVisited[j] != true && dist[j] < smallestDistance) {
                  smallestDistance = dist[j];
                     index = j; 
                }
            }

            // Set u as visited
            isVisited[ index] = true;

     
            for (int k = 0;k  < graphL ;k ++) {
                if (graph[ index][k ] == null) {
                    continue; 
                }
                if (isVisited[k ] == false) {
                    if (dist[ index] + graph[ index][k ].getW() < dist[k ]) {
                        dist[k ] = dist[ index] + graph[ index][k ].getW();
                       

                    }
                }
            }
        }
       
        double FinishTime = System.nanoTime();

        System.out.println("Total runtime of Dijkstra Algorithm: " + (FinishTime - StartTime) + " ns.");
      
       
            System.out.println("\n////////////////////////////Dijkstra Algorithm//////////////////////////");
          
            for (int i = 1; i <graphL ; i++) {
               System.out.println("  > Shortest Distance from 'A' to '" + (char) (i + 65) + "' is =" + dist[i]);
            }
            System.out.println();
        System.out.println("Total runtime of Dijkstra Algorithm: " + (FinishTime - StartTime) + " ns.");
        
  
}
    
    
    
    }
    
    
    
    
    
    
    
    
    
    

