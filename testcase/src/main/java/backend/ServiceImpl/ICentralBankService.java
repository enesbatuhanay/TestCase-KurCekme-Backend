package backend.ServiceImpl;


import backend.Contract.CurrencyListResponseModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ICentralBankService {


    CurrencyListResponseModel getCurrencies(String date);
}
