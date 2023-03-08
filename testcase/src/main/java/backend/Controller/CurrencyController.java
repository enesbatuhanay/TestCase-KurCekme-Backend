package backend.Controller;


import backend.Contract.CurrencyListResponseModel;
import backend.ServiceImpl.ICentralBankService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class CurrencyController {
    private final ICentralBankService centralBankService;
    @SneakyThrows
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/api/currency/{YYYYmm}/{ddmmYYYY}")
    public CurrencyListResponseModel getCurrencies(@PathVariable String YYYYmm, @PathVariable String ddmmYYYY) {
       return centralBankService.getCurrencies(YYYYmm+"/"+ddmmYYYY);
    }


}
