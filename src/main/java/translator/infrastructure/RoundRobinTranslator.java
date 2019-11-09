package translator.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpRequestBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import translator.exception.TranslatorException;

@Component("roundRobinTranslator")
public class RoundRobinTranslator extends TranslatorImpl {

  @Value("${yandex.api_key}")
  private String yandexApiKey;

  private List<TranslatorImpl> impl = new ArrayList<>();
  private Integer i = 0;

  @Override
  protected HttpRequestBase getHttpRequest(String from, String to, String text, String encodedText) {
    if (impl.isEmpty()) {
      YandexTranslator yandex = new YandexTranslator();
      yandex.setApiKey(yandexApiKey);
      impl.add(yandex);
      impl.add(new MyMemoryTranslator());
    }
    TranslatorImpl translator = impl.get(i);
    i = (i + 1) % impl.size();
    return translator.getHttpRequest(from, to, text, encodedText);
  }

  @Override
  protected String getTranslationFrom(String responseAsStr) {
    try {
      for (TranslatorImpl translator : impl) {
        try {
          return translator.getTranslationFrom(responseAsStr);
        } catch(TranslatorException e) {
          // Do nothing
        }
      }
      throw new TranslatorException("Failed processing " + responseAsStr);
    } catch (Exception e) {
      throw new TranslatorException("Failed processing " + responseAsStr, e);
    }
  }
}
