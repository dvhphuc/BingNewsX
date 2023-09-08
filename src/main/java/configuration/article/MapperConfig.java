package configuration.article;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

public class MapperConfig {
    private List<Channel> channels;

    @JsonProperty("channels")
    public List<Channel> getChannels() { return channels; }
    @JsonProperty("channels")
    public void setChannels(List<Channel> value) { this.channels = value; }

    public Channel getChannelById(String channelID) {
        for (Channel channel : channels) {
            if (channel.getChannelID().equals(channelID)) {
                return channel;
            }
        }
        return null;
    }
}