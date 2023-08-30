package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MapperConfig {
    private List<Channel> channels;

    @JsonProperty("channels")
    public List<Channel> getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(List<Channel> value) {
        this.channels = value;
    }

    public Channel getChannelById(String name) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                return channel;
            }
        }
        return null;
    }
}
