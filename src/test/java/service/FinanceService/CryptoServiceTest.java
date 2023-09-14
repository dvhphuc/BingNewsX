package service.FinanceService;

import org.junit.jupiter.api.Test;
import service.mapper.CryptoMapperService;

import static org.junit.jupiter.api.Assertions.*;

class CryptoServiceTest {

    @Test
    void testGetAll() throws Exception {
        var cryptoMapper = new CryptoMapperService();
        var cryptoService = new CryptoService(cryptoMapper);
        var cryptos = cryptoService.getAll();
        System.out.println(cryptos.get(0).getSymbol());
    }
}