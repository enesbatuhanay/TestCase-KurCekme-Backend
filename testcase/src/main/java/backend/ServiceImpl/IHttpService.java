package backend.ServiceImpl;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface IHttpService {
    String getHttpXmlResult(String targetUrl) throws IOException, ParserConfigurationException, SAXException;


}
