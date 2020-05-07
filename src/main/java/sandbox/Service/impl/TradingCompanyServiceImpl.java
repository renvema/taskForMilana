package sandbox.Service.impl;

import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;
import sandbox.Service.TradingCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TradingCompanyServiceImpl implements TradingCompanyService {

    @Override
    public List<TradingCompany> getInfoAboutCompany(List<Stock> listStock) {
        return null;
    }
}
