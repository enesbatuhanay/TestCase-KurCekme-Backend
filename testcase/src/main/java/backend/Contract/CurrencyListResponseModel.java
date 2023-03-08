package backend.Contract;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "set")
public class CurrencyListResponseModel {
    private static final long serialVersionUID = -4628149624970811772L;

    List<CurrencyModel> currencies;

}
