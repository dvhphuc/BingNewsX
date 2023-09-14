package configuration.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialConfig {
    private CryptosCfg stocks;
    private CryptosCfg cryptos;
    private CurExchangesCfg curExchanges;

    @JsonProperty("stocks")
    public CryptosCfg getStocks() { return stocks; }
    @JsonProperty("stocks")
    public void setStocks(CryptosCfg value) { this.stocks = value; }

    @JsonProperty("cryptos")
    public CryptosCfg getCryptos() { return cryptos; }
    @JsonProperty("cryptos")
    public void setCryptos(CryptosCfg value) { this.cryptos = value; }

    @JsonProperty("cur_exchanges")
    public CurExchangesCfg getCurExchanges() { return curExchanges; }
    @JsonProperty("cur_exchanges")
    public void setCurExchanges(CurExchangesCfg value) { this.curExchanges = value; }
}
