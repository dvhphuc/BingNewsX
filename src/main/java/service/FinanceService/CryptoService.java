package service.FinanceService;

import configuration.Configuration;
import configuration.financial.CryptosCfg;
import model.Crypto;
import service.IService;
import service.ReaderService;
import service.mapper.CryptoMapperService;
import service.mapper.IModelMapper;

import java.util.List;

public class CryptoService implements IService<Crypto> {
    private CryptosCfg cryptosCfg;
    private IModelMapper<Crypto> cryptoMapper;
    public CryptoService(IModelMapper _cryptoMapper) throws Exception {
        cryptosCfg = new Configuration().getFinancialConfig().getCryptos();
        cryptoMapper = _cryptoMapper;
    }
    @Override
    public List<Crypto> getAll() throws Exception {
        var cryptos = ReaderService.getCryptoInfo(cryptosCfg);
        return cryptoMapper.mapObjects(cryptos, cryptosCfg.getMapper());
    }
}
