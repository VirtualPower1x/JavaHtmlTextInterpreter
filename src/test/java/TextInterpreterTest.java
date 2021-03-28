import com.testapp.WordStatistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TextInterpreterTest {

    private final String TEST_SOURCE = "https://monolit-pro.ucoz.ru/test-pages/";

    @Test
    public void htmlReadingTest () {
        TreeMap<String, Integer> actualMap = WordStatistics.getFromUrl(TEST_SOURCE + "test.htm");
        HashMap<String, Integer> expectedMap =
                new HashMap<>(Map.of(
                        "в", 2,
                        "видит", 1,
                        "ехал", 1,
                        "зомби", 12,
                        "сунул", 1,
                        "через", 1,
                        "экспресс-тест", 1
                ));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void distortedHtmlReadingTest () {
        TreeMap<String, Integer> actualMap = WordStatistics.getFromUrl(TEST_SOURCE + "test_distorted.htm");
        TreeMap<String, Integer> expectedMap = new TreeMap<>();
        expectedMap.put("в", 2);
        expectedMap.put("гараж", 1);
        expectedMap.put("видит", 1);
        expectedMap.put("ехал", 1);
        expectedMap.put("зомби", 12);
        expectedMap.put("ктулху", 1);
        expectedMap.put("продам", 1);
        expectedMap.put("сунул", 1);
        expectedMap.put("телефон", 1);
        expectedMap.put("текст", 1);
        expectedMap.put("украл", 1);
        expectedMap.put("через", 1);
        expectedMap.put("экспресс-тест", 1);
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void invalidUrlTest () {
        String[] brokenUrls = {
                "bruh",
                "http://microsoft.com/xyzzy",
                "https://skillbox.ru/privacy_policy.pdf",
                "b.b"
        };
        for (String s : brokenUrls) {
            TreeMap<String, Integer> actualMap = WordStatistics.getFromUrl(s);
            Assert.assertEquals(Collections.emptyMap(), actualMap);
        }
    }
}
