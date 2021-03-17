/**
 * Copyright (c) 1999-2021 All Rights Reserved.
 */
package com.mystudy.pods;

import java.util.List;

import com.mystudy.pods.service.keke.Course;

/**
 * @author 237974969
 * @version : makeRssXml, v 0.1 2021/3/12 下午1:55 237974969 Exp $$
 */
public interface MakeRssXml {

    String make(List<Course> courseList);
}
