package backend.Contract;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class CurrencyModel {
    private String currencyCode;

    private int unit;

    private String currencyName;

    private BigDecimal forexBuying;

    private BigDecimal forexSelling;

    private BigDecimal banknoteBuying;
    private BigDecimal banknoteSelling;
}
