package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  /**
   * Calculates minimum edit distance for two strings
   * @see https://www.programcreek.com/2013/12/edit-distance-in-java/#:~:targetText=Edit%20Distance%20in%20Java,%3A%20replace%2C%20delete%2C%20insert.
   * @param word1  a string
   * @param word2  another string
   * @return minimum edit distance
   */
  private static int minDistance(String word1, String word2) {
    
    int len1 = word1.length();
    int len2 = word2.length();

    // len1+1, len2+1, because finally return dp[len1][len2]
    int[][] dp = new int[len1 + 1][len2 + 1];
   
    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
   
    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }
   
    //iterate though, and check last char
    for (int i = 0; i < len1; i++) {
      char c1 = word1.charAt(i);
      for (int j = 0; j < len2; j++) {
        char c2 = word2.charAt(j);
   
        //if last two chars equal
        if (c1 == c2) {
          //update dp value for +1 length
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          int replace = dp[i][j] + 1;
          int insert = dp[i][j + 1] + 1;
          int delete = dp[i + 1][j] + 1;
   
          int min = replace > insert ? insert : replace;
          min = delete > min ? min : delete;
          dp[i + 1][j + 1] = min;
        }
      }
    }
   
    return dp[len1][len2];
  }

  private static Integer compareStrings(String s1, String s2) {
    String[] words_s1 = s1.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    String[] words_s2 = s2.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    Integer min = Math.min(words_s1.length, words_s2.length);
    Integer count = 0;
    for (int i = 1; i < min; i++) {
      if (minDistance(words_s1[i], words_s2[i]) > 2){
        count++;
      }
    }
    return count;
  }

  @Test
  public void translateTestEnEs() {
    TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
    if(compareStrings("Esto es una prueba de servicio de traducción", translatedText.getTranslation()) > 1) {
      assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
    }
  }

  @Test
  public void translateTestEsEn() {
    TranslatedText translatedText = translatorService.translate("es", "en", "Esto es una prueba de servicio de traducción");
    if(compareStrings("This is a test of translation service", translatedText.getTranslation()) > 1) {
      assertEquals("This is a test of translation service", translatedText.getTranslation());
    } 
  }

  @Test
  public void translateTestDeEs() {
    TranslatedText translatedText = translatorService.translate("de", "es", "Dies ist ein test des übersetzungsdienst");
    if(compareStrings("Esto es una prueba de traducción", translatedText.getTranslation()) > 1) {
      assertEquals("Esto es una prueba de traducción", translatedText.getTranslation());
    }
  }
}
