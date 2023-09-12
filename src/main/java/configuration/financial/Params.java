package configuration.financial;

import com.fasterxml.jackson.annotation.*;

public class Params {
    private String referenceCurrencyUUID;
    private String timePeriod;
    private String tiers0;
    private String orderBy;
    private String orderDirection;
    private String limit;
    private String offset;

    @JsonProperty("referenceCurrencyUuid")
    public String getReferenceCurrencyUUID() { return referenceCurrencyUUID; }
    @JsonProperty("referenceCurrencyUuid")
    public void setReferenceCurrencyUUID(String value) { this.referenceCurrencyUUID = value; }

    @JsonProperty("timePeriod")
    public String getTimePeriod() { return timePeriod; }
    @JsonProperty("timePeriod")
    public void setTimePeriod(String value) { this.timePeriod = value; }

    @JsonProperty("tiers[0]")
    public String getTiers0() { return tiers0; }
    @JsonProperty("tiers[0]")
    public void setTiers0(String value) { this.tiers0 = value; }

    @JsonProperty("orderBy")
    public String getOrderBy() { return orderBy; }
    @JsonProperty("orderBy")
    public void setOrderBy(String value) { this.orderBy = value; }

    @JsonProperty("orderDirection")
    public String getOrderDirection() { return orderDirection; }
    @JsonProperty("orderDirection")
    public void setOrderDirection(String value) { this.orderDirection = value; }

    @JsonProperty("limit")
    public String getLimit() { return limit; }
    @JsonProperty("limit")
    public void setLimit(String value) { this.limit = value; }

    @JsonProperty("offset")
    public String getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(String value) { this.offset = value; }
}
