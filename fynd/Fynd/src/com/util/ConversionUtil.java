package com.util;

import java.util.ArrayList;
import java.util.List;


import com.fynd.dto.ItemDto;
import com.fynd.dto.SizeQuantityDto;
import com.fynd.entities.Item;
import com.fynd.entities.SizeQuantity;

public class ConversionUtil {
	
	public static List<ItemDto> converToItemDto(List<Item> list) {
		List<ItemDto> result = new ArrayList<ItemDto>();
		ItemDto itemDto;
		for(Item item : list) {
			itemDto=new ItemDto();
			itemDto.setItemName(item.getItemName());
			itemDto.setShadeName(item.getShadeName());
			itemDto.setMrp(item.getMrp());
			SizeQuantityDto sizeQuantityDto;
			List <SizeQuantityDto> sizeList= new ArrayList<SizeQuantityDto>();
			for(SizeQuantity sizeQuantity : item.getSize_quantity()){
				sizeQuantityDto= new SizeQuantityDto();
				sizeQuantityDto.setSize(sizeQuantity.getSize());
				sizeQuantityDto.setQuantity(sizeQuantity.getQuantity());
				sizeList.add(sizeQuantityDto);
			}
			itemDto.setSize_quantity(sizeList);
			result.add(itemDto);
		}
		return result;
	}

}
