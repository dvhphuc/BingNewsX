package service.FinanceService;

import model.Stock;
import service.IService;
import service.mapper.IModelMapper;

import java.util.List;

public class StockService implements IService<Stock> {
    @Override
    public List<Stock> getAll() throws Exception {
        IModelMapper<Stock> stockMapper = new ;
        return null;
    }
}
