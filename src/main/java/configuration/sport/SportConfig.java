package configuration.sport;


import com.fasterxml.jackson.annotation.*;

import java.util.List;

public class SportConfig {
    private List<Sportapi> sportapis;

    @JsonProperty("sportapis")
    public List<Sportapi> getSportapis() { return sportapis; }
    @JsonProperty("sportapis")
    public void setSportapis(List<Sportapi> value) { this.sportapis = value; }
}
