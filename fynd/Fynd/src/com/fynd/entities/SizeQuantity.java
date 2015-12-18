package com.fynd.entities;

import javax.persistence.*;

@Entity
@Table(name="SIZE_QUANTITY")
public class SizeQuantity {
	
	@Id
	@Column(name="size")
	private int size;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="item_name")
	private Item item;
	
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
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public SizeQuantity(int size, int quantity, Item item) {
		super();
		this.size = size;
		this.quantity = quantity;
		this.item = item;
	}
	public SizeQuantity(){
		
	}
	
	
	
	
}
