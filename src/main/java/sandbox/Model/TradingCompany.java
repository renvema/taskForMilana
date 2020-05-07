package sandbox.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Data
@Proxy(lazy = false)
public class TradingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String calculationPrice;
    private Long open;
    private Long openTime;
    private String openSource;
    private Double close;
    private Long closeTime;
    private String closeSource;
    private Double high;
    private Long highTime;
    private String highSource;
    private Double low;
    private Long lowTime;
    private String lowSource;
    private Double latestPrice;
    private String latestSource;
    private String latestTime;
    private Long latestUpdate;
    private Long latestVolume;
    private Double iexRealtimePrice;
    private Long iexRealtimeSize;
    private Long iexLastUpdated;
    private Double delayedPrice;
    private Long delayedPriceTime;
    private Double oddLotDelayedPrice;
    private Long oddLotDelayedPriceTime;
    private Double extendedPrice;
    private Double extendedChange;
    private Double extendedChangePercent;
    private Long extendedPriceTime;
    private Double previousClose;
    private Long previousVolume;
    private Double change;
    private Double changePercent;
    private Long volume;
    private Double iexMarketPercent;
    private Long iexVolume;
    private Long avgTotalVolume;
    private Double iexBidPrice;
    private Long iexBidSize;
    private Double iexAskPrice;
    private Long iexAskSize;
    private Double iexOpen;
    private Long iexOpenTime;
    private Double iexClose;
    private Long iexCloseTime;
    private Long marketCap;
    private Double peRatio;
    private Double week52High;
    private Double week52Low;
    private Double ytdChange;
    private Long lastTradeTime;
    private Boolean isUSMarketOpen;
    @OneToOne
    private Stock stock;
}
