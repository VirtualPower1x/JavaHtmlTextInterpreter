package com.testapp;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес требуемой страницы: ");
        String url = scanner.nextLine();
        String textFromUrl = TextInterpreter.getTextFromUrl(url);
        if (!textFromUrl.equals("")) {
            System.out.println("Статистика использования уникальных слов: ");
            printTreeMap(TextInterpreter.parseText(textFromUrl));
        }
    }

    public static void printTreeMap (TreeMap<String, Integer> treeMap) {
        treeMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
