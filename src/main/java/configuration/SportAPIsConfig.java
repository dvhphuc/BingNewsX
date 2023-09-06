package configuration;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class SportAPIsConfig {
    private List<SportAPI> sportapis;

    @JsonProperty("sportapis")
    public List<SportAPI> getSportapis() { return sportapis; }
    @JsonProperty("sportapis")
    public void setSportapis(List<SportAPI> value) { this.sportapis = value; }
}