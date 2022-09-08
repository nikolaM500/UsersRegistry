package com.nikola.nikola.controller;

import com.nikola.nikola.models.News;
import com.nikola.nikola.repo.BusinessNewsRepo;
import com.nikola.nikola.repo.SportNewsRepo;
import com.nikola.nikola.repo.TechNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return businessNewsRepo.findAll();}
    @GetMapping(value="/news/tech")
    public List<News> getTechNews(){
        List<News> techNews = techNewsRepo.findAll();
        techNews.removeIf(news -> !news.getCategory().equalsIgnoreCase("tech"));
        return techNews;
    }

    @GetMapping(value="/news/sport")
    public List<News> getSportNews(){return sportNewsRepo.findAll();}




}
