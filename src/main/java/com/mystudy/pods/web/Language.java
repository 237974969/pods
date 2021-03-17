package com.mystudy.pods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mystudy.pods.MakeRssXml;
import com.mystudy.pods.service.keke.CrawContext;

@RestController
public class Language {
    @Autowired
    private CrawContext crawContext;
    @Autowired
    private MakeRssXml freeMarkerRssXmlImpl;

    @GetMapping(value = "/language",  produces = {"application/xml;charset=UTF-8"})
    public String language(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  freeMarkerRssXmlImpl.make(crawContext.getCourses());
    }


}
