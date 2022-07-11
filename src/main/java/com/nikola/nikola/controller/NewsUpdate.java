package com.nikola.nikola.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikola.nikola.models.News;
import com.nikola.nikola.repo.BusinessNewsRepo;
import com.nikola.nikola.repo.SportNewsRepo;
import com.nikola.nikola.repo.TechNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsUpdate {
    @Autowired
    BusinessNewsRepo businessNewsRepo;
    @Autowired
    TechNewsRepo techNewsRepo;
    @Autowired
    SportNewsRepo sportNewsRepo;

    public static final String BUSINESS_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=7c4d7ba91a3d4b1eb9e70a814d8c5fe5";
    public static final String TECH_URL = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=7c4d7ba91a3d4b1eb9e70a814d8c5fe5";

    public static final String SPORT_URL = "https://newsapi.org/v2/top-headlines?country=us&category=sport&apiKey=7c4d7ba91a3d4b1eb9e70a814d8c5fe5";

    @GetMapping(value="/news/business/update")
    public String updateBusinessNews() {
        String articles;
        try {
        URL obj = new URL(BUSINESS_URL);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                articles = response.toString();
                int secInd=articles.indexOf("[");
                articles=articles.replace(articles.substring(0,secInd+1),"");
                articles="["+articles;
                articles = articles.substring(0,articles.length()-1);
                ObjectMapper mapper = new ObjectMapper();
                List<Map<String, Object>> data = mapper.readValue(articles, new TypeReference<List<Map<String, Object>>>(){});
                for (int i = 0; i < 5; i++) {
                    News news = new News();
                    data.get(i).forEach((k,v)->{
                        if(k.equalsIgnoreCase("author")){
                            news.setAuthor(v.toString());
                        } else if (k.equalsIgnoreCase("title")) {
                            news.setTitle(v.toString());
                        } else if (k.equalsIgnoreCase("url")) {
                            news.setUrl(v.toString());
                        } else if (k.equalsIgnoreCase("urlToImage")) {
                            news.setUrl_img(v.toString());
                        }else if (k.equalsIgnoreCase("publishedAt")) {
                            news.setTime_published(v.toString());
                        }else if (k.equalsIgnoreCase("content")) {
                            news.setContent(v.toString());
                        }
                    });
                    businessNewsRepo.save(news);
                }
                return "success";
            } else {
                return "NOT Working";
            }
        } catch (Exception e){
            System.out.println("Error while processing");
        }
        return "Error = news not updated";
    }

    @GetMapping(value="/news/tech/update")
    public String updateTechNews() {
        String articles;
        try {
            URL obj = new URL(TECH_URL);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                articles = response.toString();
                int secInd=articles.indexOf("[");
                articles=articles.replace(articles.substring(0,secInd+1),"");
                articles="["+articles;
                articles = articles.substring(0,articles.length()-1);
                ObjectMapper mapper = new ObjectMapper();
                List<Map<String, Object>> data = mapper.readValue(articles, new TypeReference<List<Map<String, Object>>>(){});
                for (int i = 0; i < 5; i++) {
                    News news = new News();
                    data.get(i).forEach((k,v)->{
                        if(k.equalsIgnoreCase("author")){
                            news.setAuthor(v.toString());
                        } else if (k.equalsIgnoreCase("title")) {
                            news.setTitle(v.toString());
                        } else if (k.equalsIgnoreCase("url")) {
                            news.setUrl(v.toString());
                        } else if (k.equalsIgnoreCase("urlToImage")) {
                            news.setUrl_img(v.toString());
                        }else if (k.equalsIgnoreCase("publishedAt")) {
                            news.setTime_published(v.toString());
                        }else if (k.equalsIgnoreCase("content")) {
                            news.setContent(v.toString());
                        }
                    });
                    techNewsRepo.save(news);
                }
                return "success";
            } else {
                return "NOT Working";
            }
        } catch (Exception e){
            System.out.println("Error while processing");
        }
        return "Error = news not updated";
    }

    @GetMapping(value="/news/sport/update")
    public String updateSportNews() {
        String articles;
        try {
            URL obj = new URL(SPORT_URL);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                articles = response.toString();
                int secInd=articles.indexOf("[");
                articles=articles.replace(articles.substring(0,secInd+1),"");
                articles="["+articles;
                articles = articles.substring(0,articles.length()-1);
                ObjectMapper mapper = new ObjectMapper();
                List<Map<String, Object>> data = mapper.readValue(articles, new TypeReference<List<Map<String, Object>>>(){});
                for (int i = 0; i < 5; i++) {
                    News news = new News();
                    data.get(i).forEach((k,v)->{
                        if(k.equalsIgnoreCase("author")){
                            news.setAuthor(v.toString());
                        } else if (k.equalsIgnoreCase("title")) {
                            news.setTitle(v.toString());
                        } else if (k.equalsIgnoreCase("url")) {
                            news.setUrl(v.toString());
                        } else if (k.equalsIgnoreCase("urlToImage")) {
                            news.setUrl_img(v.toString());
                        }else if (k.equalsIgnoreCase("publishedAt")) {
                            news.setTime_published(v.toString());
                        }else if (k.equalsIgnoreCase("content")) {
                            news.setContent(v.toString());
                        }
                    });
                    sportNewsRepo.save(news);
                }
                return "success";
            } else {
                return "NOT Working";
            }
        } catch (Exception e){
            System.out.println("Error while processing");
        }
        return "Error = news not updated";
    }
}
