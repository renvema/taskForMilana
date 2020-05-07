package sandbox.Service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;
import sandbox.Service.TradingCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static sandbox.Service.impl.StockServiceImpl.STOCKS_API_ENDPOINT;
import static sandbox.Service.impl.StockServiceImpl.TOKEN;

@Slf4j
@Service
public class TradingCompanyServiceImpl implements TradingCompanyService {

    private ConcurrentLinkedQueue<String> companyNamesSet = new ConcurrentLinkedQueue<>();
    private List<TradingCompany> listCompany = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<TradingCompany> getInfoAboutCompany(List<Stock> listStock) {
        for (Stock stock : listStock) {
            String companyName = stock.getSymbol();
            companyNamesSet.add(companyName);
            companyName = companyNamesSet.poll();
            if (companyName != null) {
                HttpGet request = new HttpGet(STOCKS_API_ENDPOINT
                        + "stock/" + companyName + "/quote?" + "token=" + TOKEN);
                try (CloseableHttpClient httpClient = HttpClients.createDefault();
                     CloseableHttpResponse response = httpClient.execute(request)) {

                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        listCompany = objectMapper.readValue(EntityUtils.toString(entity),
                                new TypeReference<List<TradingCompany>>() {
                                });
                    }
                } catch (IOException e) {
                    log.error("Can't get data from web!");
                    throw new RuntimeException("Can't get data from web!", e);
                }
            }
        }
        return listCompany;
    }
}
