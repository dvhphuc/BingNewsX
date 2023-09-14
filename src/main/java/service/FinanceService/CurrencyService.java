package service.FinanceService;

import configuration.Configuration;
import configuration.financial.CurExchangesCfg;
import model.CurrencyExchange;
import service.IService;
import service.ReaderService;
import service.mapper.CurrencyExchangeMapperService;
import service.mapper.IModelMapper;

import java.util.List;

public class CurrencyService implements IService<CurrencyExchange> {
    private CurExchangesCfg curExchangesCfg;
    private CurrencyExchangeMapperService currencyMapper;

    public CurrencyService() throws Exception {
        curExchangesCfg = new Configuration().getFinancialConfig().getCurExchanges();
        currencyMapper = new CurrencyExchangeMapperService();
    }

    @Override
    public List<CurrencyExchange> getAll() throws Exception {
        var mapper = curExchangesCfg.getMapper();
        var items = ReaderService.getCurrencyExchange(curExchangesCfg);
        return currencyMapper.mapObjects(items, mapper);
    }
}
