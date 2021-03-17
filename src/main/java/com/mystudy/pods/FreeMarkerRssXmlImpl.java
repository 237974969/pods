/**
 * Copyright (c) 1999-2021 All Rights Reserved.
 */
package com.mystudy.pods;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mystudy.pods.service.keke.Course;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author 237974969
 * @version : FreeMarkerRssXmlImpl, v 0.1 2021/3/12 下午1:56 237974969 Exp $$
 */
 @Service
public class FreeMarkerRssXmlImpl implements MakeRssXml {

    @Override
    public String make(List<Course> courseList) {
        try {
            Configuration configuration = new Configuration();
            String templatePath = this.getClass().getClassLoader().getResource("").getPath()+"templates";
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            Template template = configuration.getTemplate("rssTemplate.ftl");
            StringWriter stringWriter = new StringWriter();
            Map data = new HashMap(1);
            data.put("courses", courseList);
            template.process(data, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return "生成出错";
    }
}
