package ConsistentHashing;

public class CircularQueue {
    Cell[] CircularQueue;
    public int size;
    public CircularQueue(int size){
        this.size = size;
        CircularQueue = new Cell[size];
        for(int i = 0; i < size; i++){
            Cell cellObj = new Cell(null, null);
            CircularQueue[i] = cellObj;
        }
    }

    public int generateIndexForKey(String key){
        System.out.print("Generating hash code...\t");
        int hashValues = key.hashCode();
        int queuePosition = hashValues % size;
        return queuePosition;
    }

    public int resolveIndexConflict(int index){
        System.out.print("Resolving conflicts...\t");
        System.out.println(CircularQueue[index].id);
        while(CircularQueue[index].id != null){
            System.out.println(CircularQueue[index].id);
            index += 1;
            index = index % size;
        }
        return index;
    }

    public int mapKeyOnCircularQueue(String type, String key){
        System.out.print("Mapping Keys...\t");
        int queuePosition = generateIndexForKey(key);
        queuePosition = resolveIndexConflict(queuePosition);
        CircularQueue[queuePosition] = new Cell(type, key);
        System.out.println("Key mapped successfully..!!"); 
        return queuePosition;
    }

    public int getKeyIndexOnCircularQueue(String key){
        int index = resolveIndexConflict(generateIndexForKey(key));
        return index;
    }

    public void printCircularQueue(){
        System.out.println("Printing Circular Queue.");
        for(int i = 0; i < size; i++){
            if(CircularQueue[i].id != null){
                System.out.print(i + " ");
                System.out.print(CircularQueue[i].name + " ");
                System.out.println(CircularQueue[i].id);
            }            
        }
    }

    public void deleteKeyFromCircularQueue(String key){
        int index = getKeyIndexOnCircularQueue(key);
        CircularQueue[index] = null;
        System.out.println("Key deleted from Queue.");
    }

    public int getNextServer(String key, int ind){
        int index = ind;
        System.out.println("Finding server for User Key : " + key);
        // System.out.println("Index : " + ind);
        while(CircularQueue[index].name != "ServerKey"){
            // System.out.print(CircularQueue[index].id + " ");
            // System.out.println(CircularQueue[index].name);
            index += 1;
            index = index % size;
        }
        System.out.print("Match Found : " + CircularQueue[index].id + "\t" );
        System.out.println(CircularQueue[index].name);
        return index;
    }
}
