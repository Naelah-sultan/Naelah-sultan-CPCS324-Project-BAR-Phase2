
package cpcs324_phase2;

import java.util.ArrayList;

public class Vertex {

    char label;
    int position;
    boolean isVisited;

    
    public Vertex(){

    }
    public Vertex(int position){
        this.position = position;
    }
       public Vertex(char label){
        this.label = label;
    }
       
        public Vertex(char label, boolean isVisited) {
        this.label = label;
        this.isVisited = isVisited; 
    }
        
    public Vertex(int position, char label){
        this.position = position;
        this.label = label;
    }



    public void setLabel(char label) {
        this.label = label;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public char getLabel() {
        return label;
    }

    public int getPosition() {
        return position;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public int getVertPos() {
        return position;
    }

    boolean getIsVisited() {
              return isVisited;

    }
    
}
