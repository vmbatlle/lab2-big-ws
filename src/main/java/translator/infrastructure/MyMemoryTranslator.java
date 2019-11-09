package translator.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import translator.exception.TranslatorException;

import translator.infrastructure.MyMemoryResponse;

@Component("myMemoryTranslator")
public class MyMemoryTranslator extends TranslatorImpl {

  private ObjectMapper om = new ObjectMapper();

  @Override
  protected HttpRequestBase getHttpRequest(String from, String to, String text, String encodedText) {
    String uri = UriComponentsBuilder.fromHttpUrl("https://api.mymemory.translated.net/get")
            .queryParam("langpair", from + "|" + to)
            .queryParam("q", encodedText).toUriString();
    return new HttpGet(uri);
  }

  @Override
  protected String getTranslationFrom(String responseAsStr) {
    try {
      return (String) om.readValue(responseAsStr, MyMemoryResponse.class)
          .getResponseData()
          .getTranslatedText();
    } catch (Exception e) {
      throw new TranslatorException("Failed processing " + responseAsStr, e);
    }
  }

}
