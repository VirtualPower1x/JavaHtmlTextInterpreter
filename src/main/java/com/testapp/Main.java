package com.testapp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес требуемой страницы: ");
        String url = scanner.nextLine();
        String textFromUrl = TextInterpreter.getTextFromUrl(url);
        if (!textFromUrl.equals("")) {
            List<String> words = TextInterpreter.parseText(textFromUrl);
            System.out.println("Статистика использования уникальных слов: ");
            TextInterpreter.printTreeMap(TextInterpreter.getWordStatsFromList(words));
        }
    }
}
