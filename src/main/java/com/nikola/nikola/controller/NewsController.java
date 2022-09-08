package com.nikola.nikola.controller;

import com.nikola.nikola.models.News;
import com.nikola.nikola.repo.BusinessNewsRepo;
import com.nikola.nikola.repo.SportNewsRepo;
import com.nikola.nikola.repo.TechNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class NewsController {
    @Autowired
    BusinessNewsRepo businessNewsRepo;
    @Autowired
    TechNewsRepo techNewsRepo;
    @Autowired
    SportNewsRepo sportNewsRepo;

    @GetMapping(value="/news/business")
    public List<News> getBusinessNews(){
        List<News> allNews = businessNewsRepo.findAll();
        List<News> businessNews = new ArrayList<>();
        for (int i = 0; i < allNews.size(); i++) {
            if (allNews.get(i).getCategory().equalsIgnoreCase("business")){
                businessNews.add(allNews.get(i));
            }
        }
        return businessNews;
    }
    @GetMapping(value="/news/tech")
    public List<News> getTechNews(){
        List<News> allNews = techNewsRepo.findAll();
        List<News> techNews = new ArrayList<>();
        for (int i = 0; i < allNews.size(); i++) {
            if (allNews.get(i).getCategory().equalsIgnoreCase("tech")){
                techNews.add(allNews.get(i));
            }
        }
        return techNews;
    }

    @GetMapping(value="/news/sport")
    public List<News> getSportNews(){
        List<News> allNews = sportNewsRepo.findAll();
        List<News> sportNews = new ArrayList<>();
        for (int i = 0; i < allNews.size(); i++) {
            if (allNews.get(i).getCategory().equalsIgnoreCase("sport")){
                sportNews.add(allNews.get(i));
            }
        }
        return sportNews;
    }




}
