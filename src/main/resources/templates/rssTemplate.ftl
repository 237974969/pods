<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0"
	xmlns:content="http://purl.org/rss/1.0/modules/content/"
	xmlns:wfw="http://wellformedweb.org/CommentAPI/"
	xmlns:dc="http://purl.org/dc/elements/1.1/"
	xmlns:atom="http://www.w3.org/2005/Atom"
	xmlns:sy="http://purl.org/rss/1.0/modules/syndication/"
	xmlns:slash="http://purl.org/rss/1.0/modules/slash/"
     xmlns:podcast="https://github.com/Podcastindex-org/podcast-namespace/blob/main/docs/1.0.md"
	xmlns:itunes="http://www.itunes.com/dtds/podcast-1.0.dtd"
xmlns:rawvoice="http://www.rawvoice.com/rawvoiceRssModule/"
xmlns:googleplay="http://www.google.com/schemas/play-podcasts/1.0"
>
<channel>
	<title>英语学徒</title>
	<atom:link href="" rel="self" type="application/rss+xml" />
	<description>英语学徒</description>
	<lastBuildDate></lastBuildDate>
	<language>zh-CN</language>
	<sy:updatePeriod>hourly</sy:updatePeriod>
	<sy:updateFrequency>1</sy:updateFrequency>
	<itunes:summary>英语学徒</itunes:summary>
	<itunes:author>英语学徒</itunes:author>
	<itunes:explicit>clean</itunes:explicit>
	<itunes:image href="http://dl.wasai.org/red.jpg" />
	<itunes:type>episodic</itunes:type>
	<itunes:owner>
		<itunes:name>英语学徒</itunes:name>
		<itunes:email>xpmail2014@163.com</itunes:email>
	</itunes:owner>
	<managingEditor>英语学徒</managingEditor>
	<copyright>Copyright &#xA9; 英语学徒</copyright>
	<itunes:subtitle>英语学徒</itunes:subtitle>
	<image>
		<title>英语学徒</title>
	</image>
	<itunes:category text="Comedy" />
	<googleplay:category text="Comedy"/>
	<itunes:category text="Society &amp; Culture" />
	<itunes:category text="Technology" />
	<#if courses??>
	    <#list  courses as course>
            <item>
                <title>${course.title}</title>
                <pubDate></pubDate>
                <guid isPermaLink="false"></guid>
                <comments></comments>
                <wfw:commentRss></wfw:commentRss>
                <slash:comments>0</slash:comments>
                <category><![CDATA[听力洗耳朵]]></category>
                <description><![CDATA[${course.description}]]></description>
                <enclosure url="${course.link}"  type="audio/mpeg" />
                <itunes:subtitle>${course.title}</itunes:subtitle>
                <itunes:summary><![CDATA[${course.title}]]></itunes:summary>
                <itunes:author>听力小课堂</itunes:author>
                <itunes:season>1</itunes:season>
            </item>
	    </#list>
	</#if>


</channel>
</rss>
