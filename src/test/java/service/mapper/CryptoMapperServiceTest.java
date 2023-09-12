package service.mapper;

import configuration.Configuration;
import org.junit.jupiter.api.Test;
import service.ReaderService;

import static org.junit.jupiter.api.Assertions.*;

class CryptoMapperServiceTest {

    @Test
    void testMapObject() throws Exception {
        var cfg = new Configuration();
        var cryptoMapperService = new CryptoMapperService();
        var crypto = ReaderService.getCryptoInfo(cfg.getFinancialConfig().getCryptos()).getJSONObject(0);
        var mappedCrypto = cryptoMapperService.mapObject(crypto, cfg.getFinancialConfig().getCryptos().getMapper());
        System.out.println(mappedCrypto.getName());
        System.out.println(mappedCrypto.getSymbol());
        System.out.println(mappedCrypto.getPrice());
        System.out.println(mappedCrypto.getPercentChange24h());
        System.out.println(mappedCrypto.getLogoUrl());
        assert (mappedCrypto != null);
    }

    @Test
    void testMapObjects() throws Exception {
        var cfg = new Configuration();
        var cryptoMapperService = new CryptoMapperService();
        var cryptos = ReaderService.getCryptoInfo(cfg.getFinancialConfig().getCryptos());
        var mappedCryptos = cryptoMapperService.mapObjects(cryptos, cfg.getFinancialConfig().getCryptos().getMapper());
        System.out.println(mappedCryptos.get(0).getName());
        assert (mappedCryptos != null);
    }
}