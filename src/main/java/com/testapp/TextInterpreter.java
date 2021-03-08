package com.testapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

public class TextInterpreter {

    public static String getTextFromUrl (String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .maxBodySize(0)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Jsoup.parse(doc.outerHtml()).wholeText();
            return Jsoup.parse(doc.outerHtml()).wholeText();
        }
        catch (IllegalArgumentException iae) {
            System.err.println("Неверный адрес веб-страницы");
            iae.printStackTrace();
        }
        catch (UnknownHostException uhe) {
            System.err.println("Неверный хост");
            uhe.printStackTrace();
        }
        catch (IOException ioe) {
            System.err.println("Ошибка ввода/вывода");
            ioe.printStackTrace();
        }
        catch (Exception e) {
            System.err.println("Неустановленная ошибка");
            e.printStackTrace();
        }
        return "";
    }

    public static TreeMap<String, Integer> parseText (String text) {
        return Arrays.stream(text.split("[\s,.!?\";:+#=*/0-9@%—\\[\\]()\n\r\t]"))
                .filter(s -> s.matches("[a-zA-Z'’а-яА-Я][a-zA-Z'’\\-а-яА-Я]*"))
                .map(s -> (Map.Entry<String, Integer>) new AbstractMap.SimpleEntry<>(s.toLowerCase(Locale.ROOT), 1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, TreeMap::new));
    }
}
