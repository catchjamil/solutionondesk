package com.sd.app.dao;

import java.util.List;

import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;


public interface ItemDao {
	
	public void addItem(Item Items);
	public void addSellItem(ItemMaster Items);
	public List<ItemMaster> listSellItems();

	public List<Item> listItems();
	
	public Item getItem(int id);
	
	public void deleteItem(Item item);
}
