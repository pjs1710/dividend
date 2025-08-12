package com.sample.dayone;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DayoneApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DayoneApplication.class, args);

        try {
            Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/KO/history/?frequency=1mo&period1=1597225902&period2=1754992298");
            Document document = connection.get();
            Elements eles = document.getElementsByAttributeValue("data-test", "historical-prices");
            Element ele = eles.getFirst(); // table 전체

            Element tbody = ele.children().get(1);
            for (Element e : tbody.children()) {
                String text = e.text();
                if (!text.endsWith("Dividend")) {
                    continue;
                }
                String[] splits = text.split(" ");
                String month = splits[0];
                int day = Integer.valueOf(splits[1].replace(",", ""));
                int year = Integer.valueOf(splits[2]);
                String dividend = splits[3];

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
