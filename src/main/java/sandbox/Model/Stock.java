package sandbox.Model;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Proxy(lazy = false)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String exchange;
    private String name;
    private String date;
    private String type;
    private String iexId;
    private String region;
    private String currency;
    private Boolean isEnabled;
    private String figi;
    private Long cik;
    @OneToOne
    private TradingCompany tradingCompany;
}
