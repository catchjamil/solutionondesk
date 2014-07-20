package com.sd.app.service;

import java.util.List;

import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;


public interface ItemService {
	
	public void addItem(Item item);
	public void saveSellItems(ItemMaster itemMaster);
	public List<ItemMaster> listSellItems();
	public List<Item> listItems();
	
	public Item getItem(int id);
	
	public void deleteItem(Item items);
}
