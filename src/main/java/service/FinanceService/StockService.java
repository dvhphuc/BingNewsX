package service.FinanceService;

import configuration.Configuration;
import configuration.financial.CryptosCfg;
import model.Stock;
import service.IService;
import service.mapper.IModelMapper;
import service.mapper.StockMapperService;

import java.util.List;

public class StockService implements IService<Stock> {
    private CryptosCfg stockCfg;

    public StockService() throws Exception {
        stockCfg = new Configuration().getFinancialConfig().getStocks();
    }

    @Override
    public List<Stock> getAll() throws Exception {
        IModelMapper<Stock> stockMapper = new StockMapperService();

        return null;
    }
}
