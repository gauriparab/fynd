package com.fynd.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fynd.entities.SizeQuantity;
public class ItemDto implements Serializable{
	private String itemName;
	private String shadeName;
	private float mrp;
	private List<SizeQuantityDto> size_quantity;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getShadeName() {
		return shadeName;
	}
	public void setShadeName(String shadeName) {
		this.shadeName = shadeName;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public List<SizeQuantityDto> getSize_quantity() {
		return size_quantity;
	}
	public void setSize_quantity(List<SizeQuantityDto> size_quantity) {
		this.size_quantity = size_quantity;
	}
	
	
	public ItemDto() {
		super();
	}
	public ItemDto(String itemName, String shadeName, float mrp,
			List<SizeQuantityDto> size_quantity) {
		super();
		this.itemName = itemName;
		this.shadeName = shadeName;
		this.mrp = mrp;
		this.size_quantity = size_quantity;
	}
	
	

}
