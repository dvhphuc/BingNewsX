package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Channel {
    private String channelID;
    private HashMap<String, String> mapSrcDES;

    @JsonProperty("channelId")
    public String getChannelID() { return channelID; }
    @JsonProperty("channelId")
    public void setChannelID(String value) { this.channelID = value; }

    @JsonProperty("mapSrcDes")
    public HashMap<String, String> getMapSrcDES() { return mapSrcDES; }
    @JsonProperty("mapSrcDes")
    public void setMapSrcDES(HashMap<String, String> value) { this.mapSrcDES = value; }
}