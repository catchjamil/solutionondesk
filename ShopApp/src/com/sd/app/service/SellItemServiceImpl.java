package com.sd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sd.app.dao.ItemDao;
import com.sd.app.model.Item;

@Service("sellItemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SellItemServiceImpl implements SellItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addItem(Item item) {
		itemDao.addItem(item);
	}
	
	public List<Item> listItems() {
		return itemDao.listItems();
	}

	public Item getItem(int empid) {
		return itemDao.getItem(empid);
	}
	
	public void deleteItem(Item item) {
		itemDao.deleteItem(item);
	}

}
