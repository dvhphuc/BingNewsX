package configuration.topnews;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

public class EndpointConfig {
    private List<Endpoint> endpoints;

    @JsonProperty("endpoints")
    public List<Endpoint> getEndpoints() { return endpoints; }
    @JsonProperty("endpoints")
    public void setEndpoints(List<Endpoint> value) { this.endpoints = value; }
}