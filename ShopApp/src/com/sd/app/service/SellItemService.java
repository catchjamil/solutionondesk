package com.sd.app.service;

import java.util.List;

import com.sd.app.model.Item;


public interface SellItemService {
	
	public void addItem(Item item);

	public List<Item> listItems();
	
	public Item getItem(int id);
	
	public void deleteItem(Item items);
}
