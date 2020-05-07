package sandbox.Service;

import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;

import java.util.List;

public interface StockService {

    List<Stock> getStocksInfoFromWeb();

    void addStocksInfoToDataBase(List<Stock> listStock);

    Stock getStockById(Long id);

    List<TradingCompany> getTopFiveHighestValueStocks();

    List<TradingCompany> getTopFiveTradingCompaniesWithGreatestChangePercentInStockValue();
}
