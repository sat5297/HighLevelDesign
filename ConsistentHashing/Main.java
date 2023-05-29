package ConsistentHashing;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(20);

        String[] generatedUserKeys = new String[10];
        HashMap < Integer, Integer > mapUserKeyIndex = new HashMap<>(20, 1.0f);

        System.out.println("Mapping User Keys on the Circular Queue.");
        for(int i = 0; i < 10; i++){
            int randomUserID = ThreadLocalRandom.current().nextInt(1, 10000);
            int index = circularQueue.mapKeyOnCircularQueue("UserKey",String.valueOf(randomUserID));
            generatedUserKeys[i] = String.valueOf(randomUserID);   
            mapUserKeyIndex.put(randomUserID, index);
        }

        System.out.println("Mapping Servers on the Circular Queue.");
        for(int i = 0; i < 4; i++){
            int randomUserID = ThreadLocalRandom.current().nextInt(1, 10000);
            circularQueue.mapKeyOnCircularQueue("ServerKey",String.valueOf(randomUserID));
        }

        circularQueue.printCircularQueue();
        System.out.println(mapUserKeyIndex);

        for(int i = 0; i < 10; i++){
            System.out.println("Checking for user key : " + generatedUserKeys[i]);
            System.out.println(circularQueue.getNextServer(generatedUserKeys[i] ,mapUserKeyIndex.get(Integer.parseInt(generatedUserKeys[i]))) + "\n");
        }

    }
}
