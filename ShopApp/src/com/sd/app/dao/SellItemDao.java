package com.sd.app.dao;

import java.util.List;

import com.sd.app.model.Item;


public interface SellItemDao {
	
	public void addItem(Item Items);

	public List<Item> listItems();
	
	public Item getItem(int id);
	
	public void deleteItem(Item item);
}
