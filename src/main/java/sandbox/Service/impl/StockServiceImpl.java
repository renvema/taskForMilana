package sandbox.Service.impl;

import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;
import sandbox.Repository.StockRepository;
import sandbox.Service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    private List<Stock> listStock = new ArrayList<>();

    public static final String STOCKS_API_ENDPOINT = "https://sandbox.iexapis.com/stable/";
    public static final String TOKEN = "Tpk_ee567917a6b640bb8602834c9d30e571";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Stock> getStocksInfoFromWeb() {
        return null;
    }

    @Override
    public void addStocksInfoToDataBase(List<Stock> listStock) {
        stockRepository.saveAll(listStock);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.getOne(id);
    }

    @Override
    public List<TradingCompany> getTopFiveHighestValueStocks() {
        return null;
    }

    @Override
    public List<TradingCompany> getTopFiveTradingCompaniesWithGreatestChangePercentInStockValue() {
        return null;
    }
}
