package textualmold9830;

public class PreferncesData {
    public int challenges = 0;

    public  boolean onlineMode = true;
    public  String serverName = "Nik-MPPDJarServer";
    public  boolean useCustomRelay = false;
    public  String customRelayAdress = "";
    public  int customRelayPort = 0;
    public  boolean music = false;

    public PreferncesData() {
    }

    public PreferncesData(int challenges, boolean onlineMode, String serverName, boolean useCustomRelay, String customRelayAdress, int customRelayPort, boolean music) {
        this.challenges = challenges;
        this.onlineMode = onlineMode;
        this.serverName = serverName;
        this.useCustomRelay = useCustomRelay;
        this.customRelayAdress = customRelayAdress;
        this.customRelayPort = customRelayPort;
        this.music = music;
    }
}
