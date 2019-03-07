package com.example.myproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.model.Reptile;

@RestController
@RequestMapping("/reptile")
public class ReptileController {
	@RequestMapping("/get")
	public String index(Reptile reptile) throws IOException {
		
		if ("1".equals("2")) {
			Connection conn = null; //btlibray;
			conn = Jsoup.connect("http://btlibrary.co/b/ez5z74vZ7e_3zHq-Z8aLrdsB/1/0/0.html").timeout(50000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
			Document doc;
			doc = conn.get();
			StringBuffer sbf = new StringBuffer();
			Elements search = doc.getElementsByClass("item-title");
			for (Element e : search) {
				sbf.append("magnet:?xt=urn:btih:" + e.getElementsByClass("item-title").first().children().last().attr("href").toString().substring(6,46) + "\n");
			}
			return (sbf.toString());
		} else {
			String url = "http://renrencili.pw/query/%E7%99%BD%E8%9B%87%EF%BC%9A%E7%BC%98%E8%B5%B7/1-0-0/";
			Connection conn = null; //renrencili;
			conn = Jsoup.connect(url).timeout(50000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
			Document doc;
			doc = conn.get();
			StringBuffer sbf = new StringBuffer();
			Elements search = doc.getElementsByClass("attr");
			List<String> urls = new ArrayList();
			for (Element e : search) {
				urls.add("http://renrencili.pw/magnet/" + e.getElementsByClass("attr").first().children().last().children().last().attr("href").toString().substring(8,35));
			}
			for (String str : urls) {
				conn = Jsoup.connect(str).timeout(50000);
				doc = conn.get();
				search = doc.getElementsByClass("torrent");
				for (Element e : search) {
					sbf.append(e.getElementsByClass("torrent").first().children());					
				}
			}
			
			
			System.out.println(urls);
			return (sbf.toString());
		}
		
		
		//return null;
	}
	
	
}
