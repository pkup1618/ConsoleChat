import java.net.Inet4Address;
import java.net.UnknownHostException;

public class InformationContainer {

    private static InformationContainer uniqueInstance;
    private InformationContainer() {}
    public static InformationContainer getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InformationContainer();
        }
        return uniqueInstance;
    }

    public static String GetIpFromSystem() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }


    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        if (port < 19000)
        {
            this.port = Math.max(port, 18000);
        }
        else
        {
            this.port = 19000;
        }
    }


}
