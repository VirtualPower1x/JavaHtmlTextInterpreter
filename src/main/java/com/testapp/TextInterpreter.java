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
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            return Jsoup.parse(doc.outerHtml()).wholeText();
        }
        catch (IllegalArgumentException iae) {
            System.out.println("Неверный адрес веб-страницы");
            iae.printStackTrace();
        }
        catch (UnknownHostException uhe) {
            System.out.println("Неверный хост");
            uhe.printStackTrace();
        }
        catch (IOException ioe) {
            System.out.println("Ошибка ввода/вывода");
            ioe.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Неустановленная ошибка");
            e.printStackTrace();
        }
        return "";
    }

    public static List<String> parseText (String text) {
        return Arrays.stream(text.split("[\s,.!?\";:+#=*/0-9@%—\\[\\]()\n\r\t]"))
                .filter(s -> s.matches("[a-zA-Z'’а-яА-Я][a-zA-Z'’\\-а-яА-Я]*"))
                .collect(Collectors.toList());
    }

    public static TreeMap<String, Integer> getWordStatsFromList (List <String> words) {
        TreeMap<String, Integer> wordStats = new TreeMap<>(Collections.emptyMap());
        for (String s : words) {
            s = s.toLowerCase(Locale.ROOT);
            if (wordStats.containsKey(s)) {
                wordStats.replace(s, wordStats.get(s) + 1);
            }
            else {
                wordStats.put(s, 1);
            }
        }
        return wordStats;
    }

    public static void printTreeMap (TreeMap<String, Integer> treeMap) {
        treeMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
