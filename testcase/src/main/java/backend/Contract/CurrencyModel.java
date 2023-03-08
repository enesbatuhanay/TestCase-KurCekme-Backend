package backend.Contract;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class CurrencyModel {

    private static final long serialVersionUID = 2412778616561962509L;

    private String currencyCode;

    private int unit;

    private String currencyName;

    private BigDecimal forexBuying;

    private BigDecimal forexSelling;

    private BigDecimal banknoteBuying;

    private BigDecimal banknoteSelling;
}
