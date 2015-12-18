package com.fynd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fynd.dto.ItemDto;
import com.fynd.services.ItemService;

@Controller
@RequestMapping("/items")  
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/list/", method = RequestMethod.GET)
	public List<ItemDto> getItems() {
		return itemService.getItems();
	}
	 
	   

}
