package com.mystudy.pods.service.keke.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.mystudy.pods.service.keke.Course;
import com.mystudy.pods.service.keke.CrawContext;

import okhttp3.*;

@Service
public class CrawContextImpl implements CrawContext {
    OkHttpClient okHttpClient = new OkHttpClient();
    String economist = "http://www.kekenet.com/Article/media/economist/";

    @Override
    public List<String> getMenus() {
        try {
            Request request = new Request.Builder().url(economist).get().build();
            Call call = okHttpClient.newCall(request);
            Response execute = call.execute();
            Document doc =  Jsoup.parse(execute.body().string());
            Element elementById = doc.getElementById("menu-list");
            List<String> urlList = new ArrayList<>();
            Iterator<Element> li = elementById.getElementsByTag("li").iterator();
            while(li.hasNext()){
                Element next = li.next();
                urlList.add(next.getElementsByTag("a").get(2).attr("href"));
            }
            return urlList;
        } catch (IOException e) {
            return null;
        }
    }

    public List<Course> getCourses(){
        List<Course> courseList = new ArrayList<>();
        List<String>  urls = getMenus();
        urls.forEach(each -> {
            try {
                Request request = new Request.Builder().url(each).get().build();
                ResponseBody body = okHttpClient.newCall(request).execute().body();
                Document parse = Jsoup.parse(body.string());
                String nrtitle = parse.getElementById("nrtitle").text();
                String lrc = null;
                for (Element script : parse.getElementsByTag("script")) {
                    if(StringUtils.contains(script.data(), "getLrcCon(")){
                        String lrcSource = StringUtils.substringBetween(script.data(), "getLrcCon(\"", "\"");
                        Request lrcRequest = new Request.Builder().url(lrcSource).get().build();
                        lrc = new String (okHttpClient.newCall(lrcRequest).execute().body().bytes(),"GB2312");
                    }
                }
                String audio = parse.getElementsByTag("audio").get(0).attr("src");
                Course course = new Course();
                course.setTitle(nrtitle);
                course.setDescription(lrc);
                course.setLink(audio);
                courseList.add(course);
            } catch (IOException e) {
                //doNothing
            }
        });

        return courseList;
    }
}
