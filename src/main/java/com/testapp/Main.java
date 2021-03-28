package com.testapp;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес требуемой страницы: ");
        String url = scanner.nextLine();
        System.out.println("Статистика использования уникальных слов: ");
        printTreeMap(WordStatistics.getFromUrl(url));
    }

    public static void printTreeMap (TreeMap<String, Integer> treeMap) {
        treeMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
