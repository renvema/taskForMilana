package sandbox.Service;

import sandbox.Model.Stock;
import sandbox.Model.TradingCompany;

import java.util.List;

public interface TradingCompanyService {
    List<TradingCompany> getInfoAboutCompany(List<Stock> listStock);
}
