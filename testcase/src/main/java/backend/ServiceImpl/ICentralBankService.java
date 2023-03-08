package backend.ServiceImpl;


import backend.Contract.CurrencyListResponseModel;


public interface ICentralBankService {


    CurrencyListResponseModel getCurrencies(String date);
}
