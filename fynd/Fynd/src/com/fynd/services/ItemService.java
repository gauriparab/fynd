package com.fynd.services;

import java.util.List;

import com.fynd.dto.ItemDto;
import com.fynd.entities.Item;

public interface ItemService {
	public List<ItemDto> getItems();
}
