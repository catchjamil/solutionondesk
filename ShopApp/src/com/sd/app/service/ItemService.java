package com.sd.app.service;

import java.util.List;

import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;


public interface ItemService {
	
	public void saveItem(ItemMaster itemMasters);
	public void saveSellItem(ItemMaster itemMasters);
	public List<ItemMaster> listSellItems();
	public List<ItemMaster> listBuyItems();
	public List<ItemMaster> listOfAvailableItems();
	public ItemMaster getItem(int id);
	public Item getChildItem(int id);
	public void deleteItem(int id);
}
