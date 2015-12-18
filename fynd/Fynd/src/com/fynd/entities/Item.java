package com.fynd.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "ITEM")
public class Item {
	
	@Id
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "shade_name")
	private String shadeName;
	
	@Column(name = "mrp")
	private float mrp;
	
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private List<SizeQuantity> size_quantity;
	
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
	public List<SizeQuantity> getSize_quantity() {
		return size_quantity;
	}
	public void setSize_quantity(List<SizeQuantity> size_quantity) {
		this.size_quantity = size_quantity;
	}
	public Item(String itemName, String shadeName, float mrp,
			List<SizeQuantity> size_quantity) {
		super();
		this.itemName = itemName;
		this.shadeName = shadeName;
		this.mrp = mrp;
		this.size_quantity = size_quantity;
	}
	public Item(String itemName, String shadeName, float mrp) {
		super();
		this.itemName = itemName;
		this.shadeName = shadeName;
		this.mrp = mrp;
	}
	
	public Item(){
		
	}
	
	
	
}
