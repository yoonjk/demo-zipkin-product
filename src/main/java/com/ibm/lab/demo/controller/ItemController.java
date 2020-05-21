package com.ibm.lab.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.lab.demo.domain.Item;

@RestController
@RequestMapping("/products")
public class ItemController {
	@Autowired
	HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@GetMapping("/{name}/items")
	public List<Item> getItem(@PathVariable String name){
		logger.info("getItem "+name);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("computer",1));
		itemList.add(new Item("mouse",2));
		// print header for tracing
		getHeadersInfo(request);
		return itemList;
	}
	
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key+":"+value);
            map.put(key, value);
        }

        return map;
    }
	
	
}