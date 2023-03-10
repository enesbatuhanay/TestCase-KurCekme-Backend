package backend.Service;

import backend.Contract.CurrencyListResponseModel;
import backend.Contract.CurrencyModel;
import backend.Entity.CurrencyEntity;
import backend.Mapper.CurrencyMapper;
import backend.Repository.CurrencyRepository;
import backend.ServiceImpl.ICentralBankService;
import backend.ServiceImpl.IHttpService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


@RequiredArgsConstructor
@Service

public class CentralBankService implements ICentralBankService {
    private static final String MERKEZ_BANKASI_URL = "https://www.tcmb.gov.tr/kurlar/";
    private final IHttpService httpService;
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;


    @SneakyThrows
    @Override
    public CurrencyListResponseModel getCurrencies(String date) {

        String requestUrl = MERKEZ_BANKASI_URL + date + ".xml";

        var result = httpService.getHttpXmlResult(requestUrl);
        var currencyListModels = convertStringToModel(result);
        return CurrencyListResponseModel.builder().setCurrencies(currencyListModels).build();


    }

    @SneakyThrows
    private List<CurrencyModel> convertStringToModel(String content) {

        JSONObject json = XML.toJSONObject(content);

        JSONObject currencies = json.getJSONObject("Tarih_Date");
        JSONArray jArray = currencies.getJSONArray("Currency");

        ArrayList<JSONObject> listdata = new ArrayList<>();
        List<CurrencyModel> finalModelsToSave = new ArrayList<>();

        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                listdata.add(jArray.optJSONObject(i));
            }
        }
        for (JSONObject object : listdata) {
            CurrencyModel currencyModel = new CurrencyModel();
            if (!object.get("CurrencyCode").toString().equals("")) {
                currencyModel.setCurrencyCode(object.getString("CurrencyCode"));
            }
            if (!object.get("Unit").toString().equals("")) {
                currencyModel.setUnit(object.getInt("Unit"));
            }
            if (!object.get("CurrencyName").toString().equals("")) {
                currencyModel.setCurrencyName(object.getString("CurrencyName"));
            }
            if (!object.get("ForexBuying").toString().equals("")) {
                currencyModel.setForexBuying(object.getBigDecimal("ForexBuying"));
            }
            if (!object.get("ForexSelling").toString().equals("")) {
                currencyModel.setForexSelling(object.getBigDecimal("ForexSelling"));

            }
            if (!object.get("BanknoteBuying").toString().equals("")) {
                currencyModel.setBanknoteBuying(object.getBigDecimal("BanknoteBuying"));
            }
            if (!object.get("BanknoteSelling").toString().equals("")) {
                currencyModel.setBanknoteSelling(object.getBigDecimal("BanknoteSelling"));
            }
            finalModelsToSave.add(currencyModel);

        }
        return deleteThanSaveCurrency(finalModelsToSave);


    }


    private List<CurrencyModel> deleteThanSaveCurrency(List<CurrencyModel> currencyModels) {

        List<CurrencyEntity> currencyEntities = currencyModels.stream().map(currencyMapper::toCurrencyEntity).toList();
        currencyRepository.deleteAll();
        currencyRepository.saveAll(currencyEntities);
        //zaten elimde liste oldu??u i??in listeyi tekrar dbden aratmak yerine elimdeki model listeyi geri d??n??yorum.
        return currencyModels;

    }
}




