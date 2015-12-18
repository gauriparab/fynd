package com.fynd.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class SizeQuantityDto implements Serializable{
	
	private int size;
	
	private int quantity;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public SizeQuantityDto() {
		super();
	}
	public SizeQuantityDto(int size, int quantity) {
		super();
		this.size = size;
		this.quantity = quantity;
	}
	
	
}
