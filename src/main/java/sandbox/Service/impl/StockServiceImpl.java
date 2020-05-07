package sandbox.Service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;
import sandbox.Repository.StockRepository;
import sandbox.Service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        HttpGet request = new HttpGet(STOCKS_API_ENDPOINT
                + "ref-data/symbols?" + "token=" + TOKEN);


        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                listStock = objectMapper.readValue(EntityUtils.toString(entity),
                        new TypeReference<List<Stock>>() {
                        });
            }
        } catch (IOException e) {
            log.error("Can't get data from web!");
            throw new RuntimeException("Can't get data from web!", e);
        }
        return listStock;
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
        return Arrays.asList(listStock)
                .stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<TradingCompany> getTopFiveTradingCompaniesWithGreatestChangePercentInStockValue() {
        return null;
    }
}
