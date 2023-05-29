package ConsistentHashing;

public class Cell {
    String name;
    String id;

    Cell(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    } 

    public void setName(String name){
        this.name = name;
    }

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id = id;
    }
}
