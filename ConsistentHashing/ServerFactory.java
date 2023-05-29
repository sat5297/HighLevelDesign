package ConsistentHashing;

public class ServerFactory {
    static Servers getServerObject(String serverID){
        if("1".equals(serverID)){
            return new Server1();
        }
        else if("2".equals(serverID)){
            return new Server2();
        }
        else if("3".equals(serverID)){
            return new Server3();
        }
        else if("4".equals(serverID)){
            return new Server4();
        }
        return new NULLServer();
    }
}
