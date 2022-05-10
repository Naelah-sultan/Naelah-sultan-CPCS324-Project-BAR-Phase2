
package cpcs324_phase2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
---------------CPCS324-Group Project- Phase 2------------------
-Implement the Floyd-Warshall algorithm to compute the distance matrix that indicates the
length of the shortest paths between every pair in the graph.

-Choose a source vertex and implement the Dijkstra algorithm to compute the length of the
shortest paths from the chosen source to the rest of the vertices. Make sure to print the shortest
paths with their lengths. 
*/

//--------Project Members------------
// Naelah Sultan Miyajan 1905313 BAR
//Rahaf Alwajeeh 1909711 BAR
//Wed abu Alhamayl 1813720 BAR
//---------------------------------------------

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int mainchoice = 0;
        int require1choice = 0;
        // double startTime = 0;
        // double finishTime = 0;
        int NOVertices = 0;// number of vertices
        int NOEdges = 0;// number of edges
        // boolean isDigraph = false; //<false>=> directet graph
        int n = 0, m = 0;

        do {
            System.out.println("--------------CPCS324 Project Part 2----------");
            System.out.println("Choose from the menu below:");
            System.out.println("> Enter 1 for Requirement 1");
            System.out.println("> Enter 2 for Requirement 2");
            System.out.println("> Enter 0 to End");
            System.out.println("----------------------------------------------");
            System.out.print("Enter Your Menu Choice: ");

            mainchoice = input.nextInt();

            if (mainchoice == 1) {
                System.out.println("---------------  Requirement 1  ---------------");
                System.out.println("Choose what's needed for requirement 1:");
                System.out.println("> Enter 1 for Graph From The File with no changes");
                System.out.println("> Enter 2 for Graph From The File +(Floyd-Warshall Algorithm)");
                System.out.println("----------------------------------------------");
                System.out.print("Enter Your Menu Choice: ");

                require1choice = input.nextInt();
                if (require1choice == 1) {
                    Graph g = new Graph();
                    File myFile = new File("ReadFromFile.txt");
                    g.readGraphFromFile(myFile);

                    System.out.println("----------------------------------------------");

                } else if (require1choice == 2) {
                    Graph g = new Graph();
                    File myFile = new File("ReadFromFile.txt");

                    g.readGraphFromFile(myFile);
                    new AllSourceSPAlg().computeFloyedWarshalAlg();
                    System.out.println("----------------------------------------------");
                }
            } else if (mainchoice == 2) {
                System.out.println("---------------  Requirement 2  ---------------");
                System.out.println("MakeGraph + (Floyd-Warshall and Dijkstra Algorithms)");
                System.out.println("");
                System.out.println(">>-----cases : (where n is the number of vertices "
                        + "and m is the number of edges:----- ");

                System.out.println("1- n=2000 , m=10000");
                System.out.println("2- n=3000 , m=15000");
                System.out.println("3- n=4000 , m=20000");
                System.out.println("4- n=5000 , m=25000");
                System.out.println("5- n=6000 , m=30000");

                System.out.println("--------------------------------------------------------------");
                System.out.print("> Enter a case you want to test: ");
                int yourTestChoice = input.nextInt();

                if (yourTestChoice < 1 || yourTestChoice > 5) {
                    System.out.println("Invalid input!");

                } else {
                    Graph g = new Graph(NOVertices, NOEdges);
                    switch (yourTestChoice) {
                        case 1:
                            n = 2000;
                            m = 10000;
                            g = new Graph(n, m);
                            break;
                        case 2:
                            n = 3000;
                            m = 15000;
                            g = new Graph(n, m);
                            break;
                        case 3:
                            n = 4000;
                            m = 20000;
                            g = new Graph(n, m);
                            break;
                        case 4:
                            n = 5000;
                            m = 25000;
                            g = new Graph(n, m);
                            break;
                        case 5:
                            n = 6000;
                            m = 30000;
                            g = new Graph(n, m);
                            break;
                        default:
                            System.out.println("you entered wrong choice try again ");

                            System.out.println("Thanks!");
                            break;
                    }

                }
                //for (int i = 0; i < 5; i++) {
                    //System.out.println("------------------Trail " + (1 + i) + " -----------------");
                    Graph graph = new Graph(n, m);
                    graph.makeGraph(n, m);
                    graph.printGraph();

                    new AllSourceSPAlg().computeFloyedWarshalAlg();
                    graph.printGraph();
                    System.out.println(
                            "------*******----------*********----------********---------*******---------********--------");
                    new SingleSourceSPAlg().computeDijkstraAlg();
                    System.out.println("----------------------------------------------");
                //}

            } else if (mainchoice == 0) {
                // Terminate
                break;
            } else {
                System.out.println("\n-- Wrong input, please try again --\n");
            }

        } while (true);
        System.out.println("\n-----------------Thnak You ----------------------");

    }// end main

}
