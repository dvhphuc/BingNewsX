package configuration;

import java.util.HashMap;

public class Channel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getMapSrcDes() {
        return mapSrcDes;
    }

    public void setMapSrcDes(HashMap<String, String> mapSrcDes) {
        this.mapSrcDes = mapSrcDes;
    }

    private HashMap<String, String> mapSrcDes = new HashMap();
}
