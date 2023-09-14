package service.FinanceService;

import configuration.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyServiceTest {

    @Test
    void testGetAll() throws Exception {
        var cfg = new Configuration();
        var currencyCfg = cfg.getFinancialConfig().getCurExchanges();
        var currencyService = new CurrencyService();
        var currencyExchanges = currencyService.getAll();
        System.out.println(currencyExchanges.get(0).getFromToSymbol());
        assert currencyExchanges.size() > 0;
    }
}