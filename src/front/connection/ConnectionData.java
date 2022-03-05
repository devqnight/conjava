package front.connection;

public class ConnectionData {
    private String url;
    private int port;

    private static ConnectionData instance;

    public static ConnectionData getInstance(){
        if(instance == null)
            instance = new ConnectionData();
        return instance;
    }

    public ConnectionData(){
        this.url = "";
        this.setPort(0);
    }

    public String getUrl() {
        return url;
    }

    public void setString(String url){
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean connect(){
        
        return false;
    }
}
