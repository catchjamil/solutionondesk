package com.sd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sd.app.dao.ItemDao;
import com.sd.app.model.Item;
import com.sd.app.model.ItemMaster;

@Service("itemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveItem(ItemMaster itemMaster) {
		itemDao.saveItem(itemMaster);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSellItem(ItemMaster itemMaster) {
		itemDao.saveSellItem(itemMaster);
	}
	
	public List<ItemMaster> listBuyItems() {
		return itemDao.listBuyItems();
	}

	public ItemMaster getItem(int empid) {
		return itemDao.getItem(empid);
	}
	
	public void deleteItem(int id) {
		itemDao.deleteItem(id);
	}
	
	@Override
	public List<ItemMaster> listSellItems() {
		return itemDao.listSellItems();
	}

	@Override
	public List<ItemMaster> listOfAvailableItems() {
		return itemDao.listOfAvailableItems();
	}

	@Override
	public Item getChildItem(int id) {
		return itemDao.getChildItem(id);
	}


}
