package com.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class WordStatistics {

    private static final Logger foundWordsLogger = LogManager.getLogger("FoundWords");

    public static TreeMap<String, Integer> getFromUrl (String url) {
        HtmlLoader loader = new HtmlLoader(url);
        String text = loader.getHtmlText();
        String[] words = text.split("[\s ,.!?\";:—@\\[\\]()\n\r\t]");
        if (loader.isConnected()) {
            logFoundWords(words, "Actual words found on the page " + url + ":");
        }

        TreeMap<String, Integer> wordStatsTreeMap = Arrays.stream(words)
                .map(s -> s.replaceAll("[^a-zA-Z'’\\-а-яА-Я]", ""))
                .filter(s -> s.matches("[a-zA-Z'’а-яА-Я][a-zA-Z'’\\-а-яА-Я]*"))
                .map(s -> (Map.Entry<String, Integer>)
                        new AbstractMap.SimpleEntry<>(s.toLowerCase(Locale.ROOT), 1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, TreeMap::new));
        if (loader.isConnected()) {
            logWordStats(wordStatsTreeMap, "Unique words usage statistics for page " + url + ":");
        }
        return wordStatsTreeMap;
    }

    private static void logFoundWords (String[] words, String message) {
        foundWordsLogger.info(message);
        for (String word : words) {
            if (!word.trim().equalsIgnoreCase("")) {
                foundWordsLogger.info(word);
            }
        }
    }

    private static void logWordStats (TreeMap<String, Integer> statsTreeMap, String message) {
        foundWordsLogger.info(message);
        statsTreeMap.forEach((k, v) -> foundWordsLogger.info(k + " - " + v));
    }
}
