package com.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.UnknownHostException;

public class HtmlLoader {

    private static final Logger exceptionsLogger = LogManager.getRootLogger();
    private static final Logger connectionsLogger = LogManager.getLogger("Connections");

    private final String htmlText;

    private boolean isConnected;

    public HtmlLoader (String url) {
        this.isConnected = false;
        this.htmlText = getTextFromUrl(url);
    }

    public String getHtmlText() {
        return this.htmlText;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    private String getTextFromUrl (String url) {
        try {
            if (!url.startsWith("http")) {
                url = "https://" + url;
            }
            Document doc = Jsoup.connect(url)
                    .maxBodySize(0)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            this.isConnected = true;
            connectionsLogger.info("Connected to: " + url);
            return Jsoup.parse(doc.outerHtml()).wholeText();
        }
        catch (UnknownHostException uhe) {
            System.err.println("Неверный адрес сервера");
            exceptionsLogger.catching(uhe);
            uhe.printStackTrace();
        }
        catch (IOException ioe) {
            System.err.println("Не удалось получить доступ к странице");
            exceptionsLogger.catching(ioe);
            ioe.printStackTrace();
        }
        catch (Exception e) {
            System.err.println("Неустановленная ошибка");
            exceptionsLogger.catching(e);
            e.printStackTrace();
        }
        return "";
    }
}
