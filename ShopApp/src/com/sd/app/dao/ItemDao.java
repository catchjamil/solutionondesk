package com.sd.app.dao;

import java.util.List;


import com.sd.app.model.ItemMaster;


public interface ItemDao {
	
	public void saveItem(ItemMaster itemMaster);
	public void saveSellItem(ItemMaster itemMaster);
	public List<ItemMaster> listSellItems();
	public List<ItemMaster> listOfAvailableItems();
	public List<ItemMaster> listBuyItems();
	public ItemMaster getItem(int id);
	public void deleteItem(int id);
	
}
