package sandbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sandbox.Model.Stock;
import sandbox.Service.StockService;
import sandbox.Service.TradingCompanyService;

import java.util.List;


@Slf4j
@SpringBootApplication
public class TradingApplication {

    private static TradingCompanyService tradingCompanyService;
    private static StockService stockService;

    public TradingApplication(StockService stockService, TradingCompanyService tradingCompanyService) {
        this.stockService = stockService;
        this.tradingCompanyService = tradingCompanyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TradingApplication.class, args);
        log.info("Spring application started successful");
        List<Stock> listStock = stockService.getStocksInfoFromWeb();
        stockService.addStocksInfoToDataBase(listStock);
        log.info("Data symbols/names/state for each trading company added to DB");

    }
}
