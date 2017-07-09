package gui;

import java.awt.Image;

public class SaleInfo {
private String itemName;
private String itemCat;
private String price;
private String cond;
private String description;
private String deliveroption;
private String path;
private Image image;

	public void addInfo(String itemName, String itemCat, String price2, String cond, String description, String deliveroption, String path2) {
		this.itemName = itemName;
		this.itemCat = itemCat;
		this.price = price2;
		this.cond = cond;
		this.description = description;
		this.deliveroption = deliveroption;
		this.path = path2;
		
	
	}

	public String getDeliveroption() {
		return deliveroption;
	}

	public void setDeliveroption(String deliveroption) {
		this.deliveroption = deliveroption;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCat() {
		return itemCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPath(String path) {
		this.path=path;
		
	}

	public String getPath() {
		return path;
	}

}
