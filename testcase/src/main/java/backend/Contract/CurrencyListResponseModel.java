package backend.Contract;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "set")
public class CurrencyListResponseModel {

    List<CurrencyModel> currencies;

}
